package it.smartdpi.utenteservice.service;

import it.smartdpi.utenteservice.dto.dpiDto.DpiDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "DPI-SERVICE")
public interface APIClient {

    @GetMapping("dpi/tenant/{idTenant}")
    ResponseEntity<List<DpiDto>> getDpisByTenantOfUtente (@PathVariable("idTenant") Long idTenant);
}
