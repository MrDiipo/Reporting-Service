package com.mintyn.reportingservice.service;

import com.mintyn.reportingservice.controller.response.ReportResponse;

public interface ReportService {
    ReportResponse getReport(String dateFrom, String dateTo);
}
