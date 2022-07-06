package com.example.demo.services;

import com.example.demo.models.Trolley;
import com.example.demo.repositories.TrolleyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TrolleyService {
  @Autowired
  private TrolleyRepository trolleyRepository;

  public List<Trolley> findAll() {
    return trolleyRepository.findAll();
  }

  public Optional<Trolley> find(final long id) {
    return trolleyRepository.findById(id);
  }

  public void create(final Trolley trolley) {
    trolleyRepository.save(trolley);
  }

  public void update(final Trolley trolley, final long id) {
    Trolley update = trolleyRepository.findById(id).orElseThrow();
    update.setTrolleyNumber(trolley.getTrolleyNumber());
    update.setStartStation(trolley.getStartStation());
    update.setEndStation(trolley.getEndStation());
    trolleyRepository.save(update);
  }

  public void delete(final long id) {
    trolleyRepository.findById(id).orElseThrow();
    trolleyRepository.deleteById(id);
  }

}
