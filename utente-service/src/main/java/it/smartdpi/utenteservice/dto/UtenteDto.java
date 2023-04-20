package it.smartdpi.utenteservice.dto;

import it.smartdpi.utenteservice.dto.ruoloDto.RuoloDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UtenteDto {

    private String username;

    private String email;

    private String numeroTelefono;

    private String nome;

    private String cognome;

    private String tenant;

    private RuoloDto ruolo;

}
