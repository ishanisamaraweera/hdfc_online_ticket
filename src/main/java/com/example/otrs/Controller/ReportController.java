package com.example.otrs.Controller;

import com.example.otrs.Service.ReportService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author ishani.s
 */

@RestController
public class ReportController {
    @Autowired
    private ReportService excelReportService;

    @GetMapping("/exportTickets")
    public void exportTickets(HttpServletResponse response,
                              @RequestParam(required = false) String status,
                              @RequestParam(required = false) String fromDate,
                              @RequestParam(required = false) String toDate) throws IOException {

        excelReportService.generateExcelReport(response, status, fromDate, toDate);
    }
}
