package kg.megacom.ChannelPost.services;

import kg.megacom.ChannelPost.models.dtos.PriceDto;
import kg.megacom.ChannelPost.models.dtos.inputForChannel.InputPriceDto;

import java.util.List;

public interface PriceService {
    PriceDto findByChannelId(Long id);
    List<PriceDto> findAllCurrentlyActivePrices();
    PriceDto savePriceForChannel(InputPriceDto inputPriceDto);
}
