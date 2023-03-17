package com.mintyn.reportingservice.service;

import com.mintyn.reportingservice.domain.Order;
import com.mintyn.reportingservice.exception.ReportServiceException;
import com.mintyn.reportingservice.service.imp.ReportServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class ReportServiceTests {

    @MockBean
    private KafkaConsumerService kafkaConsumerService;

    private ReportService reportService = new ReportServiceImp(kafkaConsumerService);

    @Test void throwError_ifKafka_returnsNullOrder() {
        given(kafkaConsumerService.getOrder()).willReturn(null);

        assertThatThrownBy(
                () -> reportService.getReport(LocalDate.now().toString(), LocalDate.now().toString())
        ).isInstanceOf(ReportServiceException.class);
    }

}
