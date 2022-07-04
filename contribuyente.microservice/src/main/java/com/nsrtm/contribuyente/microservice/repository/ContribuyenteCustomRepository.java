package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.ContribuyenteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContribuyenteCustomRepository extends JpaRepository<ContribuyenteCustom, ContribuyenteId> {
    @Procedure(name = "GetMaestro")
    List<ContribuyenteCustom> ListaContribuyentePaginado(@Param("TIPO_ID") Integer tipoMaestroId);
}
