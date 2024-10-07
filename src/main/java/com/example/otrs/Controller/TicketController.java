package com.example.otrs.Controller;

import com.example.otrs.DTO.AssignRequestDTO;
import com.example.otrs.DTO.CommentRequestDTO;
import com.example.otrs.DTO.TicketDTO;
import com.example.otrs.Entity.Comment;
import com.example.otrs.Entity.Ticket;
import com.example.otrs.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author ishani.s
 */
@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @CrossOrigin(origins = "*")
    @PostMapping("/addTicket")
    public Ticket addTicket(@ModelAttribute Ticket ticket, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        return ticketService.saveDetails(ticket, file);
    }

    @GetMapping("/getTicket/{username}")
    public List<TicketDTO> getDetails(@PathVariable("username") String username) {
        return ticketService.getAllDetails(username);
    }

    @GetMapping("/getTicketByID/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") String ticketId) {
        Ticket ticket = ticketService.getTicketWithComments(ticketId);
        return ResponseEntity.ok(ticket);
    }

    //Update all ticket details
    @PutMapping("/updateTicket")
    public Ticket updateTicket(@RequestBody Ticket ticket) throws Exception {
        return ticketService.updateTicket(ticket);
    }

    //Update the status of the ticket as closed
    @PutMapping("/closeTicket/{ticketId}")
    public Ticket closeTicket(@PathVariable String ticketId) {
        return ticketService.closeTicket(ticketId);
    }

    //Change the ticket status as delete
    @PutMapping("/deleteTicket/{ticketId}")
    public Ticket deleteTicket(@PathVariable String ticketId) throws Exception {
        return ticketService.deleteTicket(ticketId);
    }

    //Get the active ticket count of particular user
    @GetMapping("/getActiveTicketCount/{username}")
    public long getActiveTicketCount(@PathVariable String username) {
        return ticketService.getActiveTicketCount(username);
    }

    //Get the active ticket count of particular user
    @GetMapping("/getNewTicketCount/{username}")
    public long getNewTicketCount(@PathVariable String username) {
        return ticketService.getNewTicketCount(username);
    }

    //Get the active ticket count of particular user
    @GetMapping("/getAssignedTicketCount/{username}")
    public long getAssignedTicketCount(@PathVariable String username) {
        return ticketService.getAssignedTicketCount(username);
    }

    //Get the completed ticket count of particular user
    @GetMapping("/getCompletedTicketCount/{username}")
    public long getCompletedTicketCount(@PathVariable String username) {
        return ticketService.getCompletedTicketCount(username);
    }

    //Get the closed ticket count of particular user
    @GetMapping("/getClosedTicketCount/{username}")
    public long getClosedTicketCount(@PathVariable String username) {
        return ticketService.getClosedTicketCount(username);
    }

    //Get the all ticket count of particular user
    @GetMapping("/getTotalTicketCount/{username}")
    public long getTotalTicketCount(@PathVariable String username) {
        return ticketService.getTotalTicketCount(username);
    }

    @GetMapping("/searchTickets")
    public List<TicketDTO> searchTickets(@RequestParam(required = false) String status,
                                         @RequestParam(required = false) String fromDate,
                                         @RequestParam(required = false) String toDate) throws IOException {
        LocalDateTime fromDateInput = null;
        LocalDateTime toDateInput = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        if (fromDate == null || fromDate.equals("null")){
            fromDateInput = LocalDateTime.of(1800, 1, 1, 0, 0); // Some minimum date
        } else {
            fromDateInput = LocalDateTime.parse(fromDate, formatter);
        }
        if (toDate == null || toDate.equals("null")) {
            toDateInput = LocalDateTime.now(); // Current date as the maximum date
        } else {
            toDateInput = LocalDateTime.parse(toDate, formatter);
        }

        return ticketService.searchTickets(status, fromDateInput, toDateInput);
    }

    @PutMapping("/assignTicket/{ticketId}")
    public void assignTicket(@PathVariable String ticketId, @RequestBody AssignRequestDTO request) throws Exception {
        ticketService.assignTicket(ticketId, request);
    }

    @PutMapping("/acceptTicket/{ticketId}")
    public void acceptTicket(@PathVariable String ticketId, @RequestBody AssignRequestDTO request) throws Exception {
        ticketService.acceptTicket(ticketId, request);
    }

    @PutMapping("/rejectTicket/{ticketId}")
    public void rejectTicket(@PathVariable String ticketId, @RequestBody AssignRequestDTO request) throws Exception {
        ticketService.rejectTicket(ticketId, request);
    }

    @PutMapping("/savePercentage/{ticketId}")
    public void savePercentage(@PathVariable String ticketId, @RequestBody AssignRequestDTO request) throws Exception {
        ticketService.savePercentage(ticketId, request);
    }

    @PutMapping("/saveStatus/{ticketId}")
    public void saveStatus(@PathVariable String ticketId, @RequestBody AssignRequestDTO request) throws Exception {
        ticketService.saveStatus(ticketId, request);
    }

    @PostMapping("/addComment")
    public Comment addComment(@ModelAttribute Comment comment, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        return ticketService.addComment(comment, file);
    }

    @GetMapping("/getCommentsByTicketId/{ticketId}")
    public List<CommentRequestDTO> getCommentsByTicketId(@PathVariable String ticketId) {
        return ticketService.getCommentsByTicketId(ticketId);
    }

    @PutMapping("/reopenTicket/{ticketId}")
    public void reopenTicket(@PathVariable String ticketId, @RequestBody AssignRequestDTO request) throws Exception {
        ticketService.reopenTicket(ticketId, request);
    }
}