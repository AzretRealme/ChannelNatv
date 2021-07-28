package kg.megacom.ChannelPost.services.impl;

import kg.megacom.ChannelPost.dao.PriceRepo;
import kg.megacom.ChannelPost.mappers.PriceMapper;
import kg.megacom.ChannelPost.models.dtos.PriceDto;
import kg.megacom.ChannelPost.models.dtos.inputForChannel.InputPriceDto;
import kg.megacom.ChannelPost.services.ChannelService;
import kg.megacom.ChannelPost.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepo priceRepo;

    @Autowired
    private ChannelService channelService;

    @Override
    public PriceDto findByChannelId(Long id) {
        return PriceMapper.INSTANCE.toDto(priceRepo.findByChannelId(id));
    }

    @Override
    public List<PriceDto> findAllCurrentlyActivePrices() {
        return PriceMapper.INSTANCE.toDtos(priceRepo.findAllCurrentlyActivePrices());
    }

    @Override
    public PriceDto savePriceForChannel(InputPriceDto inputPriceDto) {
        PriceDto priceDto = new PriceDto();
        priceDto.setChannelDto(channelService.findById(inputPriceDto.getChannelId()));
        priceDto.setPrice(inputPriceDto.getPrice());
        priceDto.setStartDate(inputPriceDto.getStartDate());
        priceDto.setEndDate(inputPriceDto.getEndDate());
        return PriceMapper.INSTANCE.toDto(priceRepo.save(PriceMapper.INSTANCE.toEntity(priceDto)));
    }
}
