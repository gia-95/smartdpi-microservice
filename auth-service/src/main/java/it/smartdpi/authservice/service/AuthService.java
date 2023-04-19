package it.smartdpi.authservice.service;

import it.smartdpi.authservice.entity.UserCredential;
import it.smartdpi.authservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


     public String saveUser (UserCredential  userCredential) {
         // Crypta password e salva nel DB
         userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
         this.userCredentialRepository.save(userCredential);
         return "User add correctly!";
     }

     public String generateToken (String username) {
         return this.jwtService.generateToken(username);
     }

     public void validateToken (String token) {
         this.jwtService.validateToken(token);
     }

}
