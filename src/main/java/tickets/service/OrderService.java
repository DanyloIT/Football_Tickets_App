package tickets.service;

import java.util.List;
import tickets.model.Order;
import tickets.model.ShoppingCart;
import tickets.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
