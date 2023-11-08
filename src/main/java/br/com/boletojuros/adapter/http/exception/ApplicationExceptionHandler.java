package br.com.boletojuros.adapter.http.exception;

import br.com.boletojuros.core.exception.ApplicationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.Date;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> applicationException(ApplicationException ex, WebRequest request){
        var response = ErrorResponse.builder()
                .mensagens(Collections.singletonList(ex.getTipoExcecao().getMessageError()))
                .erro(ex.getTipoExcecao().toString().toLowerCase())
                .codigo(HttpStatus.BAD_REQUEST.value())
                .timesTamp(new Date())
                .path(request.getDescription(false))
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
       var erros = ex.getFieldErrors().stream()
               .map(item -> item.getField() + " " + item.getDefaultMessage())
               .toList();

        var response = ErrorResponse.builder()
                .mensagens(erros)
                .erro("Erro na validação")
                .codigo(HttpStatus.BAD_REQUEST.value())
                .timesTamp(new Date())
                .path(request.getDescription(false))
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
