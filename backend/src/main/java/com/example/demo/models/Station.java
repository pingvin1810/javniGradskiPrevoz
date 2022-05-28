package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "station")
public class
Station implements Serializable {
  @Id
  @Column(name = "stationId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long stationId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tram_id")
  private Tram tramId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "trolley_id")
  private Trolley trolleyId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bus_id")
  private Bus busId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "minibus_id")
  private Minibus minibusId;
  @Column(name = "name", nullable = false)

  private String name;


  public Station(long stationId, Tram tramId, Trolley trolleyId, Bus busId, Minibus minibusId, String name) {
    this.stationId = stationId;
    this.tramId = tramId;
    this.trolleyId = trolleyId;
    this.busId = busId;
    this.minibusId = minibusId;
    this.name = name;
  }

  public Station() {

  }

  public long getStationId() {
    return stationId;
  }

  public void setStationId(long stationId) {
    this.stationId = stationId;
  }

  public Tram getTramId() {
    return tramId;
  }

  public void setTramId(Tram tramId) {
    this.tramId = tramId;
  }

  public Trolley getTrolleyId() {
    return trolleyId;
  }

  public void setTrolleyId(Trolley trolleyId) {
    this.trolleyId = trolleyId;
  }

  public Bus getBusId() {
    return busId;
  }

  public void setBusId(Bus busId) {
    this.busId = busId;
  }

  public Minibus getMinibusId() {
    return minibusId;
  }

  public void setMinibusId(Minibus minibusId) {
    this.minibusId = minibusId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}