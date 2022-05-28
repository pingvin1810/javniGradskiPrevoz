package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus implements Serializable {
  @Id
  @Column(name = "busId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long busId;
  private long number;
  private String startStation;
  private String endStation;

  public Bus(long busId, long number, String start, String end) {
    this.busId = busId;
    this.number = number;
    this.startStation = start;
    this.endStation = end;
  }

  public Bus() {

  }

  public long getBusId() {
    return busId;
  }

  public void setBusId(long busId) {
    this.busId = busId;
  }

  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
  }

  public String getStartStation() {
    return startStation;
  }

  public void setStartStation(String startStation) {
    this.startStation = startStation;
  }

  public String getEndStation() {
    return endStation;
  }

  public void setEndStation(String endStation) {
    this.endStation = endStation;
  }
}
