package kg.megacom.ChannelPost.models.entities;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_channels")
    private Channel channel;
    @ManyToOne
    @JoinColumn(name = "id_orders")
    private Order order;
    private double price;
}
