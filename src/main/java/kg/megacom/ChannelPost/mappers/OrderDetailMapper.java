package kg.megacom.ChannelPost.mappers;

import kg.megacom.ChannelPost.models.dtos.OrderDetailDto;
import kg.megacom.ChannelPost.models.dtos.OrderDto;
import kg.megacom.ChannelPost.models.entities.Order;
import kg.megacom.ChannelPost.models.entities.OrderDetail;

import java.util.List;

public interface OrderDetailMapper {

    OrderDetail toEntity(OrderDetailDto orderDetailDto);
    OrderDetailDto toDto(OrderDetail orderDetail);


    List<OrderDetail> toEntities(List<OrderDetailDto> orderDetailDtoList);
    List<OrderDetailDto> toDtos(List<OrderDetail> orderDetailList);
}
