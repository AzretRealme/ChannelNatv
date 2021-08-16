package kg.megacom.ChannelGo.mappers.impl;

import kg.megacom.ChannelGo.mappers.ChannelMapperByHand;
import kg.megacom.ChannelGo.mappers.DiscountMapperByHand;
import kg.megacom.ChannelGo.models.dtos.DiscountDto;
import kg.megacom.ChannelGo.models.entities.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountMapperByHandImpl implements DiscountMapperByHand {
    @Autowired
    private ChannelMapperByHand channelMapperByHand;
    @Override
    public Discount toEntity(DiscountDto dto) {
        Discount discount = new Discount();
        discount.setChannel(channelMapperByHand.toEntity(dto.getChannelDto()));
        discount.setId(dto.getId());
        discount.setMinDays(dto.getMinDays());
        discount.setStartDate(dto.getStartDate());
        discount.setEndDate(dto.getEndDate());
        discount.setPercent(dto.getPercent());
        return discount;
    }

    @Override
    public DiscountDto toDto(Discount entity) {
        DiscountDto discountDto = new DiscountDto();
        discountDto.setChannelDto(channelMapperByHand.toDto(entity.getChannel()));
        discountDto.setId(entity.getId());
        discountDto.setMinDays(entity.getMinDays());
        discountDto.setStartDate(entity.getStartDate());
        discountDto.setEndDate(entity.getEndDate());
        discountDto.setPercent(entity.getPercent());
        return discountDto;
    }

    @Override
    public List<Discount> toEntities(List<DiscountDto> dtos) {

        return dtos.stream().map(x->{
            Discount discount = new Discount();
            discount.setChannel(channelMapperByHand.toEntity(x.getChannelDto()));
            discount.setId(x.getId());
            discount.setMinDays(x.getMinDays());
            discount.setStartDate(x.getStartDate());
            discount.setEndDate(x.getEndDate());
            discount.setPercent(x.getPercent());
            return discount;
        }).collect(Collectors.toList());
    }

    @Override
    public List<DiscountDto> toDtos(List<Discount> entities) {

        return entities.stream().map(x->{
            DiscountDto discountDto = new DiscountDto();
            discountDto.setChannelDto(channelMapperByHand.toDto(x.getChannel()));
            discountDto.setId(x.getId());
            discountDto.setMinDays(x.getMinDays());
            discountDto.setStartDate(x.getStartDate());
            discountDto.setEndDate(x.getEndDate());
            discountDto.setPercent(x.getPercent());
            return discountDto;
        }).collect(Collectors.toList());
    }
}
