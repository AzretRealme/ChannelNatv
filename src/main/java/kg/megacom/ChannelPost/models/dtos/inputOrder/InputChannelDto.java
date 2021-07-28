package kg.megacom.ChannelPost.models.dtos.inputOrder;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InputChannelDto {
    private Long channel_id;
    private List<Date> days;
}
