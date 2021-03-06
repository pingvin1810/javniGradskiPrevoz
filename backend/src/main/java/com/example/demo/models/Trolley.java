package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trolley")
public class Trolley implements Serializable {
  @Id
  @Column(name = "trolleyId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long trolleyId;
  private long trolleyNumber;
  private String startStation;
  private String endStation;

  public Trolley(long tramId, long number, String start, String end) {
    this.trolleyId = trolleyId;
    this.trolleyNumber = number;
    this.startStation = start;
    this.endStation = end;
  }

  public Trolley() {

  }

  public long getTrolleyId() {
    return trolleyId;
  }

  public void setTrolleyId(long trolleyId) {
    this.trolleyId = trolleyId;
  }

  public long getTrolleyNumber() {
    return trolleyNumber;
  }

  public void setTrolleyNumber(long trolleyNumber) {
    this.trolleyNumber = trolleyNumber;
  }

  public String getStartStation() {
    return startStation;
  }

  public void setStartStation(String start) {
    this.startStation = start;
  }

  public String getEndStation() {
    return endStation;
  }

  public void setEndStation(String end) {
    this.endStation = end;
  }
}
