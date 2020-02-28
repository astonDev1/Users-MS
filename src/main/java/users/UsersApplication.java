package users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import users.seeds.StatsSeed;


@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = {"users.domain"})
public class UsersApplication {



    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }



}
