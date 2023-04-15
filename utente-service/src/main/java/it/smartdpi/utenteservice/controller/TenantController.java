package it.smartdpi.utenteservice.controller;

import it.smartdpi.utenteservice.dto.TenantDto;
import it.smartdpi.utenteservice.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping(value = "")
    public int testMethod() {
        return 3;
    }

    @GetMapping(value = "{id}",  produces = "application/json" )
    public ResponseEntity<TenantDto> getTenantById(@PathVariable(name = "id") Long idTenant) {
        TenantDto tenantDto = this.tenantService.getTenantById(idTenant);
        return ResponseEntity.ok(tenantDto);
    }
}
