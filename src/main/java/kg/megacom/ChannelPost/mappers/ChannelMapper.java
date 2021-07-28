package kg.megacom.ChannelPost.mappers;

import kg.megacom.ChannelPost.models.dtos.ChannelDto;
import kg.megacom.ChannelPost.models.dtos.channelsOutput.OutputChannelDto;
import kg.megacom.ChannelPost.models.entities.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChannelMapper {
    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);

    Channel toEntity(ChannelDto channelDto);
    ChannelDto toDto(Channel channel);


    List<Channel> toEntities(List<ChannelDto> channelDtos);
    List<ChannelDto> toDtos(List<Channel> channels);
}
