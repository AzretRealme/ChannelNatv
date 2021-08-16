package kg.megacom.ChannelGo.mappers;

import kg.megacom.ChannelGo.models.dtos.PriceDto;
import kg.megacom.ChannelGo.models.entities.Price;

import java.util.List;

public interface PriceMapperByHand {

    Price toEntity(PriceDto priceDto);
    PriceDto toDto(Price price);


    List<Price> toEntities(List<PriceDto> priceDtos);
    List<PriceDto> toDtos(List<Price> prices);
}
