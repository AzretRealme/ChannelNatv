package kg.megacom.ChannelGo.services;

import kg.megacom.ChannelGo.models.dtos.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {
    OrderDetailDto save(OrderDetailDto orderDetailDto);

    OrderDetailDto findByChannelId(Long id);

    List<OrderDetailDto> findByOrderId(Long id);
}
