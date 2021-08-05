package kg.megacom.ChannelGo.mappers;

import kg.megacom.ChannelGo.models.dtos.ChannelDto;
import kg.megacom.ChannelGo.models.entities.Channel;

import java.util.List;

public interface ChannelMapper {
    Channel toEntity(ChannelDto channelDto);
    ChannelDto toDto(Channel channel);


    List<Channel> toEntities(List<ChannelDto> channelDtos);
    List<ChannelDto> toDtos(List<Channel> channels);
}
