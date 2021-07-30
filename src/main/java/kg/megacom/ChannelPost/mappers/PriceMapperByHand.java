package kg.megacom.ChannelPost.mappers;

import kg.megacom.ChannelPost.models.dtos.PriceDto;
import kg.megacom.ChannelPost.models.entities.Price;

import java.util.List;

public interface PriceMapperByHand {

    Price toEntity(PriceDto priceDto);
    PriceDto toDto(Price price);


    List<Price> toEntities(List<PriceDto> priceDtos);
    List<PriceDto> toDtos(List<Price> prices);
}
