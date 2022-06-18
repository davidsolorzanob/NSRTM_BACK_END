package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="RE_CONTRIBUYENTE", schema = "NSRTM")
public class Relacionado extends Auditoria {

    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Column(name = "REL_CONTRIBUYENTE_NUMERO")
    public Long relContribuyenteNumero;

    @Column(name = "PERSONA_ID")
    public Long personaId;

    @Column(name = "TIP_RELACIONADO_ID")
    public Integer tipoRelacionadoId;

    @Column(name = "FEC_INSCRIPCION")
    public Date fechaInscripcion;

    @Column(name = "FEC_VIG_INICIAL")
    public Date fechaVigenciaInicial;

    @Column(name = "FEC_VIG_FINAL")
    public Date fechaVigenciaFinal;

    @Column(name = "ESTADO_ID")
    public Integer estadoId;

}
