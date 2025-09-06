package br.com.diogo.ecommerce.application.exception;

public class CategoriaNaoEncontradaException extends RuntimeException{

    public CategoriaNaoEncontradaException(String message) {
        super(message);
    }
}
