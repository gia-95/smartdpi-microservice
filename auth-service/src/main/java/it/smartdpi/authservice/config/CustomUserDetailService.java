package it.smartdpi.authservice.config;

import it.smartdpi.authservice.entity.UserCredential;
import it.smartdpi.authservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch dal DB dell'utente con l'username passato
        Optional<UserCredential> credential = this.userCredentialRepository.findByUsername(username);

        // Questo CustomUserDetailService usa la classe CustomUserDetail (che implementa l'interfaccia UserDetail di spring security)
        // per gestire le varie proprietà di autenticazione
        // Praticamente trasforma l'utente preso dal DB in un oggetto UserDetail per settare le altre proprietà
        // (vedere la classe)
        // (Vedere anche @Bean AuthenticationProvider in classe AuthConfig)
        return credential.map(CustomUserDetail::new).orElseThrow(() -> new UsernameNotFoundException("user not found with name: " + username));
    }
}
