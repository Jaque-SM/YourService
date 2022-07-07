package projeto.web.yourservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.web.yourservice.model.UserServices;

public interface UserServicesRepository extends JpaRepository<UserServices, Long>{
	
	public abstract UserServices findByName(String name);
	
	
	

}
