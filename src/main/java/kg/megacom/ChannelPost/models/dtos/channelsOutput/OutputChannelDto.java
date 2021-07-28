package kg.megacom.ChannelPost.models.dtos.channelsOutput;

import kg.megacom.ChannelPost.models.dtos.DiscountDto;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class OutputChannelDto {
    private Long id;
    private String name;
    private String photo;
    private double price;
    private List<OutputDiscountDto> outputDiscountDtoList;
}
