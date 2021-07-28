package kg.megacom.ChannelPost.services;

import kg.megacom.ChannelPost.models.dtos.ChannelDto;
import kg.megacom.ChannelPost.models.dtos.channelsOutput.OutputChannelDto;
import kg.megacom.ChannelPost.models.entities.Channel;

import java.util.List;

public interface ChannelService {
    List<OutputChannelDto> findAll();

    ChannelDto saveChannel(ChannelDto channelDto);

    ChannelDto findLastChannelInTheList();

    ChannelDto findById(Long id);

    List<ChannelDto> findAllChannelDtos();
}
