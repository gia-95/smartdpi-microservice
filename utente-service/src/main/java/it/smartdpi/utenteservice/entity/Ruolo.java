package it.smartdpi.utenteservice.entity;

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
@Table(name = "ruoli")
public class Ruolo extends  BaseEntity{

    private String nome;

    @Column(name = "super_admin")
    private boolean superAdmin;

    @OneToMany(mappedBy = "ruolo",  fetch = FetchType.LAZY)
    private Set<Utente> utenti;

    @ManyToMany
    private Set<Funzione> funzioni;

}
