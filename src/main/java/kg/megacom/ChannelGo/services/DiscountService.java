package kg.megacom.ChannelGo.services;

import kg.megacom.ChannelGo.models.dtos.DiscountDto;
import kg.megacom.ChannelGo.models.dtos.inputForChannel.InputDiscountDto;

import java.util.List;

public interface DiscountService {
    List<DiscountDto> findAllCurrentlyActiveDiscounts(Long id);

    List<DiscountDto> findByChannelId(Long id);

    DiscountDto saveDiscount(InputDiscountDto inputDiscountDto);
}
