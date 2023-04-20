package it.smartdpi.utenteservice.dto.ruoloDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RuoloDto {

    private Long id;

    private String nome;

    private boolean superAdmin;

}
