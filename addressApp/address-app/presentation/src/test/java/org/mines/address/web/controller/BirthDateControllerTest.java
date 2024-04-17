package org.mines.address.web.controller;

import org.junit.jupiter.api.Test;
import org.mines.address.api.model.Birthdate;
import org.mines.civilstate.domain.model.BirthDate;
import org.mines.civilstate.port.driving.BirthDateUseCase;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BirthDateControllerTest {
    @Mock
    private BirthDateUseCase birthDateUseCase;

    @Test
    void shouldReturnBirthdateById() {
        // Given
        UUID id = UUID.randomUUID();
        BirthDate birthDate = new BirthDate.BirthDateBuilder()
                .withId(id)
                .withDay(15)
                .withMonth(4)
                .withYear(1990)
                .build();

        when(birthDateUseCase.get(id)).thenReturn(Optional.of(birthDate));

        BirthDateController controller = new BirthDateController(birthDateUseCase);

        // When
        ResponseEntity<Birthdate> responseEntity = controller.getBirthdate(id.toString());

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Birthdate returnedBirthdate = responseEntity.getBody();
        assertEquals(id.toString(), returnedBirthdate.getId());
        assertEquals(15, returnedBirthdate.getDay());
        assertEquals(4, returnedBirthdate.getMonth());
        assertEquals(1990, returnedBirthdate.getYear());

        verify(birthDateUseCase, times(1)).get(id);
    }

    @Test
    void shouldReturnNotFoundForNonExistingBirthdate() {
        // Given
        UUID id = UUID.randomUUID();
        when(birthDateUseCase.get(id)).thenReturn(Optional.empty());

        BirthDateController controller = new BirthDateController(birthDateUseCase);

        // When
        ResponseEntity<Birthdate> responseEntity = controller.getBirthdate(id.toString());

        // Then
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        verify(birthDateUseCase, times(1)).get(id);
    }

}