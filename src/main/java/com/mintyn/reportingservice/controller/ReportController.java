package com.mintyn.reportingservice.controller;

import com.mintyn.reportingservice.controller.response.ReportResponse;
import com.mintyn.reportingservice.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/reports")
@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping(value = "/{fromDate}/{toDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReportResponse> handleGetResponse(@PathVariable String fromDate, @PathVariable String toDate) {
        return ResponseEntity.ok(reportService.getReport(fromDate, toDate));
    }
}
