package com.example.otrs.Service;

import com.example.otrs.DTO.TicketDTO;
import com.example.otrs.Repository.TicketRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 @author ishani.s
 */
@Service
public class ReportService {
    @Autowired
    private TicketRepository ticketRepository;

    String[] headers = {
            "Ticket ID", "Sender", "Agent", "Reported Date Time", "Emergency Level",
            "Location", "Branch or Division", "Issue Type", "Issue Category", "Contact No",
            "Serial No", "Is Working PC", "IP", "Issue Description & Remarks",
            "Agent Response Date-Time", "Resolved Date Time", "Resolution Period",
            "Completed Percentage", "Agent Comments", "Last Updated User",
            "Last Updated Date-Time", "Status"
    };

    public void generateExcelReport(HttpServletResponse response, Integer status) throws IOException {
        List<Object[]> results = ticketRepository.getAllTicketDetailsByStatus(status);
        List<TicketDTO> tickets = new ArrayList<>();
        String statusDes = "";

        for (Object[] result : results) {
            TicketDTO ticket = new TicketDTO();
            ticket.setTicketId((String) result[0]);
            ticket.setSender((String) result[1]);
            ticket.setAgent((String) result[2]);
            ticket.setReportedDateTime((String) result[3]);
            ticket.setEmergencyLevel((String) result[4]);
            ticket.setStatus((String) result[5]);
            statusDes =  ticket.getStatus();
            ticket.setIssueType((String) result[6]);
            ticket.setIssueCategory((String) result[7]);
            ticket.setSerialNo((String) result[8]);
            ticket.setIsWorkingPc((String) result[9]);
            ticket.setIp((String) result[10]);
            ticket.setIssueDesAndRemarks((String) result[11]);
            ticket.setAgentResponseDateTime((String) result[12]);
            ticket.setResolvedDateTime((String) result[13]);
            ticket.setLastUpdatedUser((String) result[14]);
            ticket.setLastUpdatedDateTime((String) result[15]);
            ticket.setCompletedPercentage((String) result[16]);
            ticket.setAgentComment((String) result[17]);
            ticket.setBranchDivision((String) result[18]);
            ticket.setContactNo((String) result[19]);
            ticket.setLocation((String) result[20]);
            ticket.setResolutionPeriod((String) result[21]);
            tickets.add(ticket);
        }

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Ticket Details");

        // Create a bold header row for the "Ticket Details" text
        CellStyle textStyle = workbook.createCellStyle();
        Font boldUnderlineFont = workbook.createFont();
        boldUnderlineFont.setBold(true);
        boldUnderlineFont.setUnderline(Font.U_SINGLE);
        textStyle.setFont(boldUnderlineFont);
        textStyle.setAlignment(HorizontalAlignment.LEFT);

        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Ticket Details");
        titleCell.setCellStyle(textStyle);

        Row subTitleRow = sheet.createRow(2);
        Cell subTitleCell = subTitleRow.createCell(0);
        subTitleCell.setCellValue("Search Parameters");
        CellStyle searchParameterStyle = workbook.createCellStyle();
        Font boldUnderlineFont2 = workbook.createFont();
        boldUnderlineFont.setBold(true);
        boldUnderlineFont.setUnderline(Font.U_SINGLE);
        searchParameterStyle.setFont(boldUnderlineFont2);
        searchParameterStyle.setAlignment(HorizontalAlignment.LEFT);
        subTitleCell.setCellStyle(textStyle);

        Row parameterRow = sheet.createRow(4);
        parameterRow.createCell(0).setCellValue("Status : ");
        parameterRow.createCell(1).setCellValue(statusDes);

        Row headerRow = sheet.createRow(6);

        // Create and style header cells
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        // Set the fill pattern and foreground color
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        CellStyle dataCellStyle = workbook.createCellStyle();
        dataCellStyle.setBorderTop(BorderStyle.THIN);
        dataCellStyle.setBorderBottom(BorderStyle.THIN);
        dataCellStyle.setBorderLeft(BorderStyle.THIN);
        dataCellStyle.setBorderRight(BorderStyle.THIN);


        // Fill data
        int rowNum = 7; // Start after the title and header rows
        for (TicketDTO ticket : tickets) {
            Row row = sheet.createRow(rowNum++);

            // Set values for each cell and replace empty values with "--"
            setCellValue(row.createCell(0), ticket.getTicketId(), dataCellStyle);
            setCellValue(row.createCell(1), ticket.getSender(), dataCellStyle);
            setCellValue(row.createCell(2), ticket.getAgent(), dataCellStyle);
            setCellValue(row.createCell(3), ticket.getReportedDateTime(), dataCellStyle);
            setCellValue(row.createCell(4), ticket.getEmergencyLevel(), dataCellStyle);
            setCellValue(row.createCell(5), ticket.getLocation(), dataCellStyle);
            setCellValue(row.createCell(6), ticket.getBranchDivision(), dataCellStyle);
            setCellValue(row.createCell(7), ticket.getIssueType(), dataCellStyle);
            setCellValue(row.createCell(8), ticket.getIssueCategory(), dataCellStyle);
            setCellValue(row.createCell(9), ticket.getContactNo(), dataCellStyle);
            setCellValue(row.createCell(10), ticket.getSerialNo(), dataCellStyle);
            setCellValue(row.createCell(11), ticket.getIsWorkingPc(), dataCellStyle);
            setCellValue(row.createCell(12), ticket.getIp(), dataCellStyle);
            setCellValue(row.createCell(13), ticket.getIssueDesAndRemarks(), dataCellStyle);
            setCellValue(row.createCell(14), ticket.getAgentResponseDateTime(), dataCellStyle);
            setCellValue(row.createCell(15), ticket.getResolvedDateTime(), dataCellStyle);
            setCellValue(row.createCell(16), ticket.getResolutionPeriod(), dataCellStyle);
            setCellValue(row.createCell(17), ticket.getCompletedPercentage(), dataCellStyle);
            setCellValue(row.createCell(18), ticket.getAgentComment(), dataCellStyle);
            setCellValue(row.createCell(19), ticket.getLastUpdatedUser(), dataCellStyle);
            setCellValue(row.createCell(20), ticket.getLastUpdatedDateTime(), dataCellStyle);
            setCellValue(row.createCell(21), ticket.getStatus(), dataCellStyle);
        }

        // Adjust column widths based on the content
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to the response
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=users.xlsx");

        try (ServletOutputStream outputStream = response.getOutputStream()) {
            workbook.write(outputStream);
        }
        workbook.close();
    }

    public void generateExcelReport(HttpServletResponse response) throws IOException {
        List<Object[]> results = ticketRepository.getAllTicketDetails();
        List<TicketDTO> tickets = new ArrayList<>();

        for (Object[] result : results) {
            TicketDTO ticket = new TicketDTO();
            ticket.setTicketId((String) result[0]);
            ticket.setSender((String) result[1]);
            ticket.setAgent((String) result[2]);
            ticket.setReportedDateTime((String) result[3]);
            ticket.setEmergencyLevel((String) result[4]);
            ticket.setStatus((String) result[5]);
            ticket.setIssueType((String) result[6]);
            ticket.setIssueCategory((String) result[7]);
            ticket.setSerialNo((String) result[8]);
            ticket.setIsWorkingPc((String) result[9]);
            ticket.setIp((String) result[10]);
            ticket.setIssueDesAndRemarks((String) result[11]);
            ticket.setAgentResponseDateTime((String) result[12]);
            ticket.setResolvedDateTime((String) result[13]);
            ticket.setLastUpdatedUser((String) result[14]);
            ticket.setLastUpdatedDateTime((String) result[15]);
            ticket.setCompletedPercentage((String) result[16]);
            ticket.setAgentComment((String) result[17]);
            ticket.setBranchDivision((String) result[18]);
            ticket.setContactNo((String) result[19]);
            ticket.setLocation((String) result[20]);
            ticket.setResolutionPeriod((String) result[21]);
            tickets.add(ticket);
        }

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Ticket Details");

        // Create a bold header row for the "Ticket Details" text
        CellStyle textStyle = workbook.createCellStyle();
        Font boldUnderlineFont = workbook.createFont();
        boldUnderlineFont.setBold(true);
        boldUnderlineFont.setUnderline(Font.U_SINGLE);
        textStyle.setFont(boldUnderlineFont);
        textStyle.setAlignment(HorizontalAlignment.LEFT);

        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Ticket Details");
        titleCell.setCellStyle(textStyle);

        Row subTitleRow = sheet.createRow(2);
        Cell subTitleCell = subTitleRow.createCell(0);
        subTitleCell.setCellValue("Search Parameters");
        CellStyle searchParameterStyle = workbook.createCellStyle();
        Font boldUnderlineFont2 = workbook.createFont();
        boldUnderlineFont.setBold(true);
        boldUnderlineFont.setUnderline(Font.U_SINGLE);
        searchParameterStyle.setFont(boldUnderlineFont2);
        searchParameterStyle.setAlignment(HorizontalAlignment.LEFT);
        subTitleCell.setCellStyle(textStyle);

        Row parameterRow = sheet.createRow(4);
        parameterRow.createCell(0).setCellValue("Status : ");
        parameterRow.createCell(1).setCellValue("--");

        Row headerRow = sheet.createRow(6);

        // Create and style header cells
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        // Set the fill pattern and foreground color
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        CellStyle dataCellStyle = workbook.createCellStyle();
        dataCellStyle.setBorderTop(BorderStyle.THIN);
        dataCellStyle.setBorderBottom(BorderStyle.THIN);
        dataCellStyle.setBorderLeft(BorderStyle.THIN);
        dataCellStyle.setBorderRight(BorderStyle.THIN);

        // Fill data
        int rowNum = 7; // Start after the title and header rows
        for (TicketDTO ticket : tickets) {
            Row row = sheet.createRow(rowNum++);

            // Set values for each cell and replace empty values with "--"
            setCellValue(row.createCell(0), ticket.getTicketId(), dataCellStyle);
            setCellValue(row.createCell(1), ticket.getSender(), dataCellStyle);
            setCellValue(row.createCell(2), ticket.getAgent(), dataCellStyle);
            setCellValue(row.createCell(3), ticket.getReportedDateTime(), dataCellStyle);
            setCellValue(row.createCell(4), ticket.getEmergencyLevel(), dataCellStyle);
            setCellValue(row.createCell(5), ticket.getLocation(), dataCellStyle);
            setCellValue(row.createCell(6), ticket.getBranchDivision(), dataCellStyle);
            setCellValue(row.createCell(7), ticket.getIssueType(), dataCellStyle);
            setCellValue(row.createCell(8), ticket.getIssueCategory(), dataCellStyle);
            setCellValue(row.createCell(9), ticket.getContactNo(), dataCellStyle);
            setCellValue(row.createCell(10), ticket.getSerialNo(), dataCellStyle);
            setCellValue(row.createCell(11), ticket.getIsWorkingPc(), dataCellStyle);
            setCellValue(row.createCell(12), ticket.getIp(), dataCellStyle);
            setCellValue(row.createCell(13), ticket.getIssueDesAndRemarks(), dataCellStyle);
            setCellValue(row.createCell(14), ticket.getAgentResponseDateTime(), dataCellStyle);
            setCellValue(row.createCell(15), ticket.getResolvedDateTime(), dataCellStyle);
            setCellValue(row.createCell(16), ticket.getResolutionPeriod(), dataCellStyle);
            setCellValue(row.createCell(17), ticket.getCompletedPercentage(), dataCellStyle);
            setCellValue(row.createCell(18), ticket.getAgentComment(), dataCellStyle);
            setCellValue(row.createCell(19), ticket.getLastUpdatedUser(), dataCellStyle);
            setCellValue(row.createCell(20), ticket.getLastUpdatedDateTime(), dataCellStyle);
            setCellValue(row.createCell(21), ticket.getStatus(), dataCellStyle);
        }

        // Adjust column widths based on the content
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to the response
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=users.xlsx");

        try (ServletOutputStream outputStream = response.getOutputStream()) {
            workbook.write(outputStream);
        }
        workbook.close();
    }

    private void setCellValue(Cell cell, String value, CellStyle style) {
        cell.setCellValue(value != null && !value.isEmpty() ? value : "--");
        cell.setCellStyle(style);
    }
}