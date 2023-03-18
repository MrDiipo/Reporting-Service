package com.mintyn.reportingservice.service.imp;

import com.mintyn.reportingservice.controller.response.ProductResponse;
import com.mintyn.reportingservice.controller.response.ReportResponse;
import com.mintyn.reportingservice.domain.Order;
import com.mintyn.reportingservice.exception.ReportServiceException;
import com.mintyn.reportingservice.service.KafkaConsumerService;
import com.mintyn.reportingservice.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImp implements ReportService {

    private final KafkaConsumerService kafkaConsumerService;

    @Override
    public ReportResponse getReport(String dateFrom, String dateTo) {
        Order order = kafkaConsumerService.getOrder();
        if (order == null) {
            throw new ReportServiceException("No order is found at the moment");
        }
        return createReportResponse(order, dateFrom, dateTo);
    }

    @Override
    public Mono<ReportResponse> getReports() {
        Order order = kafkaConsumerService.getOrder();
        return Mono.just(ReportResponse
                .builder()
                .productResponse(order.getProductResponseList())
                .orderId(order.getId())
                .customer(ReportResponse.CustomerResponse.builder()
                        .customerId(order.getCustomer().getId())
                        .customerName(order.getCustomer().getName())
                        .build())
                .build());
    }

    private ReportResponse createReportResponse(Order order, String dateFrom, String dateTo) {
        return ReportResponse.builder()
                .date(LocalDate.now())
                .totalAmount(
                        order.getProductResponseList().stream()
                                .map(ProductResponse::getPrice)
                                .reduce(BigDecimal.valueOf(0), BigDecimal::add))
                .productResponse(order.getProductResponseList().stream()
                        .filter(e -> e.getDateCreated().isAfter(LocalDate.parse(dateTo)) && e.getDateCreated().isBefore(LocalDate.parse(dateFrom)))
                        .collect(Collectors.toList())
                )
                .customer(ReportResponse.CustomerResponse.builder()
                        .customerId(order.getCustomer().getId())
                        .build())
                .build();
    }
}
