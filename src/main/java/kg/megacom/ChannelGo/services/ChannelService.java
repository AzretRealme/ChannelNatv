package kg.megacom.ChannelGo.services;

import kg.megacom.ChannelGo.models.dtos.ChannelDto;
import kg.megacom.ChannelGo.models.dtos.channelsOutput.OutputChannelDto;

import java.util.List;

public interface ChannelService {
    List<OutputChannelDto> findAll();

    ChannelDto saveChannel(ChannelDto channelDto);

    ChannelDto findLastChannelInTheList();

    ChannelDto findById(Long id);

    List<ChannelDto> findAllChannelDtos();
}
