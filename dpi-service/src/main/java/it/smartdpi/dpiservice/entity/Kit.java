package it.smartdpi.dpiservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kits")
public class Kit extends  BaseEntity{

    @OneToMany(mappedBy = "kit")
    private Set<Dpi> dpis;

    @ManyToOne()
    @JoinColumn(name = "id_operatore")
    private Operatore operatore;

    @ManyToOne()
    @JoinColumn(name = "id_settore", nullable = true)
    private Settore settore;

    private String modello;

    private String note;

    @Column(name = "note_sblocco_totale")
    private String noteSbloccoTotale;

    @Column(name = "data_assegnazione")
    private Date dataAssegnazione;

}
