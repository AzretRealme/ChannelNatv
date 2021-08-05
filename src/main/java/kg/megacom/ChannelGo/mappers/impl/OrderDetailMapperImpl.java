package kg.megacom.ChannelGo.mappers.impl;

import kg.megacom.ChannelGo.mappers.ChannelMapper;
import kg.megacom.ChannelGo.mappers.OrderDetailMapper;
import kg.megacom.ChannelGo.mappers.OrderMapper;
import kg.megacom.ChannelGo.models.dtos.OrderDetailDto;
import kg.megacom.ChannelGo.models.entities.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailMapperImpl implements OrderDetailMapper {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ChannelMapper channelMapperByHand;
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
