package com.mintyn.reportingservice.domain;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("customer")
public class Customer {
    @Id
    private Long id;

    private String email;
    private String name;
    private String phoneNumber;
}
