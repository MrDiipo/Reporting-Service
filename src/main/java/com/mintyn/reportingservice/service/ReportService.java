package com.mintyn.reportingservice.service;

import com.mintyn.reportingservice.controller.response.ReportResponse;
import reactor.core.publisher.Mono;

public interface ReportService {
    ReportResponse getReport(String dateFrom, String dateTo);

    Mono<ReportResponse> getReports();
}
