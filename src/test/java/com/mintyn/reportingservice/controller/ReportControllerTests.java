package com.mintyn.reportingservice.controller;

import com.mintyn.reportingservice.controller.response.ReportResponse;
import com.mintyn.reportingservice.service.ReportService;
import org.apache.kafka.common.protocol.types.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.mintyn.reportingservice.TestUtilities.createReportResponse;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@WebFluxTest(ReportController.class)
public class ReportControllerTests {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ReportService reportService;

    @Test void getReports_ShouldReturn_200() {
        ReportResponse reportResponse = createReportResponse();
        String dateFrom = "";
        String dateTo = "";
        given(reportService.getReport(dateFrom, dateTo)).willReturn(reportResponse);

        webTestClient.get().uri("/api/v1/reports/{fromDate}/{toDate}")
                .exchange()
                .expectStatus().isOk()
                .expectBody(ReportResponse.class);
    }

}
