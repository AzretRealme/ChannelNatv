package kg.megacom.ChannelGo.services.impl;

import kg.megacom.ChannelGo.dao.DiscountRepo;
import kg.megacom.ChannelGo.mappers.DiscountMapperByHand;
import kg.megacom.ChannelGo.models.dtos.DiscountDto;
import kg.megacom.ChannelGo.models.dtos.inputForChannel.InputDiscountDto;
import kg.megacom.ChannelGo.services.ChannelService;
import kg.megacom.ChannelGo.services.DiscountService;
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
