package com.academy.agreement.api;

import com.academy.agreement.db.agreement.Agreement;
import com.academy.agreement.db.agreement.AgreementService;
import com.academy.public_interface.agreement.v1.AgreementResponseDto;
import com.academy.public_interface.agreement.v1.AgreementServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AgreementServiceV1Impl implements AgreementServiceV1 {

    private final AgreementService agreementService;

    @Override
    public AgreementResponseDto create(String status) {
        var agreement = Agreement.builder()
                .status(status)
                .build();
        Mono<Agreement> savedAgreement = agreementService.save(agreement);
        return getAgreementResponseDto(savedAgreement.block());
    }

    @Override
    public Flux<AgreementResponseDto> get(String status) {
        return agreementService.findByStatus(status)
                .map(this::getAgreementResponseDto);
    }

    private AgreementResponseDto getAgreementResponseDto(Agreement agreement) {
        return AgreementResponseDto.builder()
                .id(agreement.getId())
                .status(agreement.getStatus())
                .build();
    }

}
