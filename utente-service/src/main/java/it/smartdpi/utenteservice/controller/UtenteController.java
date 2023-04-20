package it.smartdpi.utenteservice.controller;

import it.smartdpi.utenteservice.dto.TenantDto;
import it.smartdpi.utenteservice.dto.UtenteDto;
import it.smartdpi.utenteservice.dto.ruoloDto.RuoloDto;
import it.smartdpi.utenteservice.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/{id}")
    public ResponseEntity<UtenteDto> getUtenteById(@PathVariable("id")Long idUtente) {
        UtenteDto utenteDto = this.utenteService.getUtenteById(idUtente);
        return ResponseEntity.ok(utenteDto);
    }

    @GetMapping("/ruolo/{id}")
    public ResponseEntity<RuoloDto> getRuoloByIdUtente (@PathVariable("id") Long idUtente) {
        RuoloDto ruoloDto = this.utenteService.getRuoloByIdUtente(idUtente);
        return ResponseEntity.ok(ruoloDto);
    }

    @GetMapping("/tenant/{id}")
    public ResponseEntity<TenantDto> getTenantByIdUtente (@PathVariable("id") Long idUtente) {
        TenantDto tenantDto = this.utenteService.getTenantByIdUtente(idUtente);
        return ResponseEntity.ok(tenantDto);
    }


}
