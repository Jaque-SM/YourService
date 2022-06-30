package projeto.web.yourservice.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import projeto.web.yourservice.Impl.UserImpl;
import projeto.web.yourservice.model.User;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserImpl user_service;


    @GetMapping
    public List<User> listarUsers(){
        return user_service.ListUser();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@Valid @RequestBody User user){
        return user_service.addUser(user);
    }

    @DeleteMapping("/{UserId}")
    public String removeUser(@PathVariable Long UserId, @RequestBody User user){

        if (user_service.ViewUser(UserId)==null){
            return "Nao encontrado o User";
        }
        user_service.removeUser(UserId);
        return "User removido com sucesso";

    }
    @PutMapping("/{UserId}")
    public String atualizarUser(@Valid @PathVariable Long UserId, @RequestBody User user  ){
    
        if (user_service.ViewUser(UserId)==null){
            return "Nao existe User com esse ID";

        }
        user.setId(UserId);
        user=user_service.addUser(user);
        return user.toString();
    }

   
    



    
}
