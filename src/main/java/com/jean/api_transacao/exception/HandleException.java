package com.jean.api_transacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {


    @ExceptionHandler(DataInvalidaException.class)
    public ResponseEntity<Void> handlerDataInvalideException(DataInvalidaException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    @ExceptionHandler(JsonIncorretoExcption.class)
    public ResponseEntity<Void> handlerJsonIncorretoExcption(JsonIncorretoExcption e) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(ValorIncorretoException.class)
    public ResponseEntity<Void> handlerValorIncorretoException(ValorIncorretoException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
}
