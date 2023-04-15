package it.smartdpi.utenteservice.controller;

import it.smartdpi.utenteservice.dto.UtenteDto;
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
}
