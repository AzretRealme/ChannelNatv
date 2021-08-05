package kg.megacom.ChannelGo.controllers;

import kg.megacom.ChannelGo.models.dtos.inputOrder.InputOrderDto;
import kg.megacom.ChannelGo.models.dtos.outputOrder.OutputOrderDto;
import kg.megacom.ChannelGo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order-channel-post")
    OutputOrderDto orderChannelsPost(@RequestBody InputOrderDto inputOrderDto){
        return orderService.saveOrder(inputOrderDto);
    }
}
