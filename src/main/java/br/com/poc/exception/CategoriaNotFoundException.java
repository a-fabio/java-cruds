package br.com.poc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class CategoriaNotFoundException extends BackException {

    public CategoriaNotFoundException() {
    }

    public CategoriaNotFoundException(String msg) {
        super(msg);
    }

    public CategoriaNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CategoriaNotFoundException(Throwable cause) {
        super(cause);
    }

}
