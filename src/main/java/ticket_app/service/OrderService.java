package ticket_app.service;

import ticket_app.model.Order;
import ticket_app.model.ShoppingCart;
import ticket_app.model.User;

import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
