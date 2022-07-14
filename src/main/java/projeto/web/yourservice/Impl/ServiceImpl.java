package projeto.web.yourservice.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.web.yourservice.model.Servico;
import projeto.web.yourservice.model.User;
import projeto.web.yourservice.repository.ServiceRepository;
import projeto.web.yourservice.services.Servicos;

@Service
public class ServiceImpl implements Servicos{

	@Autowired
	private ServiceRepository serves;

	@Override
	public Servico addServico(Servico user) throws Exception {
        Optional<Servico> user1=Optional.of(serves.findByDescription(user.getDescription()));

        if (user1!=null&&user1.equals(user.getDescription())){
        	throw new Exception("Ja existe um servico com essa descrição");
      
        }
        
		return serves.save(user);
	}

	@Override
	public String removeServico(Long id) {
		var user2=ViewServico(id);

        if (!serves.existsById(id)){
            return "Não existe Servico com esse Id";
        }
        serves.deleteById(id);
        
        return "Serviço deletado com sucesso X)";	
		
	}

	@Override
	public Servico updateServico(Long id, Servico user) {
		   if (!serves.existsById(id)){
	            return null;
	        }
	        user.setId(id);
	        user=serves.save(user);
	        return user;		
	}

	@Override
	public List ListServico() {
		// TODO Auto-generated method stub
		return serves.findAll();
	}

	@Override
	public Servico ViewServico(Long id) {
		   Optional<Servico> user1=serves.findById(id);

	        if (user1.isPresent()){
	            return user1.get();
	        }
	        return null;

	    }



}
