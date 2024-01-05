package com.pocs.padrao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import java.util.List;

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
