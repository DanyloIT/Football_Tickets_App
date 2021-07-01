package tickets.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import tickets.dao.AbstractDao;
import tickets.dao.TicketDao;
import tickets.model.Ticket;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
