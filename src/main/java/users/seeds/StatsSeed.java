package users.seeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import users.domain.Stats;
import users.services.StatsService;

@Component
public class StatsSeed implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private StatsService statsService;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        mongoTemplate.getDb().drop();
        seedStatsTable();
    };


    public void seedStatsTable() {

        Stats tuckStats = new Stats();
        tuckStats.setGamesPlayed(10);
        tuckStats.setLosses(5);
        tuckStats.setWins(5);
        statsService.saveStats(tuckStats);

        Stats ericStats = new Stats();
        ericStats.setGamesPlayed(5);
        ericStats.setLosses(1);
        ericStats.setWins(4);
        statsService.saveStats(ericStats);
    }

}
