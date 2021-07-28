package kg.megacom.ChannelPost.mappers;

import kg.megacom.ChannelPost.models.dtos.DiscountDto;
import kg.megacom.ChannelPost.models.entities.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DiscountMapper {
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    Discount toEntity(DiscountDto dto);
    DiscountDto toDto(Discount entities);


    List<Discount> toEntities(List<DiscountDto> dtos);
    List<DiscountDto> toDtos(List<Discount> entities);
}
