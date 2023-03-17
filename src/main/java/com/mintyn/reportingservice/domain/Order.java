package com.mintyn.reportingservice.domain;

import com.mintyn.reportingservice.controller.response.ProductResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class Order {

    @Id
    private Long id;
    private BigDecimal totalAmount;
    private Customer customer;
    private List<ProductResponse> productResponseList;

}
