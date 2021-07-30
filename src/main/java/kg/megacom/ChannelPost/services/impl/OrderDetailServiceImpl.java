package kg.megacom.ChannelPost.services.impl;

import kg.megacom.ChannelPost.dao.OrderDetailRepo;
import kg.megacom.ChannelPost.mappers.OrderDetailMapper;
import kg.megacom.ChannelPost.models.dtos.OrderDetailDto;
import kg.megacom.ChannelPost.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDetailDto save(OrderDetailDto orderDetailDto) {
        return orderDetailMapper.toDto(orderDetailRepo.save(orderDetailMapper.toEntity(orderDetailDto)));
    }

    @Override
    public OrderDetailDto findByChannelId(Long id) {
        return orderDetailMapper.toDto(orderDetailRepo.findDistinctByChannelId(id));
    }

    @Override
    public List<OrderDetailDto> findByOrderId(Long id) {
        return orderDetailMapper.toDtos(orderDetailRepo.findByOrderId(id));
    }
}
