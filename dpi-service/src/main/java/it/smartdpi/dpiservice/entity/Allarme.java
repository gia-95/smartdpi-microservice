package it.smartdpi.dpiservice.entity;

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
@Entity
@Table(name = "allarmi")
public class Allarme extends  BaseEntity{

    @Column(name = "data_allarme")
    private Date dataAllarme;

    private String latitudine;

    private String longitudine;

    @ManyToOne()
    @JoinColumn(name = "id_dpi")
    private Dpi dpi;

    @ManyToOne()
    @JoinColumn(name = "id_tipo_allarme")
    private TipoAllarme tipoAllarme;

    @ManyToOne()
    @JoinColumn(name = "id_stato_allarme")
    private StatoAllarme statoAllarme;

    private Long utentePresaInCarico;

    private Long utenteRisoluzione;

    @Column(name = "data_presa_in_carico")
    private Date dataPresaInCarico;


    @Column(name = "data_risoluzione")
    private Date dataRisoluzione;

    @Column(name = "falso_allarme")
    private boolean falsoAllarme;

    private String note;

}
