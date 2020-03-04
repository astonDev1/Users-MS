package users.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.domain.Stats;
import users.domain.User;
import users.services.StatsService;
import users.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    Environment environment;
    UserService userService;
    StatsService statsService;
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

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        User foundUser = userService.findUserById(id);
        try{
            if(foundUser == null){
                log.info("User not found!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            log .info("Users Found");
        } catch (StackOverflowError stack){
            log.info("Stack overflow :(");
        }
        return ResponseEntity.status(HttpStatus.OK).body(foundUser);

    }

    @GetMapping("/stats/{userStats}")
    public ResponseEntity<Stats> userStats(@PathVariable String userStats){
        Stats stats = userService.findUsersStats(userStats);
        if (stats == null) {
            log.info("User stats not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(stats);

        }
        return ResponseEntity.status(HttpStatus.OK).body(stats);

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

    @PatchMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User userToUpdate = userService.findUserById(user.getId());

        try{
            if (userToUpdate.getId().equals("") || userToUpdate.equals(null)){
                log.info("User not found!!!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userToUpdate);
            }
        } catch (NullPointerException nullP){
            log.info("null pointer exception");
        }

        userService.saveUser(user);

        userToUpdate = userService.findUserById(user.getId());

        log.info("User " + " " + userToUpdate.getFirstName() + " " + "updated successfully!");
        return ResponseEntity.status(HttpStatus.CREATED).body(userToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedUser(@PathVariable String id){
        User deletedUser = userService.findUserById(id);
        if (deletedUser == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error deleting user!!!");
        }
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

}
