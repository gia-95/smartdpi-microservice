package it.smartdpi.commessaservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accessi")
public class Accesso extends  BaseEntity {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_operatore")
    private Operatore operatore;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_commessa", nullable = false)
    private Commessa commessa;

    @Column (name = "data_accesso")
    private Date dataAccesso;

    @Column(name = "ora_inzio")
    private Time oraInizio;

    @Column(name = "ora_fine")
    private Time oraFine;

    @Transient
    private String token;

}
