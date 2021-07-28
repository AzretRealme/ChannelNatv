package kg.megacom.ChannelPost.models.dtos;

import lombok.Data;

@Data
public class ChannelDto {
    private Long id;
    private String name;
    private String photo;
    private boolean active;
    private int orderNum;

    @Override
    public String toString() {
        return "ChannelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", active=" + active +
                ", orderNum=" + orderNum +
                '}';
    }
}
