package kg.megacom.ChannelPost.models.dtos.outputOrder;

import kg.megacom.ChannelPost.models.dtos.inputOrder.InputChannelDto;
import lombok.Data;

import java.util.List;

@Data
public class OutputOrderDto {
    private String text;
    private String name;
    private String phone;
    private String email;
    private double total_price;
    private List<OutputChannelDtoForOrder> outputChannelDtoForOrderList;
}