package com.example.demo.services;

import com.example.demo.models.Ticket;
import com.example.demo.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TicketService {
  @Autowired
  private TicketRepository ticketRepository;

  public List<Ticket> findAll() {
    return ticketRepository.findAll();
  }

  public Optional<Ticket> find(final long id) {
    return ticketRepository.findById(id);
  }

  public void create(final Ticket ticket) {
    ticketRepository.save(ticket);
  }

  public void update(final Ticket ticket, final long id) {
    Ticket update = ticketRepository.findById(id).orElseThrow();
    update.setUserId(ticket.getUserId());
    update.setStartDate(ticket.getStartDate());
    update.setExpiryDate(ticket.getExpiryDate());
    ticketRepository.save(update);
  }

  public void delete(final long id) {
    ticketRepository.findById(id).orElseThrow();
    ticketRepository.deleteById(id);
  }

}