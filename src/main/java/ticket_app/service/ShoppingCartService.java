package ticket_app.service;

import ticket_app.model.MovieSession;
import ticket_app.model.ShoppingCart;
import ticket_app.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
