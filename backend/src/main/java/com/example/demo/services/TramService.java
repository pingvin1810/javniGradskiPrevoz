package com.example.demo.services;

import com.example.demo.models.Tram;
import com.example.demo.repositories.TramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TramService {
  @Autowired
  private TramRepository tramRepository;

  public List<Tram> findAll() {
    return tramRepository.findAll();
  }

  public Optional<Tram> find(final long id) {
    return tramRepository.findById(id);
  }

  public void create(final Tram tram) {
    tramRepository.save(tram);
  }

  public void update(final Tram tram, final long id) {
    Tram update = tramRepository.findById(id).orElseThrow();
    update.setTramNumber(tram.getTramNumber());
    update.setStartStation(tram.getStartStation());
    update.setEndStation(tram.getEndStation());
    tramRepository.save(update);
  }

  public void delete(final long id) {
    tramRepository.findById(id).orElseThrow();
    tramRepository.deleteById(id);
  }
}