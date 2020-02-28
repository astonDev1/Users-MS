package users.services;


import users.domain.Stats;

import java.util.List;

public interface StatsService {

    Iterable<Stats> findAllStats();
    Stats findStatsById(String id);
    Stats saveStats(Stats stats);
    Iterable<Stats> saveAllStats(List<Stats> stats);
    void deleteStats(String id);

}
