package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.DocSustentoContribuyente;
import com.nsrtm.contribuyente.microservice.domain.DocSustentoContribuyenteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocSustentoContribuyenteRepository extends JpaRepository<DocSustentoContribuyente, DocSustentoContribuyenteId>, DocSustentoContribuyenteCustomRepository {
}
