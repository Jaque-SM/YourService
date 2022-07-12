package projeto.web.yourservice.services;

import projeto.web.yourservice.model.UserServices;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface Services {
	
	
	public abstract UserServices AddService(UserServices servicos) throws Exception;
	
	public abstract String RemoveService(String name);
	
	public abstract UserServices UpdateService(Long id, UserServices servicos);
	
	public abstract List ListServices();
		
	public abstract UserServices ViewService(String name);
	

}
