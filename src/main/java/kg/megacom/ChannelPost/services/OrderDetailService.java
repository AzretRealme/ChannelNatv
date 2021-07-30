package kg.megacom.ChannelPost.services;

import kg.megacom.ChannelPost.models.dtos.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {
    OrderDetailDto save(OrderDetailDto orderDetailDto);

    OrderDetailDto findByChannelId(Long id);

    List<OrderDetailDto> findByOrderId(Long id);
}
