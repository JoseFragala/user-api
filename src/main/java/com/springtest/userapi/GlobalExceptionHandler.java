package com.springtest.userapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Anotação para indicar que esta classe é um manipulador global de exceções,
// ou seja, ela irá interceptar as exceções lançadas em toda a aplicação e tratá-las de forma centralizada.
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class) //Anotação para indicar que este método
    // irá tratar as exceções do tipo UserNotFoundException.
    @ResponseStatus(HttpStatus.NOT_FOUND) // Anotação para indicar que a resposta HTTP para esta exceção
    // deve ter o status 404 (Not Found).
    public Map<String, Object> handleUserNotFoundException(UserNotFoundException ex){
    
        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("Status", 404);

        return error;

    }
    
}
