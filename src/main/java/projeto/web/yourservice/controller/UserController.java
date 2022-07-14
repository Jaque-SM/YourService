package projeto.web.yourservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    public User addUser(@Valid @RequestBody User user) throws Exception{
        return user_service.addUser(user);
    }
    

    @DeleteMapping("/{UserId}")
    public ResponseEntity <String> removeUser(@PathVariable Long UserId, @RequestBody User user){

        if (user_service.ViewUser(UserId)==null){
        	
            return ResponseEntity.ok("Nao encontrado o User");
        }
        user_service.removeUser(UserId);
        return ResponseEntity.ok("Encontrado  User");

        
    }
    
    @PutMapping("/{UserId}")
    public ResponseEntity <String>  atualizarUser(@Valid @PathVariable Long UserId, @RequestBody User user  ) throws Exception{
    
        if (user_service.ViewUser(UserId)==null){
            return ResponseEntity.ok("Nao existe User com esse ID");

        }
        user_service.updateUser(UserId, user);
        return ResponseEntity.ok(user.toString());
    }
    
    
    @RequestMapping(value = "/{UserId}", method = RequestMethod.GET)
    public ResponseEntity<User> SearchById(@Valid @PathVariable Long UserId){
    	Optional<User> user = Optional.ofNullable(user_service.ViewUser(UserId));
    	
    	
    	if (user_service.ViewUser(UserId)==null) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	user_service.ViewUser(UserId);
    	return ResponseEntity.ok(user.get());
    	
    }

   
    



    
}
