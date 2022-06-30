package projeto.web.yourservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import projeto.web.yourservice.model.User;

@Service
public interface UserService {
    public abstract User addUser(User user);

    public abstract String removeUser(Long id);

    public abstract User updateUser(Long id, User user);

    public abstract List ListUser();

    public abstract User ViewUser(Long id);

}
