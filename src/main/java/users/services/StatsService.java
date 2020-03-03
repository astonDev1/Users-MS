package users.services;


import org.springframework.stereotype.Service;
import users.domain.Stats;
import users.domain.User;

import java.util.List;

@Service
public interface StatsService {

    Iterable<Stats> findAllStats();
    Stats findStatsById(String id);
    Stats saveStats(Stats stats);
    Iterable<Stats> saveAllStats(List<Stats> stats);
    void deleteStats(String id);

}
