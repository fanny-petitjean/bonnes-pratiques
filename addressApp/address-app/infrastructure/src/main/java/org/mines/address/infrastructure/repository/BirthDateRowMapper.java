package org.mines.address.infrastructure.repository;

import org.mines.address.domain.model.Town;
import org.mines.civilstate.domain.model.BirthDate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class BirthDateRowMapper implements RowMapper<BirthDate> {
    @Override
    public BirthDate mapRow(ResultSet rs, int rowNum) throws SQLException {
        return BirthDate.BirthDateBuilder.aBirthDate()
                .withId(UUID.fromString(rs.getString("id")))
                .withDay(rs.getInt("day"))
                .withMonth(rs.getInt("month"))
                .withYear(rs.getInt("year"))
                .build();
    }
}
