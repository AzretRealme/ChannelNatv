package kg.megacom.ChannelPost.models.entities;

import jdk.jfr.Enabled;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_channels")
    private Channel channel;
    private int percent;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    private int minDays;
}
