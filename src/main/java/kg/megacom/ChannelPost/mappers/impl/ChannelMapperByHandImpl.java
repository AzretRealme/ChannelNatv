package kg.megacom.ChannelPost.mappers.impl;

import kg.megacom.ChannelPost.mappers.ChannelMapperByHand;
import kg.megacom.ChannelPost.models.dtos.ChannelDto;
import kg.megacom.ChannelPost.models.entities.Channel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChannelMapperByHandImpl implements ChannelMapperByHand {
    @Override
    public Channel toEntity(ChannelDto channelDto) {
        Channel channel = new Channel();
        channel.setId(channelDto.getId());
        channel.setActive(channelDto.isActive());
        channel.setName(channelDto.getName());
        channel.setPhoto(channelDto.getPhoto());
        channel.setOrderNum(channelDto.getOrderNum());
        return channel;
    }

    @Override
    public ChannelDto toDto(Channel channel) {
        ChannelDto channelDto = new ChannelDto();
        channelDto.setId(channel.getId());
        channelDto.setActive(channel.isActive());
        channelDto.setName(channel.getName());
        channelDto.setPhoto(channel.getPhoto());
        channelDto.setOrderNum(channel.getOrderNum());
        return channelDto;
    }

    @Override
    public List<Channel> toEntities(List<ChannelDto> channelDtos) {

        return channelDtos.stream().map(x -> {
            Channel channel = new Channel();
            channel.setId(x.getId());
            channel.setName(x.getName());
            channel.setPhoto(x.getPhoto());
            channel.setActive(x.isActive());
            channel.setOrderNum(x.getOrderNum());
            return channel;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ChannelDto> toDtos(List<Channel> channels) {

        return channels.stream().map(x -> {
            ChannelDto channelDto = new ChannelDto();
            channelDto.setId(x.getId());
            channelDto.setName(x.getName());
            channelDto.setPhoto(x.getPhoto());
            channelDto.setActive(x.isActive());
            channelDto.setOrderNum(x.getOrderNum());
            return channelDto;
        }).collect(Collectors.toList());
    }
}
