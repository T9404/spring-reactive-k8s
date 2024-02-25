package com.academy.agreement.db.agreement;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AgreementRowMapper implements RowMapper<Agreement> {

    @Override
    public Agreement mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Agreement(rs.getLong("id"), rs.getString("status"));
    }
}
