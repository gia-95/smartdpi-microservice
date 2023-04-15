package it.smartdpi.utenteservice.service;

import it.smartdpi.utenteservice.dto.TenantDto;
import it.smartdpi.utenteservice.entity.Tenant;
import it.smartdpi.utenteservice.repository.TenantRepository;
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