package com.nsrtm.maestro.microservice.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Builder
@Entity
@Table(name ="MED_DETERMINACION_TIPO", schema = "NSRTM")
public class TipoDocumentoIdentidad extends Auditoria
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCUMENTO_IDN_TIPO_ID")
    public Integer tipoDocumentoId;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

    @Column(name = "LONGITUD_MINIMA")
    public Integer longitudMinima;

    @Column(name = "LONGITUD_MAXIMA")
    public Integer longitudMaxima;

    @Column(name = "ACTIVO")
    public Integer Activo;

    public TipoDocumentoIdentidad() {
    }

    public TipoDocumentoIdentidad(Integer id, String descripcion, String abreviatura, Integer longitudMinima, Integer longitudMaxima, Integer activo) {
        this.tipoDocumentoId = id;
        this.descripcion=descripcion;
        this.abreviatura = abreviatura;
        this.longitudMinima = longitudMinima;
        this.longitudMaxima = longitudMaxima;
        this.Activo = Activo;
    }
}