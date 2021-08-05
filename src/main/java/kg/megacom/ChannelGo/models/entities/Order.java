package kg.megacom.ChannelGo.models.entities;

import kg.megacom.ChannelGo.models.enums.Status;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private String name;
    private String phone;
    private String email;
    private double totalPrice;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;
    @Enumerated(EnumType.STRING)
    private Status status;
}
