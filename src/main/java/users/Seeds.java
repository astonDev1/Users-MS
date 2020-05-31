package users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import users.domain.Stats;
import users.domain.User;
import users.services.StatsService;
import users.services.UserService;

@Component
public class Seeds implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private StatsService statsService;

    @Autowired
    private UserService userService;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        mongoTemplate.getDb().drop();
        seedStatsTable();
    };


    public void seedStatsTable() {

        Stats tuckStats = new Stats();
        tuckStats.setId("1");
        tuckStats.setLosses(5);
        tuckStats.setWins(5);
        statsService.saveStats(tuckStats);

        Stats ericStats = new Stats();
        ericStats.setId("2");
        ericStats.setLosses(1);
        ericStats.setWins(4);
        statsService.saveStats(ericStats);

        Stats camStats = new Stats();
        camStats.setId("3");
        camStats.setLosses(3);
        camStats.setWins(3);
        statsService.saveStats(camStats);

        Stats justinStats = new Stats();
        justinStats.setId("4");
        justinStats.setLosses(3);
        justinStats.setWins(3);
        statsService.saveStats(justinStats);

        /////////////////////////////////

        User tuckerUser = new User();
        tuckerUser.setId("u1");
        tuckerUser.setEmail("tucker@gmail");
        tuckerUser.setAdmin(false);
        tuckerUser.setFirstName("Tucker");
        tuckerUser.setLastName("Nemcek");
        tuckerUser.setUsername("TuckMeGently");
        tuckerUser.setStatId("1");
        userService.saveUser(tuckerUser);

        User ericUser = new User();
        ericUser.setId("u2");
        ericUser.setEmail("eric@gmail");
        ericUser.setAdmin(true);
        ericUser.setFirstName("Eric");
        ericUser.setLastName("Bye");
        ericUser.setUsername("EricTheRed");
        ericUser.setStatId("2");
        userService.saveUser(ericUser);


        User camUser = new User();
        camUser.setId("u3");
        camUser.setEmail("cameron@gmail");
        camUser.setAdmin(false);
        camUser.setFirstName("Cameron");
        camUser.setLastName("Chaboki");
        camUser.setUsername("WhoaBlackBettyCamaLam");
        camUser.setStatId("3");
        userService.saveUser(camUser);


        User justinUser = new User();
        camUser.setId("u4");
        camUser.setEmail("justin@gmail");
        camUser.setAdmin(false);
        camUser.setFirstName("Justin");
        camUser.setLastName("Clem");
        camUser.setUsername("ChallengerOnMyOtherAccount");
        camUser.setStatId("3");
        userService.saveUser(justinUser);

    }

}
