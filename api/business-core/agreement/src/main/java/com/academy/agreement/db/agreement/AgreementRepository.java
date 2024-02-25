package com.academy.agreement.db.agreement;
import java.util.List;

public interface AgreementRepository {
    Agreement insert(String status);
    List<Agreement> findByStatus(String status);
}