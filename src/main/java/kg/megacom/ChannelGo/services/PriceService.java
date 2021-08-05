package kg.megacom.ChannelGo.services;

import kg.megacom.ChannelGo.models.dtos.PriceDto;
import kg.megacom.ChannelGo.models.dtos.inputForChannel.InputPriceDto;

import java.util.List;

public interface PriceService {
    PriceDto findByChannelId(Long id);
    List<PriceDto> findAllCurrentlyActivePrices();
    PriceDto savePriceForChannel(InputPriceDto inputPriceDto);
    List<PriceDto> findAll();
}
