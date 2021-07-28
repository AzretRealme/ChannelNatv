package kg.megacom.ChannelPost.models.dtos;

import kg.megacom.ChannelPost.models.enums.Status;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
