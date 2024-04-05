package com.humanedu.searchfood.wishlist;

import com.humanedu.searchfood.naver.NaverAPIClient;
import com.humanedu.searchfood.naver.dto.ImageRegionRequest;
import com.humanedu.searchfood.naver.dto.ImageRegionResponse;
import com.humanedu.searchfood.naver.dto.SearchRegionRequestDto;
import com.humanedu.searchfood.naver.dto.SearchRegionResponseDto;
import com.humanedu.searchfood.wishlist.WishListDto.WishListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {
    @Autowired
    private NaverAPIClient naverAPIClient;

    @Autowired
    private WishListRepository wishListRepository;

    public WishListDto search(String paramQuery){
        WishListDto wishListDto = new WishListDto();

        SearchRegionRequestDto searchRegionRequestDto = new SearchRegionRequestDto();
        searchRegionRequestDto.setQuery(paramQuery);

        SearchRegionResponseDto searchRegionResponseDto = naverAPIClient.searchRegion(searchRegionRequestDto);

        List<SearchRegionResponseDto.SearchRegionItem> searchRegionItems = searchRegionResponseDto.getItems();

        if(searchRegionItems != null && searchRegionItems.size()>0){
            wishListDto.setTitle(searchRegionItems.get(0).getTitle());
            wishListDto.setCategory(searchRegionItems.get(0).getCategory());
            wishListDto.setJibunAddress(searchRegionItems.get(0).getAddress());
            wishListDto.setRoadAddress(searchRegionItems.get(0).getRoadAddress());
            wishListDto.setHomepageLink(searchRegionItems.get(0).getLink());
        }
        ImageRegionRequest imageRegionRequest = new ImageRegionRequest();
        imageRegionRequest.setQuery(paramQuery);
        ImageRegionResponse imageRegionResponse = naverAPIClient.imageRegion(imageRegionRequest);
        List<ImageRegionResponse.ImageRegionItems> imageRegionItems = imageRegionResponse.getItems();
        if(imageRegionItems !=null && imageRegionItems.size()>0){
            wishListDto.setImageLink(imageRegionItems.get(0).getLink());
        }

        return wishListDto;
    }

    public WishListVO addWish(WishListDto wishListDto){
        // Storage(DB, Memory etc)에 위시정보 저장
        return wishListRepository.wishSave(wishListDto);
    }

    public List<WishListVO> allWish(){
        List<WishListVO> wishListVOList = wishListRepository.wishAll();
        return wishListVOList;
    }

    public void deleteWish(int id){
        wishListRepository.wishDelete(id);
    }

    public void updateWish(int id){
        wishListRepository.wishUpdate(id);
    }
}
