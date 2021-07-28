package kg.megacom.ChannelPost.services.impl;

import kg.megacom.ChannelPost.dao.DiscountRepo;
import kg.megacom.ChannelPost.mappers.DiscountMapper;
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
    @Override
    public List<DiscountDto> findAllCurrentlyActiveDiscounts(Long id) {
        return DiscountMapper.INSTANCE.toDtos(discountRepo.allCurrentlyActiveDiscounts(id));
    }

    @Override
    public List<DiscountDto> findByChannelId(Long id) {
        return DiscountMapper.INSTANCE.toDtos(discountRepo.findByChannelId(id));
    }

    @Override
    public DiscountDto saveDiscount(InputDiscountDto inputDiscountDto) {
        DiscountDto discountDto = new DiscountDto();
        discountDto.setChannelDto(channelService.findById(inputDiscountDto.getChannelId()));
        discountDto.setEndDate(inputDiscountDto.getEndDate());
        discountDto.setStartDate(inputDiscountDto.getStartDate());
        discountDto.setMinDays(inputDiscountDto.getMinDay());
        discountDto.setPercent(inputDiscountDto.getPercent());
        return DiscountMapper.INSTANCE.toDto(discountRepo.save(DiscountMapper.INSTANCE.toEntity(discountDto)));
    }
}
