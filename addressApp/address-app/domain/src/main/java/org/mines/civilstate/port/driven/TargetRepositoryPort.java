package org.mines.civilstate.port.driven;

import org.mines.address.domain.model.Town;
import org.mines.civilstate.domain.model.Target;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface TargetRepositoryPort {

    Optional<Target> select(UUID uuid);

    Collection<Target> selectAll();

    Target insert(Target target);

    Target update(Target target);

    void delete(UUID uuid);
}
