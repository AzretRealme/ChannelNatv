package kg.megacom.ChannelPost.services.impl;

import kg.megacom.ChannelPost.dao.OrderRepo;
import kg.megacom.ChannelPost.models.dtos.ChannelDto;
import kg.megacom.ChannelPost.models.dtos.DiscountDto;
import kg.megacom.ChannelPost.models.dtos.OrderDetailDto;
import kg.megacom.ChannelPost.models.dtos.OrderDto;
import kg.megacom.ChannelPost.models.dtos.inputOrder.InputOrderDto;
import kg.megacom.ChannelPost.models.dtos.outputOrder.OutputOrderDto;
import kg.megacom.ChannelPost.models.entities.Order;
import kg.megacom.ChannelPost.models.entities.OrderDetail;
import kg.megacom.ChannelPost.models.enums.Status;
import kg.megacom.ChannelPost.services.ChannelService;
import kg.megacom.ChannelPost.services.DiscountService;
import kg.megacom.ChannelPost.services.OrderService;
import kg.megacom.ChannelPost.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private DiscountService discountService;

    @Override
    public OutputOrderDto saveOrder(InputOrderDto inputOrderDto) {
        OrderDto orderDto = new OrderDto();
        orderDto.setName(inputOrderDto.getName());
        orderDto.setEmail(inputOrderDto.getEmail());
        orderDto.setPhone(inputOrderDto.getPhone());
        orderDto.setText(inputOrderDto.getText());
        orderDto.setStatus(Status.NEW);

        List<OrderDetailDto> orderDetailDtoList = inputOrderDto.getChannels().stream().map(x->{
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            orderDetailDto.setChannelDto(channelService.findById(x.getChannel_id()));
            orderDetailDto.setPrice(calculatePrice(x, inputOrderDto.getText(), ));
        });
        return null;
    }

    @Override
    public double calculatePrice(ChannelDto channelDto, String txt, int daysCount) {
        long symbolCount = txt.trim().chars().count();
        List<DiscountDto> discountDtoList = discountService.findByChannelId(channelDto.getId());
        //discountDtoList.
        double price = priceService.findByChannelId(channelDto.getId()).getPrice();

        int percent = 0;
        for(int i = 0; i < discountDtoList.size(); i ++){

            int minDays = discountDtoList.get(i).getMinDays();

            if(daysCount < minDays){
                percent = 0;
                break;
            }
            else {
                percent = discountDtoList.get(i).getPercent();
            }
        }
        return (100 - percent)*(price * symbolCount);
    }


}
