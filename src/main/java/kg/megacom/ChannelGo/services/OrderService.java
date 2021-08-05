package kg.megacom.ChannelGo.services;

import kg.megacom.ChannelGo.models.dtos.inputOrder.InputOrderDto;
import kg.megacom.ChannelGo.models.dtos.outputOrder.OutputOrderDto;

public interface OrderService {
    OutputOrderDto saveOrder(InputOrderDto inputOrderDto);

    double calculatePrice(Long id, String txt, int daysCount);

}
