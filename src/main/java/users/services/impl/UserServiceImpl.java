package users.services.impl;

import org.springframework.stereotype.Service;
import users.domain.User;
import users.repositories.UserRepository;
import users.services.UserService;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> saveAllUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
