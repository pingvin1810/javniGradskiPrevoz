package com.example.demo.repositories;

import com.example.demo.models.Minibus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinibusRepository extends JpaRepository<Minibus, Long> {
}
