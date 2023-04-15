package it.smartdpi.dpiservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stati_allarme")
public class StatoAllarme extends  BaseEntity {

    private String nome;

    @Column(name = "stato_iniziale")
    private boolean statoIniziale;

    @Column(name = "stato_finale")
    private boolean statoFinale;

    @Column(name = "sblocco_automatico_operatore")
    private boolean sbloccoAutomaticoOperatore;

}
