package kg.megacom.ChannelPost.mappers;

import kg.megacom.ChannelPost.models.dtos.DiscountDto;
import kg.megacom.ChannelPost.models.entities.Discount;

import java.util.List;

public interface DiscountMapperByHand {

    Discount toEntity(DiscountDto dto);
    DiscountDto toDto(Discount entities);


    List<Discount> toEntities(List<DiscountDto> dtos);
    List<DiscountDto> toDtos(List<Discount> entities);
}
