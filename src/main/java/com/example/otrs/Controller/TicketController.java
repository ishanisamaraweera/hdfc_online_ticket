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

import java.io.IOException;
import java.util.List;

/**
 *
 @author ishani.s
 */
@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    //Add new ticket
    @CrossOrigin(origins = "*")
    @PostMapping("/addTicket")
    public Ticket addTicket(@RequestBody Ticket ticket){
        return ticketService.saveDetails(ticket);
    }

    @GetMapping("/getTicket")
    public List<TicketDTO> getDetails(){
        return ticketService.getAllDetails();
    }

    @GetMapping("/getTicketByID/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") String ticketId) {
        Ticket ticket = ticketService.getTicketWithComments(ticketId);
        return ResponseEntity.ok(ticket);
    }


    //Update all ticket details
    @PutMapping("/updateTicket")
    public Ticket updateTicket(@RequestBody Ticket ticket) throws Exception{
        return ticketService.updateTicket(ticket);
    }

    //Update the status of the ticket as closed
    @PutMapping("/closeTicket/{ticketId}")
    public Ticket closeTicket(@PathVariable String ticketId){
        return ticketService.closeTicket(ticketId);
    }

    //Change the ticket status as delete
    @PutMapping("/deleteTicket/{ticketId}")
    public Ticket deleteTicket(@PathVariable String ticketId) throws Exception {
        return ticketService.deleteTicket(ticketId);
    }

    //Get the active ticket count of particular user
    @GetMapping("/getActiveTicketCount/{username}")
    public long getActiveTicketCount(@PathVariable String username){
        return ticketService.getActiveTicketCount(username);
    }

    //Get the active ticket count of particular user
    @GetMapping("/getNewTicketCount/{username}")
    public long getNewTicketCount(@PathVariable String username){
        return ticketService.getNewTicketCount(username);
    }

    //Get the active ticket count of particular user
    @GetMapping("/getAssignedTicketCount/{username}")
    public long getAssignedTicketCount(@PathVariable String username){
        return ticketService.getAssignedTicketCount(username);
    }

    //Get the completed ticket count of particular user
    @GetMapping("/getCompletedTicketCount/{username}")
    public long getCompletedTicketCount(@PathVariable String username){
        return ticketService.getCompletedTicketCount(username);
    }

    //Get the closed ticket count of particular user
    @GetMapping("/getClosedTicketCount/{username}")
    public long getClosedTicketCount(@PathVariable String username){
        return ticketService.getClosedTicketCount(username);
    }

    //Get the all ticket count of particular user
    @GetMapping("/getTotalTicketCount/{username}")
    public long getTotalTicketCount(@PathVariable String username){
        return ticketService.getTotalTicketCount(username);
    }

    @GetMapping("/searchTickets/{status}")
    public List<TicketDTO> searchTickets(@PathVariable Integer status) throws IOException {
        return ticketService.searchTickets(status);
    }

    @GetMapping("/searchTickets")
    public List<TicketDTO> searchTickets() throws IOException {
        return ticketService.searchTickets();
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
    public void addComment(@RequestBody Comment request) throws Exception {
        ticketService.addComment(request);
    }

    @GetMapping("/getCommentsByTicketId/{ticketId}")
    public List<CommentRequestDTO> getCommentsByTicketId(@PathVariable String ticketId){
        return ticketService.getCommentsByTicketId(ticketId);
    }
}