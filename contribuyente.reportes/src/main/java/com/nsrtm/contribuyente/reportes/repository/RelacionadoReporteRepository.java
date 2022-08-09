package com.nsrtm.contribuyente.reportes.repository;

import com.nsrtm.contribuyente.reportes.domain.RelacionadoId;
import com.nsrtm.contribuyente.reportes.domain.RelacionadoResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelacionadoReporteRepository extends JpaRepository<RelacionadoResult, RelacionadoId>, RelacionadoReporteCustomRepository{
}
