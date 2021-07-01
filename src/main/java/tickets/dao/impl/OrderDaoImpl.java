package tickets.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import tickets.dao.AbstractDao;
import tickets.dao.OrderDao;
import tickets.exception.DataProcessingException;
import tickets.model.Order;
import tickets.model.User;

@Repository
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    public OrderDaoImpl(SessionFactory factory) {
        super(factory, Order.class);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = factory.openSession()) {
            Query<Order> getByUser = session.createQuery(
                    "SELECT DISTINCT o FROM orders o "
                            + "join fetch o.tickets t "
                            + "left join fetch t.gameSession ms "
                            + "left join fetch ms.stadium "
                            + "left join fetch ms.game "
                            + "WHERE o.user = :user", Order.class);
            getByUser.setParameter("user", user);
            return getByUser.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find shopping cart for user " + user, e);
        }
    }
}
