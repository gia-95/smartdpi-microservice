package it.smartdpi.utenteservice.repository;

import it.smartdpi.utenteservice.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

    Tenant getTenantById(Long id);
}
