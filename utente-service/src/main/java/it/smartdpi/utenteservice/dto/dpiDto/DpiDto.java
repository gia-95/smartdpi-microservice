package it.smartdpi.utenteservice.dto.dpiDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DpiDto {

    private Long id;

    private String codice;

    private String marca;

    private String modello;

    private Date dataScadenza;

    private String note;

//    private Tenant tenant;

//    private Beacon beacon;

//    private TipoDpi tipoDpi;

//    private Kit kit;

//    private Set<Allarme> allarmi;

//    private Set<Settore> settori;

}
