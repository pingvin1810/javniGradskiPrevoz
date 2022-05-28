package com.example.demo.controllers;

import com.example.demo.models.Station;
import com.example.demo.models.User;
import com.example.demo.services.StationService;
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
@RequestMapping("/stations")
public class StationController {
  @Autowired
  private StationService stationService;

  @GetMapping("")
  public List<Station> getAllStations() {
    return stationService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Station> getStationById(@PathVariable(value = "id") final long stationID) {
    return stationService.find(stationID);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping("")
  public void createStation(@RequestBody final Station station) {
    stationService.create(station);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PutMapping("/{id}")
  public void updateStation(@PathVariable(value = "id") final long stationID,
      @RequestBody final Station station) {
    stationService.update(station);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @DeleteMapping("/{id}")
  public void deleteStation(@PathVariable(value = "id") final long stationID) {
    stationService.delete(stationID);
  }
}