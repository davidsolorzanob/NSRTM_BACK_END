package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.CondicionContribuyenteId;
import com.nsrtm.contribuyente.microservice.domain.complex.CondicionContribuyenteCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondicionContribuyenteRepository extends JpaRepository<CondicionContribuyenteCustom, CondicionContribuyenteId>, CondicionContribuyenteCustomRepository {

}
