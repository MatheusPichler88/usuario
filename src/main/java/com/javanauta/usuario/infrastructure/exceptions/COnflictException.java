package com.javanauta.usuario.infrastructure.exceptions;

public class COnflictException extends RuntimeException{

    public COnflictException(String message) {
        super(message);
    }

    public COnflictException(String mensagem, Throwable throwable) {
        super(mensagem);
    }
}
