package ticket_app.service.mapper;

import org.springframework.stereotype.Component;
import ticket_app.dto.response.ShoppingCartResponseDto;
import ticket_app.model.ShoppingCart;
import ticket_app.model.Ticket;

import java.util.stream.Collectors;

@Component
public class ShoppingCartMapper implements
        ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setTicketIds(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
