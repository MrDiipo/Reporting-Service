package com.mintyn.reportingservice.controller;

import com.mintyn.reportingservice.controller.response.ReportResponse;
import com.mintyn.reportingservice.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.awt.*;

@RequestMapping("/api/v1/stream")
@RequiredArgsConstructor
public class StreamingController {

    private final ReportService reportService;

    @GetMapping(value = "/reports", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ReportResponse> getReports() {
        return reportService.getReports();
    }
}
