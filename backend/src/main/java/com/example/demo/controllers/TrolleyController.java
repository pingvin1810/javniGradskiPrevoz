
package com.example.demo.controllers;

import com.example.demo.models.Trolley;
import com.example.demo.models.User;
import com.example.demo.services.TrolleyService;
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
@RequestMapping("/trolleys")
public class TrolleyController {
  @Autowired
  private TrolleyService trolleyService;

  @GetMapping("")
  public List<Trolley> getAllTrolleys() {
    return trolleyService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Trolley> getTrolleyById(@PathVariable(value = "id") final long trolleyID) {
    return trolleyService.find(trolleyID);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping("")
  public void createTrolley(@RequestBody final Trolley trolley) {
    trolleyService.create(trolley);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PutMapping("/{id}")
  public void updateTrolley(@PathVariable(value = "id") final long trolleyID,
      @RequestBody final Trolley trolley) {
    trolleyService.update(trolley);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @DeleteMapping("/{id}")
  public void deleteTrolley(@PathVariable(value = "id") final long trolleyID) {
    trolleyService.delete(trolleyID);
  }
}
