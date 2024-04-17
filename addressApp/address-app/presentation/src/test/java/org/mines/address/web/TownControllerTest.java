package org.mines.address.web;

import org.junit.jupiter.api.Test;
import org.mines.address.api.model.Birthdate;
import org.mines.address.domain.model.Town;
import org.mines.address.port.driving.TownUseCase;
import org.mines.address.web.config.WebTestConfig;
import org.mines.address.web.controller.BirthDateController;
import org.mines.address.web.controller.TownController;
import org.mines.civilstate.domain.model.BirthDate;
import org.mines.civilstate.port.driving.BirthDateUseCase;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TownController.class)
@AutoConfigureMockMvc
@Import(WebTestConfig.class)
public class TownControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TownUseCase townUseCase;

    @Test
    void shouldGetATown() throws Exception {
        // Given
        UUID uuid = UUID.randomUUID();

        // When
        when(townUseCase.get(uuid)).thenReturn(Optional.of(
                Town.TownBuilder.aTown().withId(uuid).withName("some town").build()
        ));

        // Then
        mockMvc.perform(MockMvcRequestBuilders.get("/town/%s".formatted(uuid.toString()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("some town"));

    }

    @Test
    void shouldNotGetInstanceData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/town/%s".formatted(UUID.randomUUID().toString()))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Mock
    private BirthDateUseCase birthDateUseCase;

    @InjectMocks
    private BirthDateController birthDateController;

    @Test
    void testGetBirthdate() {
        // Given
        UUID id = UUID.randomUUID();
        BirthDate birthDate = new BirthDate.BirthDateBuilder()
                .withId(id)
                .withDay(10)
                .withMonth(4)
                .withYear(1990)
                .build();
        when(birthDateUseCase.get(id)).thenReturn(Optional.of(birthDate));

        // When
        ResponseEntity<Birthdate> responseEntity = birthDateController.getBirthdate(id.toString());

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(id.toString(), responseEntity.getBody().getId());
        assertEquals(10, responseEntity.getBody().getDay());
        assertEquals(4, responseEntity.getBody().getMonth());
        assertEquals(1990, responseEntity.getBody().getYear());
    }

    @Test
    void testListBirthdates() {
        // Given
        BirthDate birthDate = new BirthDate.BirthDateBuilder()
                .withId(UUID.randomUUID())
                .withDay(10)
                .withMonth(4)
                .withYear(1990)
                .build();
        List<BirthDate> birthDates = Collections.singletonList(birthDate);
        when(birthDateUseCase.list()).thenReturn(birthDates);

        // When
        ResponseEntity<List<Birthdate>> responseEntity = birthDateController.listBirthdates();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, responseEntity.getBody().size());
        assertEquals(birthDate.id().toString(), responseEntity.getBody().get(0).getId());
        assertEquals(10, responseEntity.getBody().get(0).getDay());
        assertEquals(4, responseEntity.getBody().get(0).getMonth());
        assertEquals(1990, responseEntity.getBody().get(0).getYear());
    }
}
