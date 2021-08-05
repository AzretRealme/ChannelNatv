package kg.megacom.ChannelGo.mappers;

import kg.megacom.ChannelGo.models.dtos.OrderDetailDto;
import kg.megacom.ChannelGo.models.entities.OrderDetail;

import java.util.List;

public interface OrderDetailMapper {

    OrderDetail toEntity(OrderDetailDto orderDetailDto);
    OrderDetailDto toDto(OrderDetail orderDetail);


    List<OrderDetail> toEntities(List<OrderDetailDto> orderDetailDtoList);
    List<OrderDetailDto> toDtos(List<OrderDetail> orderDetailList);
}
