package org.mines.civilstate.port.driven;

import org.mines.address.domain.model.Town;
import org.mines.civilstate.domain.model.BirthDate;
import org.mines.civilstate.domain.model.Country;

import java.util.Collection;
import java.util.UUID;

public interface CountryRepositoryPort {

    Country select(UUID uuid);
    Collection<Country> selectAll();
    Country insert(Country country);

    Country update(Country country);

    void delete(UUID uuid);
}
