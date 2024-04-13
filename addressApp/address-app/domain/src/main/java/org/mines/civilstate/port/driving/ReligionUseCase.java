package org.mines.civilstate.port.driving;

import org.mines.civilstate.domain.model.Langage;
import org.mines.civilstate.domain.model.Religion;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ReligionUseCase {

    Religion save(Religion country);

    Collection<Religion> list();
    Optional<Religion> get(UUID uuid);

    void remove(UUID uuid);
    Collection<Religion> findByCountry(UUID id);

}
