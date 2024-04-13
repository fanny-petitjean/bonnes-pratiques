package org.mines.civilstate.domain.model;

import java.util.UUID;

public record Religion(UUID id, String religion) {
    public static final class ReligionBuilder {
        private UUID id;
        private String religion;

        private ReligionBuilder() {
        }

        public static ReligionBuilder aReligion() {
            return new ReligionBuilder();
        }

        public ReligionBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public ReligionBuilder withReligion(String religion) {
            this.religion = religion;
            return this;
        }




        public Religion build() {
            return new Religion(id, religion);
        }
    }
}
