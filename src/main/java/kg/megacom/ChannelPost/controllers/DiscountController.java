package kg.megacom.ChannelPost.controllers;

import kg.megacom.ChannelPost.models.dtos.DiscountDto;
import kg.megacom.ChannelPost.models.dtos.inputForChannel.InputDiscountDto;
import kg.megacom.ChannelPost.services.DiscountService;
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
