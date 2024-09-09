package com.example.otrs.DTO;

import com.example.otrs.Entity.Ticket;

import java.util.List;

/**
 *
 @author ishani.s
 */
public class TicketMapper {

    public static Ticket mapToTicket(List<String> input) {
        Ticket ticket = new Ticket();
        ticket.setTicketId(input.get(0));
        ticket.setSender(input.get(1));
        ticket.setAgent(input.get(2));
        ticket.setReportedDateTime(input.get(3));
        ticket.setEmergencyLevel(mapEmergencyLevel(input.get(4)));
        ticket.setStatus(mapStatus(input.get(5)));
        ticket.setLocation(input.get(18));  // Assuming location is at index 18
        ticket.setBranchDivision(input.get(20));  // Assuming branchDivision is at index 20
        ticket.setIssueType(mapIssueType(input.get(6)));
        ticket.setIssueCategory(mapIssueCategory(input.get(7)));
        ticket.setContactNo(input.get(19));  // Assuming contactNo is at index 19
        ticket.setSerialNo(input.get(8));
        ticket.setIsWorkingPc(input.get(9));
        ticket.setIp(input.get(10));
        ticket.setIssueDesAndRemarks(input.get(11));
        ticket.setAgentResponseDateTime(input.get(12));
        ticket.setResolvedDateTime(input.get(13));
        ticket.setResolutionPeriod(input.get(17));  // Assuming resolutionPeriod is at index 17
        ticket.setAgentComment(input.get(14));
        ticket.setLastUpdatedUser(input.get(15));
        ticket.setLastUpdatedDateTime(input.get(16));
        ticket.setCompletedPercentage(Integer.parseInt(input.get(21)));  // Assuming completedPercentage is at index 21
        return ticket;
    }

    private static String mapEmergencyLevel(String emergencyLevel) {
        switch (emergencyLevel.toLowerCase()) {
            case "high":
                return "1";
            case "medium":
                return "2";
            case "low":
                return "3";
            default:
                return "0";
        }
    }

    private static int mapStatus(String status) {
        switch (status.toLowerCase()) {
            case "complete":
                return 4;
            // Add other mappings as needed
            default:
                return 0;
        }
    }

    private static int mapIssueType(String issueType) {
        switch (issueType.toLowerCase()) {
            case "hardware":
                return 1;
            // Add other mappings as needed
            default:
                return 0;
        }
    }

    private static int mapIssueCategory(String issueCategory) {
        switch (issueCategory.toLowerCase()) {
            case "pc issue":
                return 1;
            // Add other mappings as needed
            default:
                return 0;
        }
    }
}