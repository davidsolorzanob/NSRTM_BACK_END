package com.nsrtm.contribuyente.reportes.repository;

import com.nsrtm.contribuyente.reportes.domain.ContribuyenteId;
import com.nsrtm.contribuyente.reportes.domain.ContribuyenteResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContribuyenteReporteRepository extends JpaRepository<ContribuyenteResult, ContribuyenteId>, ContribuyenteReporteCustomRepository{
}
