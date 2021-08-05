package kg.megacom.ChannelGo.mappers;

import kg.megacom.ChannelGo.models.dtos.OrderDto;
import kg.megacom.ChannelGo.models.entities.Order;

import java.util.List;

public interface OrderMapper {

    Order toEntity(OrderDto orderDto);
    OrderDto toDto(Order order);


    List<Order> toEntities(List<OrderDto> orderDtos);
    List<OrderDto> toDtos(List<Order> orders);
}
