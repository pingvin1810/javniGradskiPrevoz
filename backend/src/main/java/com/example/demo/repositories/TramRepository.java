package com.example.demo.repositories;

import com.example.demo.models.Tram;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TramRepository extends JpaRepository<Tram, Long> {
}