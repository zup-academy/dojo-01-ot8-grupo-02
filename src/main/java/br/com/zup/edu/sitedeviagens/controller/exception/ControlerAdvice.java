package br.com.zup.edu.sitedeviagens.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControlerAdvice {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RegraNegocioException.class)
    public ErroDto valida(RegraNegocioException exception) {
        return exception.getErro();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ErroDto> errors = new ArrayList<>();
        List<FieldError> listFieldErrors = exception.getBindingResult().getFieldErrors();

        listFieldErrors.forEach(error -> {
            ErroDto erroDto = new ErroDto(error.getField(), error.getDefaultMessage());
            errors.add(erroDto);
        });
        return errors;
    }
}
