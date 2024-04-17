package org.mines.civilstate.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mines.civilstate.port.driven.BirthDateRepositoryPort;

import org.mines.civilstate.domain.model.BirthDate;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BirthDateServiceTest {
    private BirthDateRepositoryPort birthDateRepositoryPort;
    private BirthDateService birthDateService;

    @BeforeEach
    void setUp() {
        birthDateRepositoryPort = mock(BirthDateRepositoryPort.class);
        birthDateService = new BirthDateService(birthDateRepositoryPort);
    }

    @Test
    void save() {
        UUID id = UUID.randomUUID();
        when(birthDateRepositoryPort.insert(any())).thenReturn(BirthDate.BirthDateBuilder.aBirthDate()
                        .withId(id)
                        .withDay(1)
                .withMonth(1)
                .withYear(2000)
                .build());

        BirthDate birthDate = BirthDate.BirthDateBuilder.aBirthDate()
                .withDay(1)
                .withMonth(1)
                .withYear(2000)
                .build();
        BirthDate savedBirthDate = birthDateService.save(birthDate);

        assertNotNull(savedBirthDate);
        assertEquals(id, savedBirthDate.id());
        assertEquals(1, savedBirthDate.day());
        assertEquals(1, savedBirthDate.month());
        assertEquals(2000, savedBirthDate.year());
    }

    @Test
    void list() {
        BirthDateRepositoryPort birthDateRepositoryPort = mock(BirthDateRepositoryPort.class);
        BirthDate birthDate1 = BirthDate.BirthDateBuilder.aBirthDate()
                .withId(UUID.randomUUID())
                .withDay(1)
                .withMonth(1)
                .withYear(2000)
                .build();

        BirthDate birthDate2 = BirthDate.BirthDateBuilder.aBirthDate()
                .withId(UUID.randomUUID())
                .withDay(2)
                .withMonth(2)
                .withYear(2001)
                .build();

        Collection<BirthDate> birthDates = Arrays.asList(birthDate1, birthDate2);
        when(birthDateRepositoryPort.selectAll()).thenReturn(birthDates);

        BirthDateService birthDateService = new BirthDateService(birthDateRepositoryPort);

        Collection<BirthDate> retrievedBirthDates = birthDateService.list();

        assertEquals(2, retrievedBirthDates.size());

    }

    @Test
    void get() {
    }

    @Test
    void remove() {
    }

    @Test
    void findEndPeriodOfBirth() {
        BirthDateRepositoryPort birthDateRepositoryPort = mock(BirthDateRepositoryPort.class);

        BirthDate birthDate1 = BirthDate.BirthDateBuilder.aBirthDate()
                .withId(UUID.randomUUID())
                .withDay(1)
                .withMonth(1)
                .withYear(2012)
                .build();

        BirthDate birthDate2 = BirthDate.BirthDateBuilder.aBirthDate()
                .withId(UUID.randomUUID())
                .withDay(2)
                .withMonth(2)
                .withYear(2001)
                .build();

        Collection<BirthDate> birthDates = Arrays.asList(birthDate1, birthDate2);

        when(birthDateRepositoryPort.selectAll()).thenReturn(birthDates);

        BirthDateService birthDateService = new BirthDateService(birthDateRepositoryPort);

        Collection<BirthDate> retrievedBirthDates = birthDateService.findEndPeriodOfBirth(1,1,2005);
        Collection<BirthDate> res = Arrays.asList(birthDate2);
        assertEquals(res, retrievedBirthDates);

    }
}