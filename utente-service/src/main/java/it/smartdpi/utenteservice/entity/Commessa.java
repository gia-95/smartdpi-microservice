package it.smartdpi.utenteservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commesse")
public class Commessa extends  BaseEntity{


    private String nome;

    @ManyToMany(mappedBy = "commesse")
    private Set<Utente> utenti; //responsabili

//    @ManyToOne()
//    @JoinColumn(name = "id_settore")
//    private Settore settore;

//    @OneToMany(mappedBy = "commessa")
//    private Set<SedeCommessa> sediCommessa;


}
