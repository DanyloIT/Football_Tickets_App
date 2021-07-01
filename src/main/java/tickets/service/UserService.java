package tickets.service;

import tickets.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    User findByEmail(String email);
}
