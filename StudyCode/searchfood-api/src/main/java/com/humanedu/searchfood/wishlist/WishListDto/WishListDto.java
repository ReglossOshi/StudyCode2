package com.humanedu.searchfood.wishlist.WishListDto;

import lombok.Data;

@Data
public class WishListDto {
    private Integer id;
    private String title;
    private String category;
    private String jibunAddress;
    private String roadAddress;
    private String homepageLink;
    private String imageLink;
}
