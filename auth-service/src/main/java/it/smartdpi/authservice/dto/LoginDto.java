package it.smartdpi.authservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private int id;
    private String nome;
    private String cognome;
    private String username;
    private String email;
    @Column(name = "numero_telefono")
    private String numeroTelefono;

    private RuoloDto ruolo;

    private TenantDto tenant;

    private String token;
}
