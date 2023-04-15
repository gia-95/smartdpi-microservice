package it.smartdpi.utenteservice.service;

import it.smartdpi.utenteservice.dto.RuoloForTenantDto;
import it.smartdpi.utenteservice.dto.UtenteDto;
import it.smartdpi.utenteservice.entity.Utente;
import it.smartdpi.utenteservice.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public UtenteDto getUtenteById(Long idUtente) {
        Utente utente = this.utenteRepository.getUtenteById(idUtente);
        UtenteDto utenteDto = new UtenteDto(
                utente.getUsername(),
                utente.getEmail(),
                utente.getNumeroTelefono(),
                utente.getNome(),
                utente.getCognome(),
                utente.getTenant().getAzienda(),
                new RuoloForTenantDto(utente.getRuolo().getNome(), utente.getRuolo().isSuperAdmin()));
        return utenteDto;
    }
}
