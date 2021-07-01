package tickets.service;

import tickets.model.GameSession;
import tickets.model.ShoppingCart;
import tickets.model.User;

public interface ShoppingCartService {
    void addSession(GameSession gameSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
