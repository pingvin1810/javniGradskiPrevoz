package com.example.demo.controllers;

import com.example.demo.models.Minibus;
import com.example.demo.services.MinibusService;
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
@RequestMapping("/minibuses")
public class MinibusController {
  @Autowired
  private MinibusService minibusService;

  @GetMapping("")
  public List<Minibus> getAllMinibuses() {
    return minibusService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Minibus> getMinibusById(@PathVariable(value = "id") final long minibusID) {
    return minibusService.find(minibusID);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping("")
  public void createMinibus(@RequestBody final Minibus minibus) {
    minibusService.create(minibus);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PutMapping("/{id}")
  public void updateMinibus(@PathVariable(value = "id") final long minibusID,
      @RequestBody final Minibus minibus) {
    minibusService.update(minibus, minibusID);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @DeleteMapping("/{id}")
  public void deleteMinibus(@PathVariable(value = "id") final long minibusID) {
    minibusService.delete(minibusID);
  }
}