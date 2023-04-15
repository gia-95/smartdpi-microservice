package it.smartdpi.utenteservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tenant")
public class Tenant extends BaseEntity {

    private String azienda;

    @OneToMany(mappedBy = "tenant",  fetch = FetchType.LAZY)
    private Set<Utente> utenti;

//    @OneToMany(mappedBy = "dpi")
//    private Set<Dpi> dpis;

//    DA VEDERE
//    @OneToMany(mappedBy = "tenant")
//    @JsonIgnore
//	  @JsonIgnoreProperties("tenant")
//    private Set<Operatore> operatori;


}
