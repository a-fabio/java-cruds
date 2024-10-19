package br.com.poc.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiExceptionDTO {

    private final String message;
    private final HttpStatus httpStatus;
    private final String timestamp;
    private final String details;

    public ApiExceptionDTO(String message, HttpStatus httpStatus, String details) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = LocalDateTime.now().toString();
        this.details = details;
    }
}