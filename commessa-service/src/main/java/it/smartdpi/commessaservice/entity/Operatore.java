package it.smartdpi.commessaservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "operatori")
public class Operatore extends BaseEntity {

    private String matricola;

    @JsonIgnore
    private String password;

    private String nominativo;

    @Column(name = "id_dispositivo")
    private String idDispositivo;

    @Column(name = "numero_telefono")
    private String numeroTelefono;

    private String email;

    @ManyToOne()
    @JoinColumn(name = "id_tipo_operatore")
    private TipoOperatore tipoOperatore;

    @JsonIgnore
    @Column(name = "password_originale")
    private String passwordOriginale;

    @ManyToOne()
    @JoinColumn(name = "id_sede_commessa")
    private SedeCommessa sedeCommessa;

    @OneToMany(mappedBy = "operatore")
    private Set<Accesso> accessi;

    @OneToMany(mappedBy = "operatore")
    private Set<Intervento> interventi;


//    @OneToMany(mappedBy = "operatore")
//    private Set<Kit> kit;


}
