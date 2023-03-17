package com.mintyn.reportingservice.controller.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ReportResponse {

 private Long orderId;
 private LocalDate date;
 private BigDecimal totalAmount;
 private List<ProductResponse> productResponse;
 private String status;
 private ReportResponse.CustomerResponse customer;

 @Data
 @Builder
 public static class CustomerResponse {
  @NotNull
  private Long customerId;
  @NotBlank
  private String customerName;
  @Email
  @NotBlank
  private String email;
 }

}
