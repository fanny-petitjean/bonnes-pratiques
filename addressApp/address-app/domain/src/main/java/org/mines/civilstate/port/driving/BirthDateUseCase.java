package org.mines.civilstate.port.driving;

import org.mines.address.domain.model.Address;
import org.mines.address.domain.model.Town;
import org.mines.civilstate.domain.model.BirthDate;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface BirthDateUseCase {

    BirthDate save(BirthDate birthDate);

    Collection<BirthDate> list();
    Optional<BirthDate> get(UUID uuid);
    Collection<BirthDate> findPeriodOfBirth(int beginDay, int endDay, int beginMonth, int endMonth, int beginYear, int endYear);
    Collection<BirthDate> findStartPeriodOfBirth(int beginDay, int beginMonth, int beginYear);
    Collection<BirthDate> findEndPeriodOfBirth( int endDay, int endMonth, int endYear);
    void remove(UUID uuid);
}
