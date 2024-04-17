package org.mines.address.infrastructure.repository;

import org.mines.address.domain.model.Town;
import org.mines.address.port.driven.TownRepositoryPort;
import org.mines.civilstate.domain.model.BirthDate;
import org.mines.civilstate.port.driven.BirthDateRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
public class BirthDateRepositoryAdapter implements BirthDateRepositoryPort {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BirthDateRepositoryAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<BirthDate> select(UUID uuid) {
        return this.jdbcTemplate.query("select id,day,month,year from birthdate where id=?", new BirthDateRowMapper(), uuid).stream().findFirst();
    }

    @Override
    public Collection<BirthDate> selectAll() {
        return jdbcTemplate.query("select id,day,month,year from birthdate", new BirthDateRowMapper());
    }

    @Override
    public BirthDate insert(BirthDate birthDate) {
        final SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(Objects.requireNonNull(jdbcTemplate.getDataSource())).withTableName("birthdate");

        final SqlParameterSource in = new MapSqlParameterSource()
                .addValue("id", birthDate.id())
                .addValue("day", birthDate.day())
                .addValue("month", birthDate.month())
                .addValue("year", birthDate.year());

        try {
            simpleJdbcInsert.execute(in);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to insert BirthDate into database", e);
        }
        return birthDate;
    }

    @Override
    public BirthDate update(BirthDate birthDate) {
        jdbcTemplate.update("update birthdate set day = ?, month = ?, year = ? where id = ?", birthDate.day(), birthDate.month(), birthDate.year(), birthDate.id());

        return birthDate;
    }

    @Override
    public void delete(UUID uuid) {
        jdbcTemplate.update("delete from birthdate where id=?", uuid);
    }
}
