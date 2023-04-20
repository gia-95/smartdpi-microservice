package it.smartdpi.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuoloDto {
    private Long id;
    private String nome;
    private Boolean superAdmin;
}
