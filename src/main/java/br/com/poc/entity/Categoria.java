package br.com.poc.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

}
