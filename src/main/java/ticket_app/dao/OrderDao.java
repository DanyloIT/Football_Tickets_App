package ticket_app.dao;

import ticket_app.model.Order;
import ticket_app.model.User;

import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
