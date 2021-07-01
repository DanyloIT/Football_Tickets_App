package tickets.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import tickets.dao.GameDao;
import tickets.exception.DataProcessingException;
import tickets.model.Game;
import tickets.service.GameService;

@Service
public class GameServiceImpl implements GameService {
    private final GameDao gameDao;

    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public Game add(Game game) {
        return gameDao.add(game);
    }

    @Override
    public Game get(Long id) {
        return gameDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get game with id = " + id));
    }

    @Override
    public List<Game> getAll() {
        return gameDao.getAll();
    }
}
