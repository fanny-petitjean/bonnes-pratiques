package org.mines.civilstate.domain.model;
import java.util.UUID;

public record Target(UUID uuid, String firstName, String lastName, BirthDate birthDate, Town town) {
    public static final class TargerBuilder {
        private UUID id;
        private BirthDate birthDate;
        private Town town;
        private String firstName;
        private String lastName;

        private TargerBuilder() {
        }

        public static TargerBuilder aReligion() {
            return new TargerBuilder();
        }

        public TargerBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public TargerBuilder withBirthDate(BirthDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public TargerBuilder withTown(Town town) {
            this.town = town;
            return this;
        }

        public TargerBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public TargerBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Target build() {
            return new Target(id, firstName, lastName, birthDate, town);
        }
    }
}
