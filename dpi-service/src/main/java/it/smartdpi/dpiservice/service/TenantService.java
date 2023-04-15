package it.smartdpi.dpiservice.service;

import it.smartdpi.dpiservice.dto.TenantDto;
import it.smartdpi.dpiservice.entity.Tenant;
import it.smartdpi.dpiservice.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    public TenantDto getTenantById(Long idTenant) {
        Tenant tenant = this.tenantRepository.getTenantById(idTenant);
        TenantDto tenantDto = new TenantDto();
        tenantDto.setAzienda(tenant.getAzienda());
        tenantDto.setId(tenant.getId());
        return tenantDto;
    }

}