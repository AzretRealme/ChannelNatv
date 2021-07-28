package kg.megacom.ChannelPost.mappers;

import kg.megacom.ChannelPost.models.dtos.PriceDto;
import kg.megacom.ChannelPost.models.entities.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    Price toEntity(PriceDto priceDto);
    PriceDto toDto(Price price);


    List<Price> toEntities(List<PriceDto> priceDtos);
    List<PriceDto> toDtos(List<Price> prices);
}
