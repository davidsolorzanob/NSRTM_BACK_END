package com.nsrtm.contribuyente.microservice.repository;

//import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
//import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionadoId;
import com.nsrtm.contribuyente.microservice.domain.Relacionado;
import com.nsrtm.contribuyente.microservice.domain.RelacionadoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRelacionadoRepository extends JpaRepository<Relacionado, RelacionadoId>, DomicilioRelacionadoCustomRepository {
}