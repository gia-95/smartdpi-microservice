package it.smartdpi.dpiservice.repository;

import it.smartdpi.dpiservice.entity.Dpi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DpiRepository extends JpaRepository<Dpi, Long> {

    public List<Dpi>  getDpiByTenantId(Long tenantId);
}
