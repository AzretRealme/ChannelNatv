package kg.megacom.ChannelPost.services;

import kg.megacom.ChannelPost.models.dtos.ChannelDto;
import kg.megacom.ChannelPost.models.dtos.inputOrder.InputOrderDto;
import kg.megacom.ChannelPost.models.dtos.outputOrder.OutputOrderDto;

public interface OrderService {
    OutputOrderDto saveOrder(InputOrderDto inputOrderDto);

    double calculatePrice(Long id, String txt, int daysCount);

}
