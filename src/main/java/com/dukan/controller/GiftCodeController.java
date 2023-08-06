package com.dukan.controller;

import com.dukan.model.GiftCodeDTO;
import com.dukan.service.GiftCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/giftcodes")
public class GiftCodeController {
    private final GiftCodeService giftCodeService;

    public GiftCodeController(GiftCodeService giftCodeService) {
        this.giftCodeService = giftCodeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GiftCodeDTO> getGiftCodes(){
        return giftCodeService.getGiftCodes();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GiftCodeDTO getGiftCode(@PathVariable Long id){
        return giftCodeService.getGiftCode(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addGiftCode(@RequestBody GiftCodeDTO giftCodeDTO){
        giftCodeService.addGiftCode(giftCodeDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateGiftCode(@PathVariable Long id,@RequestBody GiftCodeDTO giftCodeDTO){
        giftCodeService.updateGiftCode(id,giftCodeDTO);
    }
}
