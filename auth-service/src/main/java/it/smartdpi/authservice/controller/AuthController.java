package it.smartdpi.authservice.controller;

import it.smartdpi.authservice.dto.AuthRequest;
import it.smartdpi.authservice.entity.UserCredential;
import it.smartdpi.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public String addUser(@RequestBody UserCredential user) {
        return this.authService.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        // Authentication Manager usa la classe UserDetailService (CustomUserDetalService) per la verifica
        // (dipendenze interne di Spring Security)
        // (metodo @Override loadUserByUsername in classe CustomuserDetailService)
        Authentication authenticate = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return this.authService.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("Invalid authentication...");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("Token") String token) {
        this.authService.validateToken(token);
        return "Token is valid!";
    }


}
