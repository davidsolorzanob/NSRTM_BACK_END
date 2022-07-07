package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.Relacionado;
import com.nsrtm.contribuyente.microservice.domain.RelacionadoCustom;
import com.nsrtm.contribuyente.microservice.domain.RelacionadoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface RelacionadoRepository extends JpaRepository<Relacionado, RelacionadoId>, RelacionadoCustomRepository {

}