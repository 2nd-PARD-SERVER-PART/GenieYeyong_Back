package pard.dragon.genie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pard.dragon.genie.dto.ResponseDto;
import pard.dragon.genie.dto.WishDto;
import pard.dragon.genie.entity.WishEntity;
import pard.dragon.genie.service.WishService;

import java.util.List;

@RestController
@RequestMapping("/wish2024")
public class WishController {
    private final WishService wishService;

    @Autowired
    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @PostMapping("/wishWrite")
    public ResponseDto<WishEntity> addWish(@RequestBody WishDto dto) {
        ResponseDto<WishEntity> result = wishService.addWish(dto);
        return result;
    }

    @GetMapping("/findAll")
    public ResponseDto<List<WishEntity>> findAll() {
        ResponseDto<List<WishEntity>> result = wishService.findAll();
        return result;
    }

    @GetMapping("/findOneWish/{type}")
    public ResponseDto<List<WishEntity>> findOneWish(@PathVariable String type){
        ResponseDto<List<WishEntity>> result = wishService.findOneWish(type);
        return result;
    }


}
