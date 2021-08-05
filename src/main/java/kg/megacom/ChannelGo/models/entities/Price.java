package kg.megacom.ChannelGo.models.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_channels")
    private Channel channel;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    private double price;
}
