package br.com.diogo.ecommerce.infrastructure;

import br.com.diogo.ecommerce.application.exception.CategoriaNaoEncontradaException;
import br.com.diogo.ecommerce.application.exception.EntidadeNaoProcessavelException;
import br.com.diogo.ecommerce.application.exception.ProdutoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<String> handleProdutoNaoEncontradoException(ProdutoNaoEncontradoException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    public ResponseEntity<String> handleCategoriaNotFoundException(CategoriaNaoEncontradaException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntidadeNaoProcessavelException.class)
    public ResponseEntity<String> handleEntidadeNaoProcessavelException(EntidadeNaoProcessavelException e){
        return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
}
