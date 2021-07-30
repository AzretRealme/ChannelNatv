package kg.megacom.ChannelPost.mappers.impl;

import kg.megacom.ChannelPost.mappers.ChannelMapperByHand;
import kg.megacom.ChannelPost.mappers.OrderDetailMapper;
import kg.megacom.ChannelPost.mappers.OrderMapper;
import kg.megacom.ChannelPost.models.dtos.OrderDetailDto;
import kg.megacom.ChannelPost.models.entities.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailMapperImpl implements OrderDetailMapper {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ChannelMapperByHand channelMapperByHand;
    @Override
    public OrderDetail toEntity(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(orderMapper.toEntity(orderDetailDto.getOrderDto()));
        orderDetail.setId(orderDetailDto.getId());
        orderDetail.setPrice(orderDetailDto.getPrice());
        orderDetail.setChannel(channelMapperByHand.toEntity(orderDetailDto.getChannelDto()));
        return orderDetail;
    }

    @Override
    public OrderDetailDto toDto(OrderDetail orderDetail) {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setOrderDto(orderMapper.toDto(orderDetail.getOrder()));
        orderDetailDto.setId(orderDetail.getId());
        orderDetailDto.setPrice(orderDetail.getPrice());
        orderDetailDto.setChannelDto(channelMapperByHand.toDto(orderDetail.getChannel()));
        return orderDetailDto;
    }

    @Override
    public List<OrderDetail> toEntities(List<OrderDetailDto> orderDetailDtoList) {

        return orderDetailDtoList.stream().map(x -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(orderMapper.toEntity(x.getOrderDto()));
            orderDetail.setId(x.getId());
            orderDetail.setPrice(x.getPrice());
            orderDetail.setChannel(channelMapperByHand.toEntity(x.getChannelDto()));
            return orderDetail;
        }).collect(Collectors.toList());
    }

    @Override
    public List<OrderDetailDto> toDtos(List<OrderDetail> orderDetailList) {

        return orderDetailList.stream().map(x->{
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            orderDetailDto.setOrderDto(orderMapper.toDto(x.getOrder()));
            orderDetailDto.setId(x.getId());
            orderDetailDto.setPrice(x.getPrice());
            orderDetailDto.setChannelDto(channelMapperByHand.toDto(x.getChannel()));
            return orderDetailDto;
        }).collect(Collectors.toList());
    }
}
