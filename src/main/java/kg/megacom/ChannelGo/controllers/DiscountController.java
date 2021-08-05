package kg.megacom.ChannelGo.controllers;

import kg.megacom.ChannelGo.models.dtos.DiscountDto;
import kg.megacom.ChannelGo.models.dtos.inputForChannel.InputDiscountDto;
import kg.megacom.ChannelGo.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/discounts")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @PostMapping("/save-discount")
    public DiscountDto saveNewDiscountForChannel(@RequestBody InputDiscountDto inputDiscountDto){
        return discountService.saveDiscount(inputDiscountDto);
    }
}
