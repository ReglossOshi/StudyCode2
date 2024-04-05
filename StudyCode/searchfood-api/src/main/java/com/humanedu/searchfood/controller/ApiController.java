package com.humanedu.searchfood.controller;

import com.humanedu.searchfood.naver.NaverAPIClient;
import com.humanedu.searchfood.naver.dto.ImageRegionRequest;
import com.humanedu.searchfood.naver.dto.ImageRegionResponse;
import com.humanedu.searchfood.naver.dto.SearchRegionRequestDto;
import com.humanedu.searchfood.naver.dto.SearchRegionResponseDto;
import com.humanedu.searchfood.wishlist.WishListDto.WishListDto;
import com.humanedu.searchfood.wishlist.WishListService;
import com.humanedu.searchfood.wishlist.WishListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ApiController {

    @Autowired
    private WishListService wishListService;

    @GetMapping("/search/{searchQuery}")
    public ResponseEntity<WishListDto> search2(@PathVariable String searchQuery){
        WishListDto wishListDto = wishListService.search(searchQuery);

        return new ResponseEntity<>(wishListDto,HttpStatus.OK);
    }

    @GetMapping("/search")
    public WishListDto search(@RequestParam String searchQuery) {
        WishListDto wishListDto = wishListService.search(searchQuery);
        return wishListDto;
    }

    //2.위시 리스트 추가 POST
    @PostMapping("/wishadd")
    public WishListVO wishAdd(@RequestBody WishListDto wishListDto, @RequestParam int id){
        wishListDto.setId(id);
        return wishListService.addWish(wishListDto);
    }

    //3.위시리스트 목록 가져오기 API(GET
    @GetMapping("/wishall")
    public List<WishListVO> wishAll(){
        return wishListService.allWish();
    }

    @DeleteMapping("/select/{id}")
    public void wishDelete(@PathVariable int id){

        wishListService.deleteWish(id);
    }

    @PutMapping("/reset")
    public void wishUpdate(@RequestParam int id){
        wishListService.updateWish(id);
    }
}
