package kg.megacom.ChannelGo.models.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class DayDto {
    private Long id;
    private OrderDetailDto orderDetailDto;
    private Date day;
}
