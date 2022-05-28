package com.example.demo.repositories;

import com.example.demo.models.Trolley;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrolleyRepository extends JpaRepository<Trolley, Long> {
}
