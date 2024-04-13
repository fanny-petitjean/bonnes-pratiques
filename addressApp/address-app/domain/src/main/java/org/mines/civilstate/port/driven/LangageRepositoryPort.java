package org.mines.civilstate.port.driven;

import org.mines.address.domain.model.Town;
import org.mines.civilstate.domain.model.Langage;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface LangageRepositoryPort {

    Optional<Langage> select(UUID uuid);

    Collection<Langage> selectAll();

    Langage insert(Langage langage);

    Langage update(Langage langage);

    void delete(UUID uuid);
}
