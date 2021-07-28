package kg.megacom.ChannelPost.models.dtos.inputOrder;

import lombok.Data;

import java.util.List;

@Data
public class InputOrderDto {
    private String text;
    private String name;
    private String phone;
    private String email;
    private List<InputChannelDto> channels;
}