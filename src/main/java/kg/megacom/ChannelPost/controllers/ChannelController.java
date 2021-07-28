package kg.megacom.ChannelPost.controllers;

import kg.megacom.ChannelPost.models.dtos.ChannelDto;
import kg.megacom.ChannelPost.models.dtos.channelsOutput.OutputChannelDto;
import kg.megacom.ChannelPost.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/channels")
public class ChannelController {
    @Autowired
    private ChannelService channelService;
    @GetMapping("/findAll")
    public List<OutputChannelDto> findAll(){

        return channelService.findAll();
    }

    @PostMapping("/save-channel")
    public ChannelDto save(@RequestBody ChannelDto СhannelDto){
        return channelService.saveChannel(СhannelDto);
    }

    @GetMapping("/findAllChannelDtos")
    public List<ChannelDto> findAllChannelDtos(){
        return channelService.findAllChannelDtos();
    }


}
