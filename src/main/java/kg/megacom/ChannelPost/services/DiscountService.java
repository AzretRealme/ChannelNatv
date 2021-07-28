package kg.megacom.ChannelPost.services;

import kg.megacom.ChannelPost.models.dtos.DiscountDto;
import kg.megacom.ChannelPost.models.dtos.inputForChannel.InputDiscountDto;

import java.util.List;

public interface DiscountService {
    List<DiscountDto> findAllCurrentlyActiveDiscounts(Long id);

    List<DiscountDto> findByChannelId(Long id);

    DiscountDto saveDiscount(InputDiscountDto inputDiscountDto);
}
