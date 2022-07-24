package com.nsrtm.contribuyente.microservice.resource.model;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import com.nsrtm.contribuyente.microservice.domain.complex.CondicionContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;

public class ContribuyenteModel {
    public ContribuyenteCustom contribuyenteCustom;
    public CondicionContribuyenteCustom condicionContribuyenteCustom;
    public DomicilioContribuyente domicilioContribuyente;
    public RelacionadoCustom relacionadoCustom;

}
