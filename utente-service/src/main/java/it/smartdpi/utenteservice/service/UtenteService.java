package it.smartdpi.utenteservice.service;

import it.smartdpi.utenteservice.dto.UtenteDto;
import it.smartdpi.utenteservice.dto.dpiDto.DpiDto;
import it.smartdpi.utenteservice.dto.ruoloDto.RuoloDtoForTenant;
import it.smartdpi.utenteservice.entity.Utente;
import it.smartdpi.utenteservice.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private APIClient apiClient;

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
                new RuoloDtoForTenant(utente.getRuolo().getNome(), utente.getRuolo().isSuperAdmin()));
        return utenteDto;
    }

    public List<DpiDto> getDpisByTenantOfUtente(Long idTenant) {
        ResponseEntity<List<DpiDto>> responseEntity = this.apiClient.getDpisByTenantOfUtente(idTenant);
        return responseEntity.getBody();
    }
}
