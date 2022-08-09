package com.nsrtm.contribuyente.reportes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

@Entity
@IdClass(ContribuyenteId.class)
public class ContribuyenteRequest {
    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Id
    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Column(name = "TIP_PERSONA_ID")
    public Integer tipoPersonaId;

    @Column(name = "DOC_IDENTIDAD_ID")
    public Integer docIdentidadId;

    @Column(name = "NUM_DOC_IDENTIDAD")
    public String numDocIdentidad;

    @Column(name = "APE_PATERNO")
    public String apellidoPaterno;

    @Column(name = "APE_MATERNO")
    public String apellidoMaterno;

    @Column(name = "NOMBRES")
    public String nombres;

    @Column(name = "RAZ_SOCIAL")
    public String razonSocial;

    @Column(name = "TIPO_ID")
    public Integer tipoFiltro;

}
