package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.ContribuyenteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContribuyenteCustomRepository extends JpaRepository<ContribuyenteCustom, ContribuyenteId> {
    @Procedure(name = "GetContribuyenteListar")
    List<ContribuyenteCustom> ListaContribuyentePaginado(@Param("P_TIPO_FILTRO") Integer tipoFiltro,
                                                         @Param("P_MUNICIPALIDAD_ID") Integer municipalidadId,
                                                         @Param("P_CONTRIBUYENTE_NUMERO") Integer contribuyenteNumero,
                                                         @Param("P_TIP_PERSONA_ID") Integer tipoPersonaId,
                                                         @Param("P_NUM_DOC_IDENTIDAD") Integer numDocIdentidad,
                                                         @Param("P_APE_PATERNO") Integer apellidoPaterno,
                                                         @Param("P_APE_MATERNO") Integer apellidoMaterno,
                                                         @Param("P_NOMBRES") Integer nombres,
                                                         @Param("P_RAZ_SOCIAL") Integer razonSocial,
                                                         @Param("P_NRO_PAGINA") Integer nroPagina,
                                                         @Param("P_TAM_PAGINA") Integer tamPagina,
                                                         @Param("P_TOTAL_FILAS") Integer totalRegistros
    );
    /*
     @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN, name = "P_TIPO_FILTRO"),
 @StoredProcedureParameter(type = Long.class, mode = ParameterMode.IN, name = "P_MUNICIPALIDAD_ID"),
 @StoredProcedureParameter(type = Long.class, mode = ParameterMode.IN, name = "P_CONTRIBUYENTE_NUMERO"),
 @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN, name = "P_TIP_PERSONA_ID"),
 @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN, name = "P_NUM_DOC_IDENTIDAD"),
 @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN, name = "P_APE_PATERNO"),
 @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN, name = "P_APE_MATERNO"),
 @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN, name = "P_NOMBRES"),
 @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN, name = "P_RAZ_SOCIAL"),
 @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN, name = "P_NRO_PAGINA"),
 @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN, name = "P_TAM_PAGINA"),
 @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.OUT, name = "P_TOTAL_FILAS"),
 @StoredProcedureParameter(type = void.class, mode = ParameterMode.REF_CURSOR)
    * */
}
