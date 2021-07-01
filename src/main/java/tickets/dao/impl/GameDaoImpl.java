package tickets.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import tickets.dao.AbstractDao;
import tickets.dao.GameDao;
import tickets.model.Game;

@Repository
public class GameDaoImpl extends AbstractDao<Game> implements GameDao {
    public GameDaoImpl(SessionFactory factory) {
        super(factory, Game.class);
    }
}
