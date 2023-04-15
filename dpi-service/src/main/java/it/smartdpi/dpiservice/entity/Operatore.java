package it.smartdpi.dpiservice.entity;

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
    @JoinColumn(name = "id_tipo_operatore", nullable = false)
    private TipoOperatore tipoOperatore;

    @JsonIgnore
    @Column(name = "password_originale")
    private String passwordOriginale;

//    @OneToMany(mappedBy = "operatore", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("operatore")
//    private Set<OperatoreSedeCommessa> operatoreSediCommesse;

    @OneToMany(mappedBy = "operatore")
    private Set<Kit> kit;


}
