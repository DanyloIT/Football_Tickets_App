package tickets.dao;

import java.util.Optional;
import tickets.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}
