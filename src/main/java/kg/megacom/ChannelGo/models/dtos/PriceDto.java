package kg.megacom.ChannelGo.models.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class PriceDto {
    private Long id;
    private ChannelDto channelDto;
    private Date startDate;
    private Date endDate;
    private double price;
}
