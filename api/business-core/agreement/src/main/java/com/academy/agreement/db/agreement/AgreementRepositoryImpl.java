package com.academy.agreement.db.agreement;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AgreementRepositoryImpl implements AgreementRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Agreement insert(String status) {
        var sql = """
                insert into agreement(id, status)
                values (nextval('agreement_seq'), ?)
                returning id, status
                """;
        return jdbcTemplate.queryForObject(sql, new AgreementRowMapper(), status);
    }

    @Override
    public List<Agreement> findByStatus(String status) {
        var sql = """
                select id, status from agreement where status = ?
                """;
        return jdbcTemplate.query(sql, new AgreementRowMapper(), status);
    }
}
