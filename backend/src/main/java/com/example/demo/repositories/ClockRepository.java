package com.example.demo.repositories;

import com.example.demo.models.Clock;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClockRepository extends JpaRepository<Clock, Long> {
}