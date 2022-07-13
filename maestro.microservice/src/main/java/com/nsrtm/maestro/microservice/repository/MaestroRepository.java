package com.nsrtm.maestro.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nsrtm.maestro.microservice.domain.Maestro;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MaestroRepository extends JpaRepository<Maestro, Integer> {
    @Procedure(name = "GetMaestro")
    List<Maestro> ObtenerMaestro(@Param("TIPO_ID") Integer tipoMaestroId,@Param("MUNICIPALIDAD_ID") Long municipalidadId);
}
