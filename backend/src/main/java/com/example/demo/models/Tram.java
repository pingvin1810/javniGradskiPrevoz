package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tram")
public class Tram implements Serializable {
  @Id
  @Column(name = "tramId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long tramId;
  private long tramNumber;
  private String startStation;
  private String endStation;

  public Tram(long tramId, long number, String start, String end) {
    this.tramId = tramId;
    this.tramNumber = number;
    this.startStation = start;
    this.endStation = end;
  }

  public Tram() {

  }

  public long getTramId() {
    return tramId;
  }

  public void setTramId(long tramId) {
    this.tramId = tramId;
  }

  public long getTramNumber() {
    return tramNumber;
  }

  public void setTramNumber(long tramNumber) {
    this.tramNumber = tramNumber;
  }

  public String getStartStation() {
    return startStation;
  }

  public void setStartStation(String startSation) {
    this.startStation = startSation;
  }

  public String getEndStation() {
    return endStation;
  }

  public void setEndStation(String end) {
    this.endStation = end;
  }
}

