package kg.megacom.ChannelPost.models.dtos.outputOrder;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OutputChannelDtoForOrder {
    private Long channel_id;
    private double price;
    private List<Date> days;
}
