package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minibus")
public class Minibus implements Serializable {
  @Id
  @Column(name = "minibusId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long minibusId;
  private long minibusNumber;
  private String startStation;
  private String endStation;

  public Minibus(long minibusId, long number, String start, String end) {
    this.minibusId = minibusId;
    this.minibusNumber = number;
    this.startStation = start;
    this.endStation = end;
  }

  public Minibus() {

  }


  public long getMinibusId() {
    return minibusId;
  }

  public void setMinibusId(long minibusId) {
    this.minibusId = minibusId;
  }

  public long getNumber() {
    return minibusNumber;
  }

  public void setNumber(long number) {
    this.minibusNumber = number;
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
