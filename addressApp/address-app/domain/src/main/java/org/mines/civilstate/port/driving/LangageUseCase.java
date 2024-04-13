package org.mines.civilstate.port.driving;

import org.mines.address.domain.model.Town;
import org.mines.civilstate.domain.model.Country;
import org.mines.civilstate.domain.model.Langage;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface LangageUseCase {

    Langage save(Langage langage);

    Collection<Langage> list();
    Optional<Langage> get(UUID uuid);

    void remove(UUID uuid);
    Collection<Langage> findByCountry(UUID id);

}
