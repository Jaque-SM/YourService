package projeto.web.yourservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import projeto.web.yourservice.Impl.ServiceImpl;
import projeto.web.yourservice.model.Servico;
import projeto.web.yourservice.model.User;

@RestController
@RequestMapping("/servico")
public class ServiceController {
	
    @Autowired
	private ServiceImpl serves;
	
    @GetMapping
    public List<Servico> listarUsers(){
        return serves.ListServico();
    }
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico  addServico(@Valid @RequestBody Servico user) throws Exception{
        return serves.addServico(user);
    }
    
    @DeleteMapping("/{Id}")
    public ResponseEntity <String> removeUser(@PathVariable Long Id, @RequestBody User user){

        if (serves.ViewServico(Id)==null){
        	
            return ResponseEntity.ok("Nao encontrado o serviço");
        }
        serves.removeServico(Id);
        return ResponseEntity.ok("Encontrado e deletado o serviço");

    }
    @PutMapping("/{UserId}")
    public ResponseEntity <String>  atualizarUser(@Valid @PathVariable Long UserId, @RequestBody Servico user  ) throws Exception{
    
        if (serves.ViewServico(UserId)==null){
            return ResponseEntity.ok("Nao existe User com esse ID");

        }
        serves.updateServico(UserId, user);
        return ResponseEntity.ok(user.toString());
    }
    
    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public ResponseEntity<Servico> SearchById(@Valid @PathVariable Long Id){
    	Optional<Servico> user = Optional.ofNullable(serves.ViewServico(Id));
    	
    	
    	if (serves.ViewServico(Id)==null) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	serves.ViewServico(Id);
    	return ResponseEntity.ok(user.get());
    	
    }

}
