package tickets.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers(HttpMethod.GET, "/games", "/stadiums",
                        "/game-sessions/available").permitAll()
                .antMatchers(HttpMethod.GET,
                        "/shopping-carts/by-user/*",
                        "/orders/*").hasRole("USER")
                .antMatchers(HttpMethod.POST,
                        "/shopping-carts/game-sessions/*",
                        "/orders/complete/*").hasRole("USER")
                .antMatchers(HttpMethod.GET,
                        "/users/by-email").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,
                        "/games/*",
                        "/game-sessions/*",
                        "/stadiums/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/game-sessions")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/game-sessions")
                .hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
