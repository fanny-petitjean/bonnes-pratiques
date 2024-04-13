package org.mines.civilstate.domain.model;

import java.util.UUID;

public record Langage(UUID id, String langage) {
    public static final class LangageBuilder {
        private UUID id;
        private String langage;

        private LangageBuilder() {
        }

        public static LangageBuilder aLangage() {
            return new LangageBuilder();
        }

        public LangageBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public LangageBuilder withLangage(String langage) {
            this.langage = langage;
            return this;
        }


        public Langage build() {
            return new Langage(id, langage);
        }
    }
}
