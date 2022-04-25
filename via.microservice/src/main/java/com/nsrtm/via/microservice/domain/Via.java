package com.nsrtm.via.microservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name ="via", schema = "public")
public class Via extends Auditoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "via_id")
    public Long viaId;

    @Column(name = "base_legal_id")
    public Integer baseLegalId;

    @Column(name = "sec_ejec")
    public String secEjec;

    @Column(name = "codigo_via")
    public String codigoVia;

    @Column(name = "tipo_via")
    public String tipoVia;

    @Column(name = "nombre_via")
    public String nombreVia;

    @Column(name = "situacion_via")
    public String situacionVia;

    @Column(name = "tramo_inicio")
    public String tramoInicio;

    @Column(name = "tramo_fin")
    public String tramoFin;

    @Column(name = "situacion")
    public String situacion;

    @Column(name = "alias")
    public String alias;

    @Column(name = "estado")
    public String estado;

    public Via() {
    }

    public Via(Long viaId, Integer baseLegalId, String secEjec, String codigoVia, String tipoVia, String nombreVia,
               String situacionVia, String tramoInicio, String tramoFin, String situacion, String alias, String estado) {
        this.viaId = viaId;
        this.baseLegalId = baseLegalId;
        this.secEjec = secEjec;
        this.codigoVia = codigoVia;
        this.tipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.situacionVia = situacionVia;
        this.tramoInicio = tramoInicio;
        this.tramoFin = tramoFin;
        this.situacion = situacion;
        this.alias = alias;
        this.estado = estado;
    }
}
