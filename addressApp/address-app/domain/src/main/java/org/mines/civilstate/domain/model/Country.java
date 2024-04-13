package org.mines.civilstate.domain.model;

import org.mines.address.domain.model.Address;

import java.util.Collection;
import java.util.UUID;

public record Country(UUID id, String name, String abbreviation, Collection<Town> towns,Collection<Langage> langages,Collection<Religion> religions) {
    public static final class CountryBuilder {
        private UUID id;
        private String name;
        private String abbreviation;
        private Collection<Town> towns;
        private Collection<Langage> langages;
        private Collection<Religion> religions;



        private CountryBuilder() {
        }

        public static CountryBuilder aCountry() {
            return new CountryBuilder();
        }

        public CountryBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public CountryBuilder withName(String name) {
            this.name = name;
            return this;
        }
        public CountryBuilder withAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
            return this;
        }
        public CountryBuilder withTowns(Collection<Town> towns) {
            this.towns = towns;
            return this;
        }

        public CountryBuilder withReligions(Collection<Religion> religions) {
            this.religions = religions;
            return this;
        }
        public CountryBuilder withLangages(Collection<Langage> langages) {
            this.langages = langages;
            return this;
        }

        public Country build() {
            return new Country(id, name, abbreviation, towns, langages,religions);
        }
    }
}
