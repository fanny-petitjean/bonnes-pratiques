package org.mines.civilstate.port.driving;

import org.mines.address.domain.model.Town;
import org.mines.civilstate.domain.model.BirthDate;
import org.mines.civilstate.domain.model.Country;
import org.mines.civilstate.domain.model.Target;

import javax.sound.midi.Track;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface TargetUseCase {

    Target save(Target target);

    Collection<Target> list();
    Optional<Target> get(UUID uuid);
    Collection<Target> findByTownAndBirthDate(Town town, BirthDate birthDate);

    void remove(UUID uuid);
}
