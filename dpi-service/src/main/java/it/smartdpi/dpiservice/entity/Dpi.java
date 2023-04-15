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
@Table(name = "dpi")
public class Dpi extends BaseEntity {

    private String codice;

    private String marca;

    private String modello;

    @Column(name = "data_scadenza")
    private Date dataScadenza;

    private String note;

    @ManyToOne()
    @JoinColumn(name = "id_tenant")
    private Tenant tenant;

//  DA VERIFICARE SE è OneToOne o OneToMany
//  @OneToOne(fetch = FetchType.EAGER, optional = true)
//	@JoinColumn(name = "id_beacon", nullable = true)
//	@JsonIgnoreProperties("dpi")
//  @ManyToOne(fetch = FetchType.EAGER, optional = false)
//  @JoinColumn(name = "id_beacon", nullable = false)
//  @JsonIgnoreProperties("dpi")
    @OneToOne()
    @JoinColumn(name = "id_beacon", nullable = true)
    private Beacon beacon;

    @ManyToOne()
    @JoinColumn(name = "id_tipo_dpi")
    private TipoDpi tipoDpi;

    @ManyToOne()
    @JoinColumn(name = "id_kit")
    private Kit kit;

    @OneToMany(mappedBy = "dpi")
    private Set<Allarme> allarmi;

    @ManyToMany()
    private Set<Settore> settori;

}
