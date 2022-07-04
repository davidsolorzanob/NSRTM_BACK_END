package com.nsrtm.contribuyente.microservice.util;

public class Paginado {
    public Integer tamanio;
    public Integer nroPagina;
    public Integer totalRegistros;

    public Paginado(Integer tamanio, Integer nroPagina, Integer totalRegistros) {
        this.tamanio = tamanio;
        this.nroPagina = nroPagina;
        this.totalRegistros = totalRegistros;
    }
}
