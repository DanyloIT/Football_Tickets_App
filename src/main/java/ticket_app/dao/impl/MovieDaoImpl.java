package ticket_app.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ticket_app.dao.AbstractDao;
import ticket_app.dao.MovieDao;
import ticket_app.model.Movie;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    public MovieDaoImpl(SessionFactory factory) {
        super(factory, Movie.class);
    }
}
