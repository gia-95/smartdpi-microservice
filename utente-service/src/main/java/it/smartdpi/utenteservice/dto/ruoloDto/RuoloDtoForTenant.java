package it.smartdpi.utenteservice.dto.ruoloDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RuoloDtoForTenant {

    private String nome;

    private boolean superAdmin;

}
