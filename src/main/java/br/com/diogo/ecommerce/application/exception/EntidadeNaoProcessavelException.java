package br.com.diogo.ecommerce.application.exception;

public class EntidadeNaoProcessavelException extends RuntimeException {
    public EntidadeNaoProcessavelException(String message) {
        super(message);
    }
}
