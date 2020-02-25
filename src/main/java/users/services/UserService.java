package users.services;

import users.domain.User;

import java.util.List;

public interface UserService {

    Iterable<User> findAllUsers();
    User findUserById(String id);
    User saveUser(User user);
    Iterable<User> saveAllUsers(List<User> users);
    void deleteUser(String id);
}
