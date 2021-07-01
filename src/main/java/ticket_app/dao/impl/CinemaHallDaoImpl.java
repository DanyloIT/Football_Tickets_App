package ticket_app.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ticket_app.dao.AbstractDao;
import ticket_app.dao.CinemaHallDao;
import ticket_app.model.CinemaHall;

@Repository
public class CinemaHallDaoImpl extends AbstractDao<CinemaHall> implements CinemaHallDao {
    public CinemaHallDaoImpl(SessionFactory factory) {
        super(factory, CinemaHall.class);
    }
}
