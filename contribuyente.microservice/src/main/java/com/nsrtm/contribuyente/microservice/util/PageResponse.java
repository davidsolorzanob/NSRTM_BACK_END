package com.nsrtm.contribuyente.microservice.util;

public class PageResponse<T> extends Page<T> {
    public Integer totalRows;

    public PageResponse(Integer size, Integer nroPage) {
        this.size = size;
        this.nroPage = nroPage;
    }
}
