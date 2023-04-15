package it.smartdpi.dpiservice.repository;

import it.smartdpi.dpiservice.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

    Tenant getTenantById(Long id);
}
