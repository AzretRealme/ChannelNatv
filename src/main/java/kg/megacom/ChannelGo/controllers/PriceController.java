package kg.megacom.ChannelGo.controllers;

import kg.megacom.ChannelGo.models.dtos.PriceDto;
import kg.megacom.ChannelGo.models.dtos.inputForChannel.InputPriceDto;
import kg.megacom.ChannelGo.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/save-price")
    public PriceDto savePriceForChannel(@RequestBody InputPriceDto inputPriceDto){
        return priceService.savePriceForChannel(inputPriceDto);
    }
}
