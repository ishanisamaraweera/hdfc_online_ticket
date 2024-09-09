package com.example.otrs.Controller;

import com.example.otrs.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 @author ishani.s
 */

@RestController
public class ReportController {
    @Autowired
    private ReportService excelReportService;

    @GetMapping("/exportTickets/{status}")
    public void exportTickets(HttpServletResponse response, @PathVariable Integer status) throws IOException {
        excelReportService.generateExcelReport(response, status);
    }

    @GetMapping("/exportTickets")
    public void exportTickets(HttpServletResponse response) throws IOException {
        excelReportService.generateExcelReport(response);
    }
}
