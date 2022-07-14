package projeto.web.yourservice.services;

import java.util.List;
import org.springframework.stereotype.Service;

import projeto.web.yourservice.model.Servico;
import projeto.web.yourservice.model.User;

@Service
public interface Servicos {
	

    public abstract Servico addServico(Servico user) throws Exception;

    public abstract String removeServico(Long id);

    public abstract Servico updateServico(Long id, Servico user);

    public abstract List ListServico();

    public abstract Servico ViewServico(Long id);
}
