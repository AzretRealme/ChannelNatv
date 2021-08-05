package kg.megacom.ChannelGo.models.dtos.outputOrder;

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