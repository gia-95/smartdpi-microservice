package it.smartdpi.authservice.service;

import it.smartdpi.authservice.dto.AuthRequest;
import it.smartdpi.authservice.dto.LoginDto;
import it.smartdpi.authservice.dto.RuoloDto;
import it.smartdpi.authservice.dto.TenantDto;
import it.smartdpi.authservice.entity.UserCredential;
import it.smartdpi.authservice.repository.UserCredentialRepository;
import it.smartdpi.authservice.util.Constans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RestTemplate restTemplate;


    public String saveUser(UserCredential userCredential) {
        // Crypta password e salva nel DB
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        this.userCredentialRepository.save(userCredential);
        return "User add correctly!";
    }

    public String generateToken(String username, Long idTenant) {
        return this.jwtService.generateToken(username, idTenant);
    }

    public void validateToken(String token) {
        this.jwtService.validateToken(token);
    }

    public LoginDto loginInConsole(AuthRequest authRequest) {
        UserCredential utente = fetchUtenteAndVerifyPassword(authRequest); // 'Usercredential' sarebbe Utente, ma nelle configurazioni di Auth è stato chiamato così....
        RuoloDto ruoloDto = this.fetchRuoloUtente(utente);
        TenantDto tenantDto = this.fetchTenantUtente(utente);
        String token = this.generateToken(utente.getUsername(), tenantDto.getId());

        LoginDto loginDto = this.setCampiLoginDto(utente, ruoloDto, tenantDto, token);
        return loginDto;
    }

    private UserCredential fetchUtenteAndVerifyPassword(AuthRequest authRequest) {
        Optional<UserCredential> utenteOptional = this.userCredentialRepository.findByUsername(authRequest.getUsername());
        if (utenteOptional.isEmpty()) {
            throw new RuntimeException("Utente " + authRequest.getUsername() + "non presente nel DB.");
        }

        UserCredential utente = utenteOptional.get();
        if (!passwordEncoder.matches(authRequest.getPassword(), utente.getPassword())) {
            throw new RuntimeException(" Password non corretta...");
        }
        return utente;
    }

    private RuoloDto fetchRuoloUtente(UserCredential utente) {
        RuoloDto ruoloDto;
        try {
            ruoloDto = this.restTemplate.getForObject(Constans.UTENTE_SERVICE_URL + "/utente/ruolo/" + utente.getId(), RuoloDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Errore nella chiamata a UTENTE-SERVICE...");
        }

        if (ruoloDto == null) {
            throw new RuntimeException("Ruolo utente non trovato...");
        }
        return ruoloDto;
    }

    private TenantDto fetchTenantUtente(UserCredential utente) {
        TenantDto tenantDto;
        try {
            tenantDto = this.restTemplate.getForObject(Constans.UTENTE_SERVICE_URL + "/utente/tenant/" + utente.getId(), TenantDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Errore nella chiamata a UTENTE-SERVICE...");
        }

        if (tenantDto == null) {
            throw new RuntimeException("Tenant utente non trovato...");
        }
        return tenantDto;
    }

    private LoginDto setCampiLoginDto(UserCredential utente, RuoloDto ruoloDto, TenantDto tenantDto, String token) {
        LoginDto loginDto = new LoginDto(
                utente.getId(),
                utente.getNome(),
                utente.getCognome(),
                utente.getUsername(),
                utente.getEmail(),
                utente.getNumeroTelefono(),
                ruoloDto,
                tenantDto,
                token);

        return loginDto;
    }


}
