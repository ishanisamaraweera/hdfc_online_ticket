package com.example.otrs.Service;

import com.example.otrs.DTO.AssignRequestDTO;
import com.example.otrs.DTO.CommentRequestDTO;
import com.example.otrs.DTO.TicketDTO;
import com.example.otrs.Entity.*;
import com.example.otrs.Repository.*;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ishani.s
 */
@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    UserService userService;

    final String FILE_PATH = "C:/Users/ishani.s/Documents/OTRS/";

    public Ticket saveDetails(Ticket ticket) {
        String lastTicketId = ticketRepository.findMaxTicketId();
        String currentYear = Integer.toString(LocalDateTime.now().getYear());
        String branch = ticket.getBranchDivision();
        String ticketId;

        if (lastTicketId == null || !lastTicketId.substring(0, 4).equals(currentYear)) {
            ticketId = "00001";
        } else {
            int lastId = Integer.parseInt(lastTicketId.substring(7));
            ticketId = String.format("%05d", lastId + 1);
        }
        ticket.setCompletedPercentage(0);

        ticket.setTicketId(currentYear + branch + ticketId);
        return ticketRepository.save(ticket);
    }

    public List<TicketDTO> getAllDetails(String username) {
        List<String> userRoleList = userService.getUserRolesForUsername(username);
        List<Object[]> results;

        if (userRoleList.contains("MANAGER") || userRoleList.contains("SUPERVISOR")
                || userRoleList.contains("ADMIN") || userRoleList.contains("SUPERADMIN")
                || userRoleList.contains("TOPSUPERVISOR")) {
            results = ticketRepository.getAllTicketDetails();
        } else {
            results = ticketRepository.getAllTicketDetails(username);
        }

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
            ticket.setCompletedPercentage((Integer) result[16]);
            ticket.setAgentComment((String) result[17]);
            ticket.setBranchDivision((String) result[18]);
            ticket.setContactNo((String) result[19]);
            ticket.setLocation((String) result[20]);
            ticket.setResolutionPeriod((String) result[21]);

            tickets.add(ticket);
        }

        return tickets;
    }

    public Ticket getTicketWithComments(String ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id " + ticketId));
    }

    public Ticket updateTicket(Ticket ticket) throws Exception {
        Ticket updateTicket = ticketRepository.findById(ticket.getTicketId()).orElse(null);

        if (updateTicket == null) {
            throw new Exception("Ticket not found");
        }

        if (!updateTicket.getStatus().equals(1)) {
            throw new AccessDeniedException("Access denied: Only tickets with status 'New' can be deleted");
        }

        updateTicket.setAgent(ticket.getAgent());
        updateTicket.setEmergencyLevel(ticket.getEmergencyLevel());
        updateTicket.setStatus(ticket.getStatus());
        updateTicket.setLocation(ticket.getLocation());
        updateTicket.setBranchDivision(ticket.getBranchDivision());
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
        updateTicket.setAgentComment(ticket.getAgentComment());
        updateTicket.setLastUpdatedUser(ticket.getLastUpdatedUser());
        updateTicket.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ticketRepository.save((updateTicket));
        return updateTicket;
    }

    public Ticket closeTicket(String ticketId) {
        Ticket updateTicket = ticketRepository.findById(ticketId).orElse(null);

        if (updateTicket != null) {
            Status closedStatus = statusRepository.findById("5").orElse(null);
            if (closedStatus == null) {
                statusRepository.saveDetails(5, "Closed");
            }
            updateTicket.setStatus(5);
            updateTicket.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            ticketRepository.save(updateTicket);
            return updateTicket;
        }
        return null;
    }

    public Ticket deleteTicket(String ticketId) throws Exception {
        Ticket updateTicket = ticketRepository.findById(ticketId).orElse(null);

        if (updateTicket == null) {
            throw new Exception("Ticket not found");
        }

        if (!updateTicket.getStatus().equals(1)) {
            throw new AccessDeniedException("Access denied: Only tickets with status 'New' can be deleted");
        }

        Status deletedStatus = statusRepository.findById("6").orElse(null);
        if (deletedStatus == null) {
            statusRepository.saveDetails(5, "Deleted Status");
            ;
        }
        updateTicket.setStatus(6);
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

    public List<TicketDTO> searchTickets(Integer status) {
        List<Object[]> results = ticketRepository.getAllTicketDetailsByStatus(status);
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
            ticket.setCompletedPercentage((Integer) result[16]);
            ticket.setAgentComment((String) result[17]);
            ticket.setBranchDivision((String) result[18]);
            ticket.setContactNo((String) result[19]);
            ticket.setLocation((String) result[20]);
            ticket.setResolutionPeriod((String) result[21]);

            tickets.add(ticket);
        }
        return tickets;
    }

    public List<TicketDTO> searchTickets() {
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
            ticket.setCompletedPercentage((Integer) result[16]);
            ticket.setAgentComment((String) result[17]);
            ticket.setBranchDivision((String) result[18]);
            ticket.setContactNo((String) result[19]);
            ticket.setLocation((String) result[20]);
            ticket.setResolutionPeriod((String) result[21]);

            tickets.add(ticket);
        }
        return tickets;
    }

    public void assignTicket(String ticketId, AssignRequestDTO request) throws Exception {
        Ticket assignTicket = ticketRepository.findById(ticketId).orElse(null);

        if (assignTicket == null) {
            throw new Exception("Ticket not found");
        }

//        if (!assignTicket.getStatus().equals(1)) {
//            throw new AccessDeniedException("Access denied: Only tickets with status 'New' can be assigned");
//        }

        assignTicket.setAgent(request.getAgentId());
        assignTicket.setStatus(2);
        assignTicket.setLastUpdatedUser(request.getUsername());
        assignTicket.setLastUpdatedDateTime(LocalDateTime.now().toString());
        ticketRepository.save((assignTicket));
    }

    public void acceptTicket(String ticketId, AssignRequestDTO request) throws Exception {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);

        if (ticket == null) {
            throw new Exception("Ticket not found");
        }

        ticket.setStatus(3);
        ticket.setAgentComment(request.getAgentComment());
        ticket.setLastUpdatedUser(request.getUsername());
        ticket.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ticket.setAgentResponseDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ticketRepository.save((ticket));
    }

    public void rejectTicket(String ticketId, AssignRequestDTO request) throws Exception {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);

        if (ticket == null) {
            throw new Exception("Ticket not found");
        }

        ticket.setStatus(1);
        ticket.setAgentComment(request.getAgentComment());
        ticket.setLastUpdatedUser(request.getUsername());
        ticket.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ticket.setAgentResponseDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ticketRepository.save((ticket));
    }

    public void savePercentage(String ticketId, AssignRequestDTO request) throws Exception {
        Ticket assignTicket = ticketRepository.findById(ticketId).orElse(null);

        if (assignTicket == null) {
            throw new Exception("Ticket not found");
        }

        assignTicket.setCompletedPercentage(request.getCompletedPercentage());
        assignTicket.setLastUpdatedUser(request.getUsername());
        assignTicket.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ticketRepository.save((assignTicket));
    }

    public void saveStatus(String ticketId, AssignRequestDTO request) throws Exception {
        Ticket assignTicket = ticketRepository.findById(ticketId).orElse(null);

        if (assignTicket == null) {
            throw new Exception("Ticket not found");
        }

        assignTicket.setStatus(4);//completed
        assignTicket.setLastUpdatedUser(request.getUsername());
        assignTicket.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        assignTicket.setResolvedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime agentResponseDateTime = LocalDateTime.parse(assignTicket.getAgentResponseDateTime(), formatter);
        LocalDateTime currentDateTime = LocalDateTime.now();
        Period period = Period.between(agentResponseDateTime.toLocalDate(), currentDateTime.toLocalDate());

        int days = period.getDays();
        Duration duration = Duration.between(agentResponseDateTime.plusDays(days), currentDateTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        String readableDuration = String.format("%d days, %d hours, %d minutes",
                days, hours, minutes);
        assignTicket.setResolutionPeriod(readableDuration);
        ticketRepository.save((assignTicket));
    }

    public ResponseEntity<?> addComment(String ticketId, String comment, String addedBy, MultipartFile file,
                                        List<MultipartFile> attachments) throws IOException {
        Integer lastCommentId = commentRepository.findMaxCommentId();
        Integer commentId;

        if (lastCommentId == null) {
            commentId = 1;
        } else {
            commentId = lastCommentId + 1;
        }

        Comment request = new Comment();

        request.setCommentId(commentId);
        request.setTicketId(ticketId);
        request.setComment(comment);
        request.setAddedBy(addedBy);
        request.setAddedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        try {
            if (file != null && !file.isEmpty()) {
                saveFile(file);
            }

            // Save attachments if any
            if (attachments != null) {
                for (MultipartFile attachment : attachments) {
                    saveFile(attachment);
                }
            }

            commentRepository.save(request);

            return new ResponseEntity<>("Comment and file(s) uploaded successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add comment and upload file(s)", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void saveFile(MultipartFile file) throws IOException {
        if (!Files.exists(Paths.get(FILE_PATH))) {
            Files.createDirectories(Paths.get(FILE_PATH));
        }
        Path filePath = Paths.get(FILE_PATH + file.getOriginalFilename());
        Files.write(filePath, file.getBytes());
    }

    public List<CommentRequestDTO> getCommentsByTicketId(String ticketId) {
        return commentRepository.getCommentsByTicketId(ticketId);
    }

    public ResponseEntity<?> uploadFile(MultipartFile file) {
        try {
            // Define the file path
            String filePath = FILE_PATH + file.getOriginalFilename();

            // Save the file to the file system
            File dest = new File(filePath);
            file.transferTo(dest);

            // Save the file path to the database
            Attachment entity = new Attachment();
            entity.setFilePath(filePath);
            entity.setName(file.getOriginalFilename());
            entity.setFileType(file.getContentType());
            entity.setUploadedDateTime(LocalDateTime.now().toString());
            attachmentRepository.save(entity);

            return ResponseEntity.ok("File uploaded successfully");
        } catch (
                IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }
}
