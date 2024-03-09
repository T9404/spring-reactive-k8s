package com.academy.agreement.db.agreement;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@Table("agreement")
public class Agreement {
    @Id
    private Long id;

    private String status;
}
