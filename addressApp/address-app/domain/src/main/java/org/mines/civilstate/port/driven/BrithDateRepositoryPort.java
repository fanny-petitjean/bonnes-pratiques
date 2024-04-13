package org.mines.civilstate.port.driven;

import org.mines.address.domain.model.Address;
import org.mines.civilstate.domain.model.BirthDate;
import org.mines.civilstate.domain.model.Country;

import java.util.Collection;

public interface BrithDateRepositoryPort {

    BirthDate insert(BirthDate birthDate);

    Collection<BirthDate> selectAll();
}
