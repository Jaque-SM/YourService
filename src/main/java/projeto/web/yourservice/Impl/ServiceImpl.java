package projeto.web.yourservice.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.web.yourservice.model.User;
import projeto.web.yourservice.model.UserServices;
import projeto.web.yourservice.repository.UserServicesRepository;
import projeto.web.yourservice.services.Services;


@Service
public class ServiceImpl implements Services{
	
	@Autowired
	private UserServicesRepository serves;

	@Override
	public UserServices AddService(UserServices servicos) throws Exception {
        UserServices user1=serves.findByName(servicos.getId());

      if (user1!=null&user1.equals(user1)) {
      	throw new Exception("Ja existe um serviço com esse id");

      }
		return serves.save(servicos);
	}

	@Override
	public String RemoveService(String name) {
		UserServices varch=serves.findByName(name);
        
        if (ViewService(name)==null) {
        	return "Nao existe serviço com esse name";
        }
        serves.delete(varch);
		
		return "Serviço excluido com sucesso!";
	}

	@Override
	public UserServices UpdateService(Long id, UserServices servicos) {

		if (!serves.existsById(id)){
			
			return null;
		}
		
		String idString=String.valueOf(id);
		
		servicos.setId(idString);
		servicos=serves.save(servicos);
		
		return servicos;
	}

	@Override
	public List ListServices() {
		return serves.findAll();
	}


	@Override
	public UserServices ViewService(String name) {
	  Optional<UserServices> user1=Optional.ofNullable(serves.findByName(name));

	        if (user1.isPresent()){
	            return user1.get();
	        }
	        return null;

	  }

		
		
	


	
	
	
	

}
