package it.smartdpi.dpiservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "beacon")
public class Beacon extends  BaseEntity{

    private String seriale;

    @Column(name = "livello_batteria", insertable=false)
    private int livelloBatteria;

    @ManyToOne()
    @JoinColumn(name = "id_tipo_beacon", nullable = false)
    private TipoBeacon tipoBeacon;

    @OneToOne()
    @JoinColumn(name = "id_dpi", nullable = true)
    private Dpi dpi;

}
