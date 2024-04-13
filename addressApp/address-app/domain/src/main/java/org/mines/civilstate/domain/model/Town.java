package org.mines.civilstate.domain.model;

import java.util.Collection;
import java.util.UUID;

public record Town (UUID id, int postCode, String name, Country country) {

    public static final class TownBuilder {
        private UUID id;
        private int postCode;
        private String name;
        private Country country;

        private TownBuilder() {
        }

        public static TownBuilder aTown() {
            return new TownBuilder();
        }

        public TownBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public TownBuilder withPostCode(int postCode) {
            this.postCode = postCode;
            return this;
        }

        public TownBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public TownBuilder withName(Country country) {
            this.country = country;
            return this;
        }
        public Town build() {
            return new Town(id, postCode, name, country);
        }
    }
}
