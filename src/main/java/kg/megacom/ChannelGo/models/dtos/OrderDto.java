package kg.megacom.ChannelGo.models.dtos;

import kg.megacom.ChannelGo.models.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {
    private Long id;
    private String text;
    private String name;
    private String phone;
    private String email;
    private double totalPrice;
    private Date editDate;
    private Date addDate;
    private Status status;
}
