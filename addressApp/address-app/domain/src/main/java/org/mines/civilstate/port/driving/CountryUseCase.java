package org.mines.civilstate.port.driving;

import org.mines.civilstate.domain.model.BirthDate;
import org.mines.civilstate.domain.model.Country;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface CountryUseCase {

    Country save(Country country);

    Collection<Country> list();
    Optional<Country> get(UUID uuid);

    void remove(UUID uuid);
}
