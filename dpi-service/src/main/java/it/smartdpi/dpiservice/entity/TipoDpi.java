package it.smartdpi.dpiservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipi_dpi")
public class TipoDpi extends  BaseEntity {

    private String nome;

    @Column(name = "nome_modello_tf")
    private String nomeModelloTF;

    @Column(name = "nome_icona")
    private String nomeIcona;


}
