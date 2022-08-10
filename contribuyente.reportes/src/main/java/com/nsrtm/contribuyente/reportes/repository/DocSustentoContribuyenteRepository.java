package com.nsrtm.contribuyente.reportes.repository;

import com.nsrtm.contribuyente.reportes.domain.DocSustentoContribuyente;
import com.nsrtm.contribuyente.reportes.domain.DocSustentoContribuyenteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocSustentoContribuyenteRepository extends JpaRepository<DocSustentoContribuyente, DocSustentoContribuyenteId>, DocSustentoContribuyenteCustomRepository {
}
