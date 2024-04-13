package org.mines.civilstate.port.driven;

import org.mines.address.domain.model.Town;
import org.mines.civilstate.domain.model.Religion;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ReligionRepositoryPort {

    Optional<Religion> select(UUID uuid);

    Collection<Religion> selectAll();

    Religion insert(Religion religion);

    Religion update(Religion religion);

    void delete(UUID uuid);
}
