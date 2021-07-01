package tickets.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import tickets.dao.AbstractDao;
import tickets.dao.StadiumDao;
import tickets.model.Stadium;

@Repository
public class StadiumDaoImpl extends AbstractDao<Stadium> implements StadiumDao {
    public StadiumDaoImpl(SessionFactory factory) {
        super(factory, Stadium.class);
    }
}
