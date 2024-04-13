package org.mines.civilstate.domain.model;

import java.util.UUID;

public record BirthDate(UUID id, int day, int month, int year) {
    public static final class BirthDateBuilder {
        private UUID id;
        private int day;
        private int month;
        private int year;

        private void BirthDateBuilder() {
        }

        public static BirthDateBuilder aBirthDate() {
            return new BirthDateBuilder();
        }

        public BirthDateBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public BirthDateBuilder withDay(int day) {
            this.day = day;
            return this;
        }

        public BirthDateBuilder withMonth(int month) {
            this.month = month;
            return this;
        }
        public BirthDateBuilder withYear(int year) {
            this.year = year;
            return this;
        }

        public BirthDate build() {
            return new BirthDate(id, day, month, year);
        }
    }
}
