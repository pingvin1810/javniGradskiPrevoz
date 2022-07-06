package com.example.demo.controllers;

import com.example.demo.models.Ticket;
import com.example.demo.models.User;
import com.example.demo.services.TicketService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {
  @Autowired
  private TicketService ticketService;

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping("")
  public List<Ticket> getAllTickets() {
    return ticketService.findAll();
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  @GetMapping("/{id}")
  public Optional<Ticket> getTicketById(@PathVariable(value = "id") final long ticketID) {
    return ticketService.find(ticketID);
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  @PostMapping("")
  public void createTicket(
      @RequestBody final Ticket ticket) {
    ticketService.create(ticket);
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  @PutMapping("/{id}")
  public void updateTicket(@PathVariable(value = "id") final long ticketID,
      @RequestBody final Ticket ticket) {
    ticketService.update(ticket, ticketID);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @DeleteMapping("/{id}")
  public void deleteTicket(@PathVariable(value = "id") final long ticketID) {
    ticketService.delete(ticketID);
  }
}
