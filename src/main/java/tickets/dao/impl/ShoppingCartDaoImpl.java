package tickets.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import tickets.dao.AbstractDao;
import tickets.dao.ShoppingCartDao;
import tickets.exception.DataProcessingException;
import tickets.model.ShoppingCart;
import tickets.model.User;

@Repository
public class ShoppingCartDaoImpl extends AbstractDao<ShoppingCart> implements ShoppingCartDao {
    public ShoppingCartDaoImpl(SessionFactory factory) {
        super(factory, ShoppingCart.class);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = factory.openSession()) {
            Query<ShoppingCart> getByUser = session.createQuery(
                    "SELECT DISTINCT sc FROM ShoppingCart sc "
                            + "left join fetch sc.tickets t "
                            + "left join fetch t.gameSession ms "
                            + "left join fetch ms.stadium "
                            + "left join fetch ms.game "
                            + "WHERE sc.user = :user", ShoppingCart.class);
            getByUser.setParameter("user", user);
            return getByUser.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find shopping cart for user " + user, e);
        }
    }
}
