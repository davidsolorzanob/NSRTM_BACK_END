package com.nsrtm.contribuyente.microservice.repository;
import com.nsrtm.contribuyente.microservice.domain.ContactoContribuyente;
import com.nsrtm.contribuyente.microservice.domain.ContactoContribuyenteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoContribuyenteRepository extends JpaRepository<ContactoContribuyente, ContactoContribuyenteId>, ContactoContribuyenteCustomRepository {

}