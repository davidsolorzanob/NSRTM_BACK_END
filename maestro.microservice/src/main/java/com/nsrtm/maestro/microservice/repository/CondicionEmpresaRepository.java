package com.nsrtm.maestro.microservice.repository;
import com.nsrtm.maestro.microservice.domain.CondicionEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CondicionEmpresaRepository  extends JpaRepository<CondicionEmpresa, Integer> {
}
