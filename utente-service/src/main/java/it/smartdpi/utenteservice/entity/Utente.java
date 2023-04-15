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
@Table(name = "utenti")
public class Utente extends BaseEntity{

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    @Column(name = "numero_telefono")
    private String numeroTelefono;

    private String nome;

    private String cognome;

    @ManyToOne
    @JoinColumn(name = "id_tenant")
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "id_ruolo")
    private Ruolo ruolo;

    @ManyToMany()
    private Set<Commessa> commesse;

}
