package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {
  @Id
  @Column(name = "ticketId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long ticketId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User userId;
  @Column(name = "start_date", nullable = false)
  private String startDate;
  @Column(name = "expiry_date", nullable = false)
  private String expiryDate;



  public Ticket(long ticketId, User userId, String startDate, String expiryDate) {
    this.ticketId = ticketId;
    this.userId = userId;
    this.startDate = startDate;
    this.expiryDate = expiryDate;
  }

  public Ticket() {

  }

  public long getTicketId() {
    return ticketId;
  }

  public void setTicketId(long ticketId) {
    this.ticketId = ticketId;
  }

  public User getUserId() {
    return userId;
  }

  public void setUserId(User userId) {
    this.userId = userId;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }
}


