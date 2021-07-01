package tickets.util;

import java.time.LocalDateTime;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import tickets.model.Game;
import tickets.model.GameSession;
import tickets.model.Role;
import tickets.model.Stadium;
import tickets.model.User;
import tickets.service.AuthenticationService;
import tickets.service.GameService;
import tickets.service.GameSessionService;
import tickets.service.RoleService;
import tickets.service.StadiumService;
import tickets.service.UserService;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;
    private final GameService gameService;
    private final StadiumService stadiumService;
    private final GameSessionService gameSessionService;
    private final AuthenticationService authenticationService;

    public DataInitializer(RoleService roleService,
                           UserService userService,
                           GameService gameService,
                           StadiumService stadiumService,
                           GameSessionService gameSessionService,
                           AuthenticationService authenticationService) {
        this.roleService = roleService;
        this.userService = userService;
        this.gameService = gameService;
        this.stadiumService = stadiumService;
        this.gameSessionService = gameSessionService;
        this.authenticationService = authenticationService;
    }

    @PostConstruct
    public void inject() {
        roleService.add(new Role(Role.RoleName.ROLE_ADMIN));
        roleService.add(new Role(Role.RoleName.ROLE_USER));

        User alice = new User();
        alice.setEmail("alice@gmail.com");
        alice.setPassword("4321");
        alice.setRoles(Set.of(roleService.getRoleByName(Role.RoleName.ROLE_ADMIN)));
        userService.add(alice);

        User bob = new User();
        bob.setEmail("bob@gmail.com");
        bob.setPassword("1234");
        bob.setRoles(Set.of(roleService.getRoleByName(Role.RoleName.ROLE_USER)));
        userService.add(bob);

        Game ukraineVsSweden = new Game();
        ukraineVsSweden.setTitle("Ukraine vs Sweden");
        ukraineVsSweden.setDescription("Will Ukraine get to 1/4 final first in history?");
        gameService.add(ukraineVsSweden);

        Game euroFinal = new Game();
        euroFinal.setTitle("Euro 2020 final game");
        euroFinal.setDescription("WWho will be the winner?");
        gameService.add(euroFinal);

        Stadium hampdenPark = new Stadium();
        hampdenPark.setCapacity(50000);
        hampdenPark.setDescription("Great stadium");
        Stadium wembleyStadium = new Stadium();
        wembleyStadium.setCapacity(90000);
        wembleyStadium.setDescription("Wembley Stadium");
        stadiumService.add(hampdenPark);
        stadiumService.add(wembleyStadium);

        GameSession tomorrowGameSession = new GameSession();
        tomorrowGameSession.setStadium(wembleyStadium);
        tomorrowGameSession.setGame(euroFinal);
        tomorrowGameSession.setShowTime(LocalDateTime.now().plusDays(1L));
        GameSession yesterdayGameSession = new GameSession();
        yesterdayGameSession.setStadium(hampdenPark);
        yesterdayGameSession.setGame(ukraineVsSweden);
        yesterdayGameSession.setShowTime(LocalDateTime.now().minusDays(1L));

        gameSessionService.add(tomorrowGameSession);
        gameSessionService.add(yesterdayGameSession);
    }
}
