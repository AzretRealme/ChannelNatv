package kg.megacom.ChannelPost.mappers.impl;

import kg.megacom.ChannelPost.mappers.ChannelMapperByHand;
import kg.megacom.ChannelPost.mappers.PriceMapperByHand;
import kg.megacom.ChannelPost.models.dtos.PriceDto;
import kg.megacom.ChannelPost.models.entities.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceMapperByHandImpl implements PriceMapperByHand {
    @Autowired
    private ChannelMapperByHand channelMapperByHand;

    @Override
    public Price toEntity(PriceDto priceDto) {
        Price price = new Price();
        price.setPrice(priceDto.getPrice());
        price.setChannel(channelMapperByHand.toEntity(priceDto.getChannelDto()));
        price.setStartDate(priceDto.getStartDate());
        price.setEndDate(priceDto.getEndDate());
        price.setId(priceDto.getId());
        return price;
    }

    @Override
    public PriceDto toDto(Price price) {
        PriceDto priceDto = new PriceDto();
        priceDto.setPrice(price.getPrice());
        priceDto.setChannelDto(channelMapperByHand.toDto(price.getChannel()));
        priceDto.setStartDate(price.getStartDate());
        priceDto.setEndDate(price.getEndDate());
        priceDto.setId(price.getId());
        return priceDto;
    }

    @Override
    public List<Price> toEntities(List<PriceDto> priceDtos) {

        return priceDtos.stream().map(x -> {
            Price price = new Price();
            price.setPrice(x.getPrice());
            price.setChannel(channelMapperByHand.toEntity(x.getChannelDto()));
            price.setStartDate(x.getStartDate());
            price.setEndDate(x.getEndDate());
            price.setId(x.getId());
            return price;
        }).collect(Collectors.toList());
    }

    @Override
    public List<PriceDto> toDtos(List<Price> prices) {

        return prices.stream().map(x -> {
            PriceDto priceDto = new PriceDto();
            priceDto.setPrice(x.getPrice());
            priceDto.setChannelDto(channelMapperByHand.toDto(x.getChannel()));
            priceDto.setStartDate(x.getStartDate());
            priceDto.setEndDate(x.getEndDate());
            priceDto.setId(x.getId());
            return priceDto;
        }).collect(Collectors.toList());
    }
}
