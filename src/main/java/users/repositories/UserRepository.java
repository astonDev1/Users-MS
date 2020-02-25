package users.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import users.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
}
