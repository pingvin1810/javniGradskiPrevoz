package com.example.demo.controllers;

import com.example.demo.models.Clock;
import com.example.demo.models.User;
import com.example.demo.services.ClockService;
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
@RequestMapping("/clocks")
public class ClockController {
  @Autowired
  private ClockService clockService;

  @GetMapping("")
  public List<Clock> getAllClocks() {
    return clockService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Clock> getClockById(@PathVariable(value = "id") final long clockID) {
    return clockService.find(clockID);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping("")
  public void createClock(@RequestBody final Clock clock) {
    clockService.create(clock);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PutMapping("/{id}")
  public void updateClock(@PathVariable(value = "id") final long clockID,
      @RequestBody final Clock clock) {
    clockService.update(clock, clockID);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @DeleteMapping("/{id}")
  public void deleteClock(@PathVariable(value = "id") final long clockID) {
    clockService.delete(clockID);
  }
}
