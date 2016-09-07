package kolchiba.springservice.repositories;

import kolchiba.springservice.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
