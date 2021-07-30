package kg.megacom.ChannelPost.models.dtos.inputOrder;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InputChannelDto {
    private Long channel_id;
    @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern="dd-MM-yyyy")
    private List<Date> days;
}
