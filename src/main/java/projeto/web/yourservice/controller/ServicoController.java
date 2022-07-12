package projeto.web.yourservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import projeto.web.yourservice.Impl.ServiceImpl;
import projeto.web.yourservice.model.User;
import projeto.web.yourservice.model.UserServices;

@RestController
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	private ServiceImpl servico;
	
   @GetMapping
   public List<UserServices> listarServicos(){
	   
	   return servico.ListServices();
   }
   
   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public UserServices addServico(@Valid @RequestBody UserServices servicos) throws Exception {
	   
	   return servico.AddService(servicos);
	   
   }
   
   @DeleteMapping("/{name}")
   public ResponseEntity <String> RemoveServico(@PathVariable String name){
	   
	   if (servico.ViewService(name)==null){
       	
           return ResponseEntity.ok("Nao encontrado o Servico");
       }
       servico.RemoveService(name);
       return ResponseEntity.ok("Removido o serivico do User");
	   
	   
	}
   
   
   
   
   
   
   
   
	
	

}
