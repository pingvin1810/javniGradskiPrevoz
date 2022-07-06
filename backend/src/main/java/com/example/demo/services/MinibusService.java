package com.example.demo.services;

import com.example.demo.models.Minibus;
import com.example.demo.repositories.MinibusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MinibusService {
  @Autowired
  private MinibusRepository minibusRepository;

  public List<Minibus> findAll() {
    return minibusRepository.findAll();
  }

  public Optional<Minibus> find(final long id) {
    return minibusRepository.findById(id);
  }

  public void create(final Minibus minibus) {
    minibusRepository.save(minibus);
  }

  public void update(final Minibus minibus, final long id) {
    Minibus update = minibusRepository.findById(id).orElseThrow();
    update.setMinibusNumber(minibus.getMinibusNumber());
    update.setStartStation(minibus.getStartStation());
    update.setEndStation(minibus.getEndStation());
    minibusRepository.save(update);
  }

  public void delete(final long id) {
    minibusRepository.findById(id).orElseThrow();
    minibusRepository.deleteById(id);
  }

}