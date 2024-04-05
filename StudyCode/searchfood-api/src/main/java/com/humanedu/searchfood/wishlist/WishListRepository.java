package com.humanedu.searchfood.wishlist;

import com.humanedu.searchfood.utils.StringUtils;
import com.humanedu.searchfood.wishlist.WishListDto.WishListDto;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WishListRepository {
    //List 자바메모리 위시정보
    private List<WishListVO> wishListVOList = new ArrayList<>();

    //위시 리스트 저장
    public WishListVO wishSave(WishListDto wishListDto){
        WishListVO wishListVO = new WishListVO();
        wishListVO.setId(wishListDto.getId());
        wishListVO.setTitle(StringUtils.removeTags(wishListDto.getTitle()));
        wishListVO.setCategory(wishListDto.getCategory());
        wishListVO.setJibunAddress(wishListDto.getJibunAddress());
        wishListVO.setRoadAddress(wishListDto.getRoadAddress());
        wishListVO.setHomepageLink(wishListDto.getHomepageLink());
        wishListVO.setImageLink(wishListDto.getImageLink());
        wishListVO.setVisitIs(true);
        wishListVO.setVisitCount(1);
        wishListVO.setLastVisitDate(LocalDateTime.now());
        wishListVOList.add(wishListVO);
        return wishListVO;
    }

    public List<WishListVO> wishAll(){
        return wishListVOList;
    }

    public void wishDelete(int id){
        for(int i=0;i<wishListVOList.size();i++){
            if(wishListVOList.get(i).getId().equals(id)){
                wishListVOList.remove(i);
            }
        }
    }

    public void wishUpdate(int id){
        for(int i=0;i<wishListVOList.size();i++){
            if(wishListVOList.get(i).getId().equals(id)){
                wishListVOList.get(i).setVisitCount(wishListVOList.get(i).getVisitCount()+1);
            }
        }
    }
}
