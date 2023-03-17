package com.mintyn.reportingservice.controller.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ProductResponse {

    @NotNull
    private Long id;

    @NotBlank(message = "Name field can't be empty")
    private String name;

    @NotNull(message = "Price field can't be empty")
    private BigDecimal price;

    @NotNull(message = "Field can't be empty")
    private int totalItems;

    @NotBlank
    private String description;

    private LocalDate dateCreated;
}
