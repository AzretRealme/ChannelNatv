package kg.megacom.ChannelGo.mappers;

import kg.megacom.ChannelGo.models.dtos.DiscountDto;
import kg.megacom.ChannelGo.models.entities.Discount;

import java.util.List;

public interface DiscountMapperByHand {

    Discount toEntity(DiscountDto dto);
    DiscountDto toDto(Discount entities);


    List<Discount> toEntities(List<DiscountDto> dtos);
    List<DiscountDto> toDtos(List<Discount> entities);
}
