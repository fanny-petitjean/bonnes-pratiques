package org.mines.civilstate.port.driven;

import org.mines.civilstate.domain.model.BirthDate;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface BirthDateRepositoryPort {


    Optional<BirthDate> select(UUID uuid);

    Collection<BirthDate> selectAll();

    BirthDate insert(BirthDate birthDate);

    BirthDate update(BirthDate birthDate);

    void delete(UUID uuid);
}
