package kg.megacom.ChannelGo.models.dtos.channelsOutput;

import lombok.Data;

import java.util.List;

@Data
public class OutputChannelDto {
    private Long id;
    private String name;
    private String photo;
    private double price;
    private List<OutputDiscountDto> outputDiscountDtoList;
}
