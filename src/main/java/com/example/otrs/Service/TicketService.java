package com.example.otrs.Service;

import com.example.otrs.Entity.Ticket;
import com.example.otrs.Repository.TicketRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;

/*

@author ishani.s
 */
@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket saveDetails(Ticket ticket) {
        if (ticketRepository.findMaxTicketNo() == null) {
            ticket.setTicketNo(1L);
        } else {
            ticket.setTicketNo(Long.parseLong(ticketRepository.findMaxTicketNo()) + 1);
        }
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllDetails() {
        return ticketRepository.getAllTicketDetails();
    }

    public Ticket getAllDetailsByID(String ticketNo) {
        return ticketRepository.findById(ticketNo).orElse(null);
    }

    public Ticket updateTicket(Ticket ticket) throws Exception {
        Ticket updateTicket = ticketRepository.findById(ticket.getTicketNo().toString()).orElse(null);

        if (updateTicket == null) {
            throw new Exception("Ticket not found");
        }

        if (!updateTicket.getStatus().equals("New")) {
            throw new AccessDeniedException("Access denied: Only tickets with status 'New' can be deleted");
        }

        updateTicket.setAssignee(ticket.getAssignee());
        updateTicket.setEmergencyLevel(ticket.getEmergencyLevel());
        updateTicket.setStatus(ticket.getStatus());
        updateTicket.setLocation(ticket.getLocation());
        updateTicket.setBranchOrDivision(ticket.getBranchOrDivision());
        updateTicket.setIssueType(ticket.getIssueType());
        updateTicket.setIssueCategory(ticket.getIssueCategory());
        updateTicket.setContactNo(ticket.getContactNo());
        updateTicket.setSerialNo(ticket.getSerialNo());
        updateTicket.setIsWorkingPc(ticket.getIsWorkingPc());
        updateTicket.setIp(ticket.getIp());
        updateTicket.setIssueDesAndRemarks(ticket.getIssueDesAndRemarks());
        updateTicket.setAgentResponseDateTime(ticket.getAgentResponseDateTime());
        updateTicket.setResolvedDateTime(ticket.getResolvedDateTime());
        updateTicket.setResolutionPeriod(ticket.getResolutionPeriod());
        updateTicket.setAgentComments(ticket.getAgentComments());
        updateTicket.setLastUpdatedUser(ticket.getLastUpdatedUser());
        updateTicket.setLastUpdatedDateTime(LocalDateTime.now().toString());
        ticketRepository.save((updateTicket));
        return updateTicket;
    }

    public Ticket closeTicket(String ticketNo) {
        Ticket updateTicket = ticketRepository.findById(ticketNo).orElse(null);

        if (updateTicket != null) {
            updateTicket.setStatus("Closed");
            updateTicket.setLastUpdatedDateTime(LocalDateTime.now().toString());
            ticketRepository.save((updateTicket));
            return updateTicket;
        }
        return null;
    }

    public Ticket deleteTicket(String ticketNo) throws Exception {
        Ticket updateTicket = ticketRepository.findById(ticketNo).orElse(null);

        if (updateTicket == null) {
            throw new Exception("Ticket not found");
        }

        if (!updateTicket.getStatus().equals("New")) {
            throw new AccessDeniedException("Access denied: Only tickets with status 'New' can be deleted");
        }

        updateTicket.setStatus("Deleted");
        updateTicket.setLastUpdatedDateTime(LocalDateTime.now().toString());
        ticketRepository.save(updateTicket);
        return updateTicket;
    }

    public long getNewTicketCount(String username) {
        return ticketRepository.getNewTicketCount(username);
    }

    public long getAssignedTicketCount(String username) {
        return ticketRepository.getAssignedTicketCount(username);
    }

    public long getActiveTicketCount(String username) {
        return ticketRepository.getActiveTicketCount(username);
    }

    public long getCompletedTicketCount(String username) {
        return ticketRepository.getCompletedTicketCount(username);
    }

    public long getClosedTicketCount(String username) {
        return ticketRepository.getClosedTicketCount(username);
    }

    public long getTotalTicketCount(String username) {
        return ticketRepository.getTotalTicketCount(username);
    }
}
