package org.mines.address.infrastructure.repository;

import org.address.infrastructure.config.PersistenceTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mines.address.domain.model.Address;
import org.mines.address.domain.model.Town;
import org.mines.address.port.driven.AddressRepositoryPort;
import org.mines.address.port.driven.TownRepositoryPort;
import org.mines.civilstate.domain.model.BirthDate;
import org.mines.civilstate.domain.service.BirthDateService;
import org.mines.civilstate.port.driven.BirthDateRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(SpringExtension.class)
@TestExecutionListeners({SqlScriptsTestExecutionListener.class, TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(classes = {PersistenceTestConfig.class})
@Sql(scripts = {"/data/clear.sql","/data/birthdate.sql"})
class BirthDateRepositoryAdapterTest {
    @Autowired
    private BirthDateRepositoryAdapter birthDateRepository;

    /*@Test
    public void shouldFindAll() {
        Collection<BirthDate> all = birthDateRepository.selectAll();

        assertEquals(1, all.size());
    }*/

    @Test
    public void shouldInsertABirthDate() {
        // GIVEN
        UUID id = UUID.randomUUID();
        BirthDate birthDate = BirthDate.BirthDateBuilder.aBirthDate()
                .withId(id)
                .withDay(11)
                .withMonth(4)
                .withYear(2003)
                .build();

        // WHEN
        BirthDate persisted = birthDateRepository.insert(birthDate);

        // THEN
        assertNotNull(persisted.id()); // Vérifie si l'ID généré n'est pas nul
        assertEquals(birthDate.day(), persisted.day());
        assertEquals(birthDate.month(), persisted.month());
        assertEquals(birthDate.year(), persisted.year());

        // Vérifie si la date de naissance insérée est présente dans la base de données
        Optional<BirthDate> retrievedBirthDate = birthDateRepository.select(persisted.id());
        assertTrue(retrievedBirthDate.isPresent());
        assertEquals(persisted, retrievedBirthDate.get());
    }



    /*@Test
    void shouldDeleteABirthDate() {
        birthDateRepository.delete(UUID.fromString("fb74d086-5a4a-11e7-907b-a6006ad3dba0"));
    }*/
}