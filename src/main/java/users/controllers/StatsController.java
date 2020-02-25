package users.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import users.services.StatsService;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private static final Logger log = LoggerFactory.getLogger(StatsController.class);

    org.springframework.core.env.Environment environment;
    StatsService statsService;
    public StatsController(Environment environment, StatsService statsService) {
        this.environment = environment;
        this.statsService = statsService;
    }

    @GetMapping("/status")
    public String status(){
        log.info("Stats endpoint hit");
        return "Working on port " + " " + environment.getProperty("local.server.port");

    }

}
