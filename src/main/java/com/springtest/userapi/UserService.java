package com.springtest.userapi;
import org.springframework.stereotype.Service;
import java.util.List;


@Service // Anotação para indicar que esta classe é um serviço, ou seja,
// responsável por conter a lógica de negócio da aplicação,
public class UserService {
    
    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;

    }

    public void createUser(User user){
        repository.save(user);
    }

    public User getUserById(int id){
        return repository.findById(id)
             .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void updateUser (int id, String newName, int newAge){
        User user = repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));

        user.setName(newName);
        user.setAge(newAge);        

        repository.save(user);
    }

    public void deleteUser(int id){
        User user = repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
        repository.delete(user);
    }
    public List<User> getAllUsers(){
        return repository.findAll();
    }
  
    }


