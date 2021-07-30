package kg.megacom.ChannelPost.models.dtos;

import kg.megacom.ChannelPost.models.entities.Channel;
import lombok.Data;

import java.util.Iterator;

@Data
public class OrderDetailDto implements Iterable {
    private Long id;
    private ChannelDto channelDto;
    private OrderDto orderDto;
    private double price;

    @Override
    public Iterator iterator() {
        return null;
    }
}
