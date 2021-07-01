package tickets.service;

import tickets.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
