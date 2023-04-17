package it.smartdpi.dpiservice.controller;

import it.smartdpi.dpiservice.dto.DpiDto;
import it.smartdpi.dpiservice.service.DpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dpi")
public class DpiController {

    @Autowired
    private DpiService dpiService;

    @GetMapping("/tenant/{id}")
    public ResponseEntity<List<DpiDto>> getDpisByTenantId (@PathVariable("id") Long idTenant) {
        List<DpiDto> dpisDto = this.dpiService.getDpisByTenantId(idTenant);
        return ResponseEntity.ok(dpisDto);
    }
}
