package com.nsrtm.contribuyente.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nsrtm.contribuyente.microservice.domain.Contribuyente;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ContribuyenteRepository extends JpaRepository<Contribuyente, Long>, JpaSpecificationExecutor {
/*
    @Query(value = "select c from contribuyente c where (c.tipo_documento=?1 or ?1 is null) " +
            "and (c.numero_documento=?2 or ?2 is null) and (c.sec_ejec = ?3 or ?3 is null) " +
            "and (c.apellido_paterno like ?4 or c.apellido_materno like ?4 or ?4 is null)", nativeQuery = true)
    */
    //List<Contribuyente> findByContribuyente (Integer idTipoDocumento, String numeroDocumento, String secEjec, String apellidoPaterno) ;
//List<Contribuyente> findByTipoDocumentoAndNumeroDocumentoAndSecEjec (Integer tipoDocumento, String numeroDocumento, String secEjec) ;

}
