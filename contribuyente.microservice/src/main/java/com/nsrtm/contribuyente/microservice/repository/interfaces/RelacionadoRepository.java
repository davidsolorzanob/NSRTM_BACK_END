package com.nsrtm.contribuyente.microservice.repository.interfaces;

import com.nsrtm.contribuyente.microservice.domain.Relacionado;
import com.nsrtm.contribuyente.microservice.domain.RelacionadoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelacionadoRepository extends JpaRepository<Relacionado, RelacionadoId>, RelacionadoCustomRepository {

}