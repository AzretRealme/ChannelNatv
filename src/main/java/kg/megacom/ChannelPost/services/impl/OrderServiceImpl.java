package kg.megacom.ChannelPost.services.impl;

import kg.megacom.ChannelPost.dao.OrderRepo;
import kg.megacom.ChannelPost.mappers.OrderMapper;
import kg.megacom.ChannelPost.models.dtos.DayDto;
import kg.megacom.ChannelPost.models.dtos.DiscountDto;
import kg.megacom.ChannelPost.models.dtos.OrderDetailDto;
import kg.megacom.ChannelPost.models.dtos.OrderDto;
import kg.megacom.ChannelPost.models.dtos.inputOrder.InputChannelDto;
import kg.megacom.ChannelPost.models.dtos.inputOrder.InputOrderDto;
import kg.megacom.ChannelPost.models.dtos.outputOrder.OutputChannelDtoForOrder;
import kg.megacom.ChannelPost.models.dtos.outputOrder.OutputOrderDto;
import kg.megacom.ChannelPost.models.enums.Status;
import kg.megacom.ChannelPost.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private DayService dayService;

    @Override
    public OutputOrderDto saveOrder(InputOrderDto inputOrderDto) {
        List<OrderDetailDto> orderDetailDtoList = inputOrderDto.getChannels().stream().map(x->{
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            orderDetailDto.setChannelDto(channelService.findById(x.getChannel_id()));
            orderDetailDto.setPrice(calculatePrice(x.getChannel_id(), inputOrderDto.getText(), x.getDays().size()));
            return orderDetailDto;
        }).collect(Collectors.toList());

        inputOrderDto.getChannels().forEach(x -> System.out.println(x.getDays()));

        OrderDto orderDto = new OrderDto();
        orderDto.setName(inputOrderDto.getName());
        orderDto.setEmail(inputOrderDto.getEmail());
        orderDto.setPhone(inputOrderDto.getPhone());
        orderDto.setText(inputOrderDto.getText());
        orderDto.setStatus(Status.NEW);
        double totalPriceForOrder = 0;

        for (OrderDetailDto o:
             orderDetailDtoList) {
            totalPriceForOrder = totalPriceForOrder + o.getPrice();
        }

        orderDto.setTotalPrice(totalPriceForOrder);
        OrderDto orderDtoSaved = orderMapper.toDto(orderRepo.save(orderMapper.toEntity(orderDto)));
        orderDetailDtoList.forEach(x -> x.setOrderDto(orderDtoSaved));
        List<OrderDetailDto> orderDetailDtoListSaved = orderDetailDtoList.stream().map(x -> {
            return orderDetailService.save(x);
        }).collect(Collectors.toList());

        List<InputChannelDto> inputChannelDtoList = inputOrderDto.getChannels();

        OutputOrderDto outputOrderDto = new OutputOrderDto();


        List<OrderDetailDto> orderDetailDtoListByOrderId = orderDetailService.findByOrderId(orderDtoSaved.getId());
        for (OrderDetailDto o:
                orderDetailDtoListByOrderId) {
            List<Date> days = null;
            for (InputChannelDto i:
                    inputChannelDtoList) {
                if(i.getChannel_id().equals(o.getChannelDto().getId())){
                    days = i.getDays();
                    i.getDays().forEach(System.out::println);
                }
            }
            assert days != null;
            days.forEach(d -> dayService.saveByDateAndOrderDetailDto(d, o));
            days.forEach(System.out::println);
        }
        List<OutputChannelDtoForOrder> outputChannelDtoForOrderArrayList = new ArrayList<>();

        for (OrderDetailDto o : orderDetailDtoListByOrderId) {
            OutputChannelDtoForOrder outputChannelDtoForOrder = new OutputChannelDtoForOrder();
            outputChannelDtoForOrder.setPrice(o.getPrice());
            outputChannelDtoForOrder.setChannel_id(o.getChannelDto().getId());
            List<DayDto> dayDtos = dayService.findByOrderDetailId(o.getId());
            List<Date> dates = new ArrayList<>();
            for (DayDto od : dayDtos) {
                Date date;
                date = od.getDay();
                dates.add(date);
            }
            outputChannelDtoForOrder.setDays(dates);
            outputChannelDtoForOrderArrayList.add(outputChannelDtoForOrder);
        }
        outputOrderDto.setOutputChannelDtoForOrderList(outputChannelDtoForOrderArrayList);
        outputOrderDto.setEmail(orderDtoSaved.getEmail());
        outputOrderDto.setName(orderDtoSaved.getName());
        outputOrderDto.setPhone(orderDtoSaved.getPhone());
        outputOrderDto.setText(orderDtoSaved.getText());
        outputOrderDto.setTotal_price(orderDtoSaved.getTotalPrice());



        return outputOrderDto;
    }


    @Override
    public double calculatePrice(Long id, String txt, int daysCount) {
        long symbolCount = txt.replaceAll("\\s+", "").chars().count();
        List<DiscountDto> discountDtoList = discountService.findByChannelId(id);
        double price = priceService.findByChannelId(id).getPrice();
        System.out.println(price);
        System.out.println(daysCount);

        int percent = 0;
        for (DiscountDto discountDto : discountDtoList) {

            int minDays = discountDto.getMinDays();
            System.out.println(minDays);

            if (daysCount < minDays) {
                percent = 0;
                break;
            } else {
                percent = discountDto.getPercent();
            }
        }
        System.out.println(symbolCount);
        System.out.println("Percent" + percent);
        System.out.println(((100 - percent)/100)*(price * symbolCount));
        System.out.println("100 - percent = "+ (100 - percent));
        System.out.println("100 - percent)/100 = " + (float)((100 - percent)/100.0));
        return ((100 - percent)/100.0)*(price * symbolCount);
    }


}
