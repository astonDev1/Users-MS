package users.services.impl;

import org.springframework.stereotype.Service;
import users.domain.Stats;
import users.repositories.StatsRepository;
import users.services.StatsService;

import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {

    StatsRepository statsRepository;

    public StatsServiceImpl(StatsRepository statsRepository) { this.statsRepository = statsRepository; }

    @Override
    public Iterable<Stats> findAllStats() {
        return statsRepository.findAll();
    }

    @Override
    public Stats findStatsById(String id) {
        return statsRepository.findById(id).orElse(null);
    }

    @Override
    public Stats saveStats(Stats stats) {
        return statsRepository.save(stats);
    }

    @Override
    public Iterable<Stats> saveAllStats(List<Stats> stats) {
        return statsRepository.saveAll(stats);
    }

    @Override
    public void deleteStats(String id) {
        statsRepository.deleteById(id);
    }
}
