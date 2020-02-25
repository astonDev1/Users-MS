package users.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.domain.User;
import users.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    Environment environment;
    UserService userService;
    public UserController(Environment environment, UserService userService){
        this.environment = environment;
        this.userService = userService;
    }

    @GetMapping("/status")
    public String status(){
        log.info("Status Endpoint Hit");
        return "Working on port " + " " + environment.getProperty("local.server.port");
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<User>> getAllUsers(){
        Iterable<User> foundUsers = userService.findAllUsers();
        if (foundUsers == null){
            log.info("No Users In System");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        log.info("Users Found");
        return ResponseEntity.status(HttpStatus.OK).body(foundUsers);
    }
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.saveUser(user);
        if (createdUser.getId().equals("") || createdUser.getId() == null){
            log.info("Bad Creation, User Not Created");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(createdUser);
        }
        log.info("User " + " " + createdUser.getFirstName() + " " + "created and inserted successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }


}
