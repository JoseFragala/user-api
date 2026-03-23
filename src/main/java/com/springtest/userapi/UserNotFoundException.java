package com.springtest.userapi;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int id) {
        super("Usuário com ID " + id + " não encontrado.");

    }
    
}
