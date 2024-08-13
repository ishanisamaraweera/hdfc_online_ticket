package com.example.otrs.Controller;

import com.example.otrs.Service.ExcelReportService;
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
    private ExcelReportService excelReportService;

    @GetMapping("/exportUsers/{status}")
    public void exportUsers(HttpServletResponse response, @PathVariable Integer status) throws IOException {
        excelReportService.generateExcelReport(response, status);
    }
}
