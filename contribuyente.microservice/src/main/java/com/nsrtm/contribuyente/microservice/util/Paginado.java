package com.nsrtm.contribuyente.microservice.util;

public class Paginado {
    public Integer tamanio;
    public Integer nroPagina;
    public Integer totalPaginas;

    public Paginado(Integer tamanio, Integer nroPagina, Integer totalPaginas) {
        this.tamanio = tamanio;
        this.nroPagina = nroPagina;
        this.totalPaginas = totalPaginas;
    }
}
