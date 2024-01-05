package com.pocs.padrao.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.mapping.Join;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUTO")
public class Produto {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORIA_ID")
    private Categoria categoria;

}


