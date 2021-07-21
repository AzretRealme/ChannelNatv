package kg.megacom.ChannelPost.models.entities;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Enabled
@Table(name = "discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_channels")
    private Channel channel;
    private double percent;
    private Date startDate;
    private Date endDate;
    private int minDays;
}
