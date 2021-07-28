package kg.megacom.ChannelPost.models.dtos;

import kg.megacom.ChannelPost.models.dtos.channelsOutput.OutputChannelDto;
import lombok.Data;

import java.util.Date;

@Data
public class DiscountDto {
    private Long id;
    private ChannelDto channelDto;
    private int percent;
    private Date startDate;
    private Date endDate;
    private int minDays;
}
