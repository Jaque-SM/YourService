package projeto.web.yourservice.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.web.yourservice.model.User;
import projeto.web.yourservice.repository.UserRepository;
import projeto.web.yourservice.services.UserService;

@Service
public class UserImpl implements UserService{
    
    @Autowired
    private UserRepository user_services;

    @Override
    public User addUser(User user) throws Exception {
        Optional<User> user1=user_services.findByEmail(user.getEmail());
        if (user1!=null&&user1.equals(user)){
        	throw new Exception("Ja existe um User com esse email");
      
        }

        return user_services.save(user);
    }

    @Override
    public String removeUser(Long id) {
        var user2=ViewUser(id);

        if (!user_services.existsById(id)){
            return "Não existe User com esse Id";
        }
        user_services.deleteById(id);
        
        return "User deletado com sucesso X)";
    }

    @Override
    public User updateUser(Long id, User user) {
        if (!user_services.existsById(id)){
            return null;
        }
        user.setId(id);
        user=user_services.save(user);
        return user;
    }

    @Override
    public List<User> ListUser() {
        return user_services.findAll();
    }
    
    public User findByEmail(String email) {
		Optional<User> user1=user_services.findByEmail(email);
		if (user1!=null){
			return user1.get();
		}
		return null;
	}
    @Override
    public User ViewUser(Long id) {
        Optional<User> user1=user_services.findById(id);

        if (user1.isPresent()){
            return user1.get();
        }
        return null;

    }



}
