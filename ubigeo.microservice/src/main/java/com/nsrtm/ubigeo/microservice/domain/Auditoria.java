package com.nsrtm.ubigeo.microservice.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class Auditoria {
    @Column(name = "USUARIO_CREACION")
    public Long usuarioCreacion;
    @Column(name = "FECHA_CREACION")
    public Date fechaCreacion;

    @Column(name = "TERMINAL_CREACION")
    public String terminalCreacion;
    @Column(name = "USUARIO_MODIFICACION")
    public Long usuarioEdicion;
    @Column(name = "FECHA_MODIFICACION")
    public Date fechaModificacion;

    @Column(name = "TERMINAL_MODIFICACION")
    public String terminalModificacion;
}
