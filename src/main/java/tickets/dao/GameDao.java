package tickets.dao;

import java.util.List;
import java.util.Optional;
import tickets.model.Game;

public interface GameDao {
    Game add(Game game);

    Optional<Game> get(Long id);

    List<Game> getAll();
}
