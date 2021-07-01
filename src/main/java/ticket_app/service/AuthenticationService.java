package ticket_app.service;

import ticket_app.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
