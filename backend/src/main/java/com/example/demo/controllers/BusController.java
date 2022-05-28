package com.example.demo.controllers;

import com.example.demo.models.Bus;
import com.example.demo.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buses")
public class BusController {
  @Autowired
  private BusService busService;

  @GetMapping("")
  public List<Bus> getAllBuses() {
    return busService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Bus> getBusById(@PathVariable(value = "id") final long busID) {
    return busService.find(busID);
  }
  
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping("")
  public void createBus(@RequestBody final Bus bus) {
    busService.create(bus);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PutMapping("/{id}")
  public void updateBus(@PathVariable(value = "id") final long busID,
      @RequestBody final Bus bus) {
    busService.update(bus);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @DeleteMapping("/{id}")
  public void deleteBus(@PathVariable(value = "id") final long busID) {
    busService.delete(busID);
  }
}