package tickets.service.impl;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tickets.exception.DataProcessingException;
import tickets.model.User;
import tickets.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user;
        try {
            user = userService.findByEmail(email);
        } catch (DataProcessingException e) {
            throw new UsernameNotFoundException("Can't find user with email = " + email, e);
        }

        UserBuilder builder
                = org.springframework.security.core.userdetails.User.withUsername(email);
        builder.password(user.getPassword());
        builder.authorities(user.getRoles().stream()
                .map(r -> r.getName().name())
                .toArray(String[]::new));
        return builder.build();
    }
}
