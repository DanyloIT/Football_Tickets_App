package tickets.dao;

import java.util.List;
import tickets.model.Order;
import tickets.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
