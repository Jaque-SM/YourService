package projeto.web.yourservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.web.yourservice.model.Servico;

@Repository
public interface ServiceRepository extends JpaRepository<Servico, Long>{

	Servico findByDescription (String description);

		
			

		
}



