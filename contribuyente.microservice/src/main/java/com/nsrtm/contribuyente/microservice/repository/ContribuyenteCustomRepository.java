package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import com.nsrtm.contribuyente.microservice.util.PageRequest;
import com.nsrtm.contribuyente.microservice.util.PageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContribuyenteCustomRepository {
    /*
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
                                                         @Param("P_TOTAL_FILAS")  Integer totalRegistros
    );
    */
    ResponseEntity<Object> CrearContribuyente(ContribuyenteCustom custom);
    ResponseEntity<Object> ActualizarContribuyente(ContribuyenteCustom custom);
    PageResponse<List<ContribuyenteCustom>> ListaContribuyentePaginado(PageRequest<ContribuyenteCustom> custom);


}
