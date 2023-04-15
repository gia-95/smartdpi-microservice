package it.smartdpi.commessaservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sedi_commessa")
public class SedeCommessa extends  BaseEntity {

    private String nome;

    @ManyToOne()
    @JoinColumn(name = "id_commessa")
    private Commessa commessa;

    @OneToMany()
    private Set<Operatore> operatori;

}
