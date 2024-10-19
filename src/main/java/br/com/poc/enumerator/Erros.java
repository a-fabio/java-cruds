package br.com.poc.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Erros {
    CATEGORIA_NOT_FOUND(1, "ERR-0001 - Categoria não encontrada.");

    Integer codigo;
    String mensagem;
}
