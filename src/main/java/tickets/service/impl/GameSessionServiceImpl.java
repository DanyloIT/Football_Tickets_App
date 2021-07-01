package tickets.service.impl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import tickets.dao.GameSessionDao;
import tickets.exception.DataProcessingException;
import tickets.model.GameSession;
import tickets.service.GameSessionService;

@Service
public class GameSessionServiceImpl implements GameSessionService {
    private final GameSessionDao gameSessionDao;

    public GameSessionServiceImpl(GameSessionDao gameSessionDao) {
        this.gameSessionDao = gameSessionDao;
    }

    @Override
    public List<GameSession> findAvailableSessions(Long gameId, LocalDate date) {
        return gameSessionDao.findAvailableSessions(gameId, date);
    }

    @Override
    public GameSession add(GameSession session) {
        return gameSessionDao.add(session);
    }

    @Override
    public GameSession get(Long id) {
        return gameSessionDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't find session with id = " + id));
    }

    @Override
    public GameSession update(GameSession gameSession) {
        return gameSessionDao.update(gameSession);
    }

    @Override
    public void delete(Long id) {
        gameSessionDao.delete(id);
    }
}
