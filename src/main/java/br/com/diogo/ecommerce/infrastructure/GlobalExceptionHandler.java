package br.com.diogo.ecommerce.infrastructure;

import br.com.diogo.ecommerce.application.exception.ProdutoNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleProdutoNaoEncontradoException(ProdutoNaoEncontradoException e){
        return ResponseEntity.noContent().build();
    }
}
