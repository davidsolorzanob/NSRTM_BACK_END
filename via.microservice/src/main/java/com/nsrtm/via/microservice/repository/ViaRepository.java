package com.nsrtm.via.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nsrtm.via.microservice.domain.Via;

public interface ViaRepository extends JpaRepository<Via, Long> {
}
