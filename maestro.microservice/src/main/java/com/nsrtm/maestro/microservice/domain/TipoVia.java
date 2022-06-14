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
@Table(name ="VIA_TIPO", schema = "NSRTM")
public class TipoVia extends Auditoria
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIP_VIA_ID")
    public Integer tipoViaId;

    @Column(name = "DES_TIP_VIA")
    public String desTipoVia;

    @Column(name = "DES_ABR_TIP_VIA")
    public String desAbrTipoVia;

    public TipoVia() {
    }

    public TipoVia(Integer tipoViaId, String desTipoVia, String desAbrTipoVia) {
        this.tipoViaId = tipoViaId;
        this.desTipoVia=desTipoVia;
        this.desAbrTipoVia = desAbrTipoVia;
    }
}