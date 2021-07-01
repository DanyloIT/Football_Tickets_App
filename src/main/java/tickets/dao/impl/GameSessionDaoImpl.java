package tickets.dao.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import tickets.dao.AbstractDao;
import tickets.dao.GameSessionDao;
import tickets.exception.DataProcessingException;
import tickets.model.GameSession;

@Repository
public class GameSessionDaoImpl extends AbstractDao<GameSession> implements GameSessionDao {
    public GameSessionDaoImpl(SessionFactory factory) {
        super(factory, GameSession.class);
    }

    @Override
    public List<GameSession> findAvailableSessions(Long gameId, LocalDate date) {
        try (Session session = factory.openSession()) {
            Query<GameSession> getAvailableSessions = session.createQuery(
                    "FROM GameSession WHERE id = :id "
                            + "AND DATE(showTime) = :date", GameSession.class);
            getAvailableSessions.setParameter("id", gameId);
            Date sqlDate = Date.valueOf(date);
            getAvailableSessions.setParameter("date", sqlDate);
            return getAvailableSessions.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Session for game with id = "
                    + gameId + " and show date " + date + " not found", e);
        }
    }
}
