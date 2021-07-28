package kg.megacom.ChannelPost.models.dtos;

import kg.megacom.ChannelPost.models.entities.Channel;
import lombok.Data;

@Data
public class OrderDetailDto {
    private Long id;
    private ChannelDto channelDto;
    private OrderDto orderDto;
    private double price;
}
