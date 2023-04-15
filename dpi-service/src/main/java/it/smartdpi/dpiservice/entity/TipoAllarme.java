package it.smartdpi.dpiservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipi_allarme")
public class TipoAllarme extends BaseEntity {

    private String nome;

    private boolean bloccante;
}
