package com.academy.agreement.db.agreement;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgreementService {

    private final AgreementRepository agreementRepository;

    public Agreement insert(String status) {
        return agreementRepository.insert(status);
    }

    public List<Agreement> findByStatus(String status) {
        return agreementRepository.findByStatus(status);
    }

}
