package tickets.service;

import java.util.List;
import tickets.model.Game;

public interface GameService {
    Game add(Game game);

    Game get(Long id);

    List<Game> getAll();
}
