package kg.megacom.ChannelPost.services.impl;

import kg.megacom.ChannelPost.exceptions.ChannelNotFoundException;
import kg.megacom.ChannelPost.dao.ChannelRepo;
import kg.megacom.ChannelPost.mappers.ChannelMapper;
import kg.megacom.ChannelPost.models.dtos.ChannelDto;
import kg.megacom.ChannelPost.models.dtos.PriceDto;
import kg.megacom.ChannelPost.models.dtos.channelsOutput.OutputChannelDto;
import kg.megacom.ChannelPost.models.dtos.channelsOutput.OutputDiscountDto;
import kg.megacom.ChannelPost.models.entities.Channel;
import kg.megacom.ChannelPost.services.ChannelService;
import kg.megacom.ChannelPost.services.DiscountService;
import kg.megacom.ChannelPost.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelRepo channelRepo;
    @Autowired
    private PriceService priceService;
    @Autowired
    private DiscountService discountService;
    @Override
    public List<OutputChannelDto> findAll() {
        List<PriceDto> priceDtoList = priceService.findAllCurrentlyActivePrices().stream().filter(x -> x.getChannelDto().isActive()).collect(Collectors.toList());
        List<OutputChannelDto> outputChannelDtos = priceDtoList.stream().map(x->{
            OutputChannelDto outputChannelDto = new OutputChannelDto();
            outputChannelDto.setId(x.getChannelDto().getId());
            outputChannelDto.setOutputDiscountDtoList( discountService.findAllCurrentlyActiveDiscounts(x.getChannelDto().getId()).
                    stream().map(y ->{
                OutputDiscountDto outputDiscountDto = new OutputDiscountDto();
                outputDiscountDto.setMinDays(y.getMinDays());
                outputDiscountDto.setPercent(y.getPercent());
                return outputDiscountDto;
            }).collect(Collectors.toList()));
            outputChannelDto.setName(x.getChannelDto().getName());
            outputChannelDto.setPhoto(x.getChannelDto().getPhoto());
            outputChannelDto.setPrice(x.getPrice());
            return outputChannelDto;
        }).collect(Collectors.toList());

        return outputChannelDtos;
    }

    @Override
    public ChannelDto saveChannel(ChannelDto channelDto) {
//        ChannelDto lastChannelInTheList = findLastChannelInTheList();
//        if(lastChannelInTheList == null){
//            channelDto.setOrderNum(1);
//        }else {
//            channelDto.setOrderNum(lastChannelInTheList.getOrderNum() + 1);
//        }

        Channel channel = ChannelMapper.INSTANCE.toEntity(channelDto);
        System.out.println(channel);

        Channel channelSaved = channelRepo.save(channel);
        System.out.println(channelSaved);

        return ChannelMapper.INSTANCE.toDto(channelSaved);
    }



    @Override
    public ChannelDto findLastChannelInTheList() {
        Channel channel = channelRepo.findLastChannelInTheList();
        if(channel == null){
            return null;
        }
        return ChannelMapper.INSTANCE.toDto(channel);
    }

    @Override
    public ChannelDto findById(Long id) {
        return ChannelMapper.INSTANCE.toDto(channelRepo.findById(id).orElseThrow(() -> new ChannelNotFoundException("Channel not found!!!")));
    }

    @Override
    public List<ChannelDto> findAllChannelDtos() {
        return ChannelMapper.INSTANCE.toDtos(channelRepo.findAll());
    }


}
