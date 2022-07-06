package com.example.demo.services;

import com.example.demo.models.Bus;
import com.example.demo.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BusService {
  @Autowired
  private BusRepository busRepository;

  public List<Bus> findAll() {
    return busRepository.findAll();
  }

  public Optional<Bus> find(final long id) {
    return busRepository.findById(id);
  }

  public void create(final Bus bus) {
    busRepository.save(bus);
  }

  public void update(final Bus bus, final long busId) {
    Bus update = busRepository.findById(busId).orElseThrow();
    update.setBusNumber(bus.getBusNumber());
    update.setStartStation(bus.getStartStation());
    update.setEndStation(bus.getEndStation());
    busRepository.save(update);
  }

  public void delete(final long id) {
    busRepository.findById(id).orElseThrow();
    busRepository.deleteById(id);
  }

}