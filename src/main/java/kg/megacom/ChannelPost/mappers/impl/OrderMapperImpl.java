package kg.megacom.ChannelPost.mappers.impl;

import kg.megacom.ChannelPost.mappers.OrderMapper;
import kg.megacom.ChannelPost.models.dtos.OrderDto;
import kg.megacom.ChannelPost.models.entities.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order toEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setStatus(orderDto.getStatus());
        order.setPhone(orderDto.getPhone());
        order.setText(orderDto.getText());
        order.setEmail(orderDto.getEmail());
        order.setName(orderDto.getName());
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setId(orderDto.getId());
        order.setAddDate(orderDto.getAddDate());
        order.setEditDate(orderDto.getEditDate());
        return order;
    }

    @Override
    public OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setStatus(order.getStatus());
        orderDto.setPhone(order.getPhone());
        orderDto.setText(order.getText());
        orderDto.setEmail(order.getEmail());
        orderDto.setName(order.getName());
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setId(order.getId());
        orderDto.setAddDate(order.getAddDate());
        orderDto.setEditDate(order.getEditDate());
        return orderDto;
    }

    @Override
    public List<Order> toEntities(List<OrderDto> orderDtos) {

        return orderDtos.stream().map(x->{
            Order order = new Order();
            order.setStatus(x.getStatus());
            order.setPhone(x.getPhone());
            order.setText(x.getText());
            order.setEmail(x.getEmail());
            order.setName(x.getName());
            order.setTotalPrice(x.getTotalPrice());
            order.setId(x.getId());
            order.setAddDate(x.getAddDate());
            order.setEditDate(x.getEditDate());
            return order;
        }).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> toDtos(List<Order> orders) {

        return orders.stream().map(x->{
            OrderDto orderDto = new OrderDto();
            orderDto.setStatus(x.getStatus());
            orderDto.setPhone(x.getPhone());
            orderDto.setText(x.getText());
            orderDto.setEmail(x.getEmail());
            orderDto.setName(x.getName());
            orderDto.setTotalPrice(x.getTotalPrice());
            orderDto.setId(x.getId());
            orderDto.setAddDate(x.getAddDate());
            orderDto.setEditDate(x.getEditDate());
            return orderDto;
        }).collect(Collectors.toList());
    }
}
