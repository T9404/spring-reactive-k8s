package com.academy.agreement.db.agreement;

import com.processing.common.generate.database.annotation_processor.annotation.GenerateRepository;
import com.processing.common.generate.database.annotation_processor.annotation.Query;
import com.processing.common.generate.database.annotation_processor.jdbc.driver.postgres.PostgresJdbcRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@GenerateRepository(annotations = Repository.class)
public interface AgreementRepository extends PostgresJdbcRepository {

    @Query("query/agreement/insert.sql")
    Agreement insert(String status);

    @Query("query/agreement/findByStatus.sql")
    default Flux<Agreement> findByStatus(String status, JdbcTemplate jdbcTemplate) {
        DataClassRowMapper<Agreement> rowMapper = new DataClassRowMapper<>();

        return Flux.create(sink -> {
            jdbcTemplate.execute("select id, status from agreement where status = ?", new PreparedStatementCallback<>() {
                @Override
                public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setFetchSize(100);

                    ps.setString(1, status);

                    ResultSet resultSet = ps.executeQuery();
                    while (resultSet.next()) {
                        Agreement agreement = rowMapper.mapRow(resultSet, resultSet.getRow());
                        sink.next(agreement);
                    }

                    sink.complete();
                    return null;
                }
            });
        });
    }

}
