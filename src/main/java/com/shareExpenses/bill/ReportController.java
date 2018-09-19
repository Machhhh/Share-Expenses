package com.shareExpenses.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    BigDecimal submitParticipantContribution(@RequestParam String uuid) {
        return reportService.submitParticipantContribution(uuid);
    }

    @GetMapping("/{uuid}")
    BigDecimal submitParticipantBilans(@RequestParam String uuid) {
        return reportService.submitParticipantBilans(uuid);
    }
}
