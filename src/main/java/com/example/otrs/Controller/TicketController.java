package com.example.otrs.Controller;

import com.example.otrs.Entity.Ticket;
import com.example.otrs.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

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
    public List<Ticket> getDetails(){
        return ticketService.getAllDetails();
    }

    @GetMapping("/getTicketByID/{id}")
    public Ticket getDetailsByID(@PathVariable String id){
        return ticketService.getAllDetailsByID(id);
    }


    //Update all ticket details
    @PutMapping("/updateTicket")
    public Ticket updateTicket(@RequestBody Ticket ticket) throws Exception{
        return ticketService.updateTicket(ticket);
    }

    //Update the status of the ticket as closed
    @PutMapping("/closeTicket/{ticketNo}")
    public Ticket closeTicket(@PathVariable String ticketNo){
        return ticketService.closeTicket(ticketNo);
    }

    //Change the ticket status as delete
    @PutMapping("/deleteTicket/{ticketNo}")
    public Ticket deleteTicket(@PathVariable String ticketNo) throws Exception {
        return ticketService.deleteTicket(ticketNo);
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
}