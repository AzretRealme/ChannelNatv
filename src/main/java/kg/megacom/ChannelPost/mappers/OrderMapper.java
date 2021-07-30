package kg.megacom.ChannelPost.mappers;

import kg.megacom.ChannelPost.models.dtos.ChannelDto;
import kg.megacom.ChannelPost.models.dtos.OrderDto;
import kg.megacom.ChannelPost.models.entities.Channel;
import kg.megacom.ChannelPost.models.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface OrderMapper {

    Order toEntity(OrderDto orderDto);
    OrderDto toDto(Order order);


    List<Order> toEntities(List<OrderDto> orderDtos);
    List<OrderDto> toDtos(List<Order> orders);
}
