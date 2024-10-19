package br.com.poc.controller.advice;

import br.com.poc.dto.ApiExceptionDTO;
import br.com.poc.exception.BackException;
import br.com.poc.exception.CategoriaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionAdvice {

    private ResponseEntity<ApiExceptionDTO> getApiExceptionResponseEntity(String message, Throwable e, HttpStatus statusCode) {
        Throwable tDetails;

        // Verifica se a exception é backend
        BackException exception = e instanceof BackException ? (BackException) e : null;


        if (exception != null && exception.getErroThrowable() != null) tDetails = exception.getErroThrowable(); // Tenta recuperar os detalhes do BackException (RuntimeException)

        else if (e != null && e.getCause() != null) tDetails = e.getCause(); // Pega a causa da exceção, quando não for BackException (RuntimeException)

        else tDetails = e; // Caso não tenha causa, joga o erro

        String details = tDetails == null ? "" : tDetails.toString();
        ApiExceptionDTO apiExceptionDTO = new ApiExceptionDTO(message, statusCode, details);

        return new ResponseEntity<>(apiExceptionDTO, statusCode);
    }

    @ExceptionHandler(value = {CategoriaNotFoundException.class})
    public ResponseEntity<ApiExceptionDTO> handleCategoriaNotFound(MethodArgumentNotValidException e) {
        System.out.println(e.getMessage());
        return getApiExceptionResponseEntity(e.getMessage(), e, HttpStatus.NOT_FOUND);
    }

}
