package it.smartdpi.commessaservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //#cambiato da False a True per permettere di utilizzare il metodo setDatiCancellazione, altrimenti non avrebbe aggiornato la data_cancellazione
    @Column(name = "data_cancellazione")
    protected Date dataCancellazione;

    @Column(name = "utente_inserimento")
    protected Long utenteInserimento;

    @Column(name = "data_inserimento")
    protected Date dataInserimento;

    @Column(name = "utente_ultima_modifica")
    protected Long utenteUltimaModifica;

    @Column(name = "data_ultima_modifica")
    protected Date dataUltimaModifica;

}