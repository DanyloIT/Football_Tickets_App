package tickets.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tickets.dao.UserDao;
import tickets.exception.DataProcessingException;
import tickets.model.User;
import tickets.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder encoder;
    private final UserDao userDao;

    public UserServiceImpl(PasswordEncoder encoder, UserDao userDao) {
        this.encoder = encoder;
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userDao.add(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't find user with id = " + id));
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("Can't find user with email = " + email));
    }
}
