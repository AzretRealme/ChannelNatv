package kg.megacom.ChannelGo.services.impl;

import kg.megacom.ChannelGo.dao.PriceRepo;
import kg.megacom.ChannelGo.mappers.PriceMapperByHand;
import kg.megacom.ChannelGo.models.dtos.PriceDto;
import kg.megacom.ChannelGo.models.dtos.inputForChannel.InputPriceDto;
import kg.megacom.ChannelGo.services.ChannelService;
import kg.megacom.ChannelGo.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepo priceRepo;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private PriceMapperByHand priceMapperByHand;

    @Override
    public PriceDto findByChannelId(Long id) {
        return priceMapperByHand.toDto(priceRepo.findByChannelId(id));
    }

    @Override
    public List<PriceDto> findAllCurrentlyActivePrices() {
        return priceMapperByHand.toDtos(priceRepo.findAllCurrentlyActivePrices());
    }

    @Override
    public PriceDto savePriceForChannel(InputPriceDto inputPriceDto) {
        PriceDto priceDto = new PriceDto();
        priceDto.setChannelDto(channelService.findById(inputPriceDto.getChannelId()));
        priceDto.setPrice(inputPriceDto.getPrice());
        priceDto.setStartDate(inputPriceDto.getStartDate());
        priceDto.setEndDate(inputPriceDto.getEndDate());
        return priceMapperByHand.toDto(priceRepo.save(priceMapperByHand.toEntity(priceDto)));
    }

    @Override
    public List<PriceDto> findAll() {
        return priceMapperByHand.toDtos(priceRepo.findAll());
    }


}
