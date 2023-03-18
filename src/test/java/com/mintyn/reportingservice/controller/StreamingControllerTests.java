package com.mintyn.reportingservice.controller;

import com.mintyn.reportingservice.controller.response.ReportResponse;
import com.mintyn.reportingservice.service.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static com.mintyn.reportingservice.TestUtilities.createReportResponse;
import static org.mockito.BDDMockito.given;

@WebFluxTest(StreamingController.class)
public class StreamingControllerTests {

    public static final String API_V_1_STREAM = "/api/v1/stream";
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ReportService reportService;

    @Test
    void getReports_ShouldReturn_200() {
        ReportResponse reportResponse = createReportResponse();
        assert reportResponse != null;
        given(reportService.getReports()).willReturn(Mono.just(reportResponse));

        webTestClient.get().uri(API_V_1_STREAM + "/reports")
                .exchange()
                .expectStatus().isOk()
                .expectBody(ReportResponse.class);
    }

}
