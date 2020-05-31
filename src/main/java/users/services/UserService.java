package users.services;

import org.springframework.stereotype.Service;
import users.domain.Stats;
import users.domain.User;

import java.util.List;

@Service

public interface UserService {

    Iterable<User> findAllUsers();
    Stats findUsersStats (String statsId);
    User findUserById(String id);
    User saveUser(User user);
    Iterable<User> saveAllUsers(List<User> users);
    void deleteUser(String id);
}
