package com.springtest.userapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Anotação para indicar que esta classe é um controlador REST 
// diz para  o Spring "Essa classe responde a requisições HTTP e os métodos dentro dela são endpoints"
@RequestMapping("/users") // Anotação para mapear requisições para o endpoint "/users"
public class UserController {

    private final UserService service;

    public UserController(UserService service){ // Injeção de dependência do UserService,
        // ou seja, o Spring vai criar uma instância do UserService 
        // e passar para o construtor do UserController
        this.service = service;
    }

    // criar usuário

    @PostMapping // Anotação para mapear requisições POST para este método
    public void createUser(@RequestBody User user){ // @RequestBody indica que o corpo da requisição
    //  deve ser convertido para um objeto User
        service.createUser(user);
    }

    // Listar usuários

    @GetMapping // Anotação para mapear requisições GET para este método
    public List<User> getUsers(){
        return service.getAllUsers();
    }
    @GetMapping("/{id}") // Anotação para mapear requisições GET para este método, 
    // com um parâmetro de caminho "id"
    public User getUserById(@PathVariable int id){// @PathVariable indica que o valor do parâmetro "id"
   System.out.println(">>>CONTROLLER HIT with id: " + id);
    //  na URL deve ser passado para o método como um argumento
        return service.getUserById(id);
    }
    @DeleteMapping("/{id}") // Anotação para mapear requisições DELETE para este método,
    public void deleteUser(@PathVariable int id){ // @PathVariable indica que o valor do parâmetro 
    // "id" na URL deve ser passado para o método como um argumento
        service.deleteUser(id);
    }
    @PutMapping("/{id}") // Anotação para mapear requisições PUT para este método,
    public void updateUser(@PathVariable int id, @RequestBody User user){ // @PathVariable indica que o
    //  valor do parâmetro "id" 
    // na URL deve ser passado para o método como um argumento, e @RequestBody
    //  indica que o corpo da requisição deve ser convertido para um objeto User
        service.updateUser(id, user.getName(), user.getAge());
    }
   
    
}
