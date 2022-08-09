package com.nsrtm.contribuyente.reportes.repository;

import com.nsrtm.contribuyente.reportes.domain.ContribuyenteRequest;
import com.nsrtm.contribuyente.reportes.domain.ContribuyenteResult;

public interface ContribuyenteReporteCustomRepository {
    ContribuyenteResult ObtenerContribuyenteReporte(ContribuyenteRequest custom);
}
