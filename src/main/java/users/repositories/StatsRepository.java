package users.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import users.domain.Stats;

public interface StatsRepository extends MongoRepository <Stats, String> {
}
