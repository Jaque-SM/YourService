package projeto.web.yourservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.web.yourservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
	public abstract Optional<User> findByEmail(String email);


	public abstract User findByName(String name);

	
	
	
}
