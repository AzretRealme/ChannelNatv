package kg.megacom.ChannelPost.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;
    private boolean active;
    private int orderNum;
}
