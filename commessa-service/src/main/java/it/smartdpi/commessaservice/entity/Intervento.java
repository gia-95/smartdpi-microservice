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
@Entity
@Table(name = "interventi")
public class Intervento extends BaseEntity{

    @ManyToOne()
    @JoinColumn(name = "id_operatore")
    private Operatore operatore;

    @Column(name = "data_inizio")
    private Date dataInizio;

    @Column(name = "data_fine")
    private Date dataFine;

    private String latitudine;

    private String longitudine;


}
