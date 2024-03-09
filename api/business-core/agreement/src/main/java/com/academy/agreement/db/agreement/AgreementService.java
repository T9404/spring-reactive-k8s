package com.academy.agreement.db.agreement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AgreementService {

    private final AgreementRepository agreementRepository;

    public Mono<Agreement> save(Agreement agreement) {
        return agreementRepository.save(agreement);
    }

    public Flux<Agreement> findByStatus(String status) {
        return agreementRepository.findByStatus(status);
    }

}
