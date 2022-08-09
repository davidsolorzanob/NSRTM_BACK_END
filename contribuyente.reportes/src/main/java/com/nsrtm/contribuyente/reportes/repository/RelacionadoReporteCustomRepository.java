package com.nsrtm.contribuyente.reportes.repository;

import com.nsrtm.contribuyente.reportes.domain.ContribuyenteRequest;
import com.nsrtm.contribuyente.reportes.domain.RelacionadoResult;

public interface RelacionadoReporteCustomRepository {
    RelacionadoResult ObtenerRelacionadoReporte(ContribuyenteRequest custom);
}
