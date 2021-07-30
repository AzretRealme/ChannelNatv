package kg.megacom.ChannelPost.mappers;

import kg.megacom.ChannelPost.mappers.impl.ChannelMapperByHandImpl;
import kg.megacom.ChannelPost.models.dtos.ChannelDto;
import kg.megacom.ChannelPost.models.entities.Channel;

import java.util.List;

public interface ChannelMapperByHand {
    Channel toEntity(ChannelDto channelDto);
    ChannelDto toDto(Channel channel);


    List<Channel> toEntities(List<ChannelDto> channelDtos);
    List<ChannelDto> toDtos(List<Channel> channels);
}
