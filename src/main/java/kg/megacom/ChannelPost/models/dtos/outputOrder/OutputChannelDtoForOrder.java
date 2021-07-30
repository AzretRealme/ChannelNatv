package kg.megacom.ChannelPost.models.dtos.outputOrder;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OutputChannelDtoForOrder {
    private Long channel_id;
    private double price;
    @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern="dd-MM-yyyy")
    private List<Date> days;
}
