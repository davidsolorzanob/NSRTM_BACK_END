package com.nsrtm.contribuyente.microservice.resource.model;

import com.nsrtm.contribuyente.microservice.domain.ContactoContribuyente;
import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import com.nsrtm.contribuyente.microservice.domain.Relacionado;
import com.nsrtm.contribuyente.microservice.domain.complex.CondicionContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteCustom;

import java.util.List;

public class ContribuyenteModel {
    public ContribuyenteCustom contribuyente;
    public CondicionContribuyenteCustom condicionContribuyente;
    public DomicilioContribuyente domicilioContribuyente;
    public Relacionado relacionado;
    public List<ContactoContribuyente> contactos;
    public List<DomicilioContribuyente> domicilios;
}
