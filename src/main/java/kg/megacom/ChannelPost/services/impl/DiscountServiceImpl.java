package kg.megacom.ChannelPost.services.impl;

import kg.megacom.ChannelPost.dao.DiscountRepo;
import kg.megacom.ChannelPost.mappers.DiscountMapper;
import kg.megacom.ChannelPost.mappers.DiscountMapperByHand;
import kg.megacom.ChannelPost.models.dtos.DiscountDto;
import kg.megacom.ChannelPost.models.dtos.inputForChannel.InputDiscountDto;
import kg.megacom.ChannelPost.services.ChannelService;
import kg.megacom.ChannelPost.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountRepo discountRepo;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private DiscountMapperByHand discountMapperByHand;
    @Override
    public List<DiscountDto> findAllCurrentlyActiveDiscounts(Long id) {
        return discountMapperByHand.toDtos(discountRepo.allCurrentlyActiveDiscounts(id));
    }

    @Override
    public List<DiscountDto> findByChannelId(Long id) {
        return discountMapperByHand.toDtos(discountRepo.findByChannelId(id));
    }

    @Override
    public DiscountDto saveDiscount(InputDiscountDto inputDiscountDto) {
        DiscountDto discountDto = new DiscountDto();
        discountDto.setChannelDto(channelService.findById(inputDiscountDto.getChannelId()));
        System.out.println(discountDto.getChannelDto());
        discountDto.setEndDate(inputDiscountDto.getEndDate());
        discountDto.setStartDate(inputDiscountDto.getStartDate());
        discountDto.setMinDays(inputDiscountDto.getMinDay());
        discountDto.setPercent(inputDiscountDto.getPercent());
        return discountMapperByHand.toDto(discountRepo.save(discountMapperByHand.toEntity(discountDto)));
    }
}
