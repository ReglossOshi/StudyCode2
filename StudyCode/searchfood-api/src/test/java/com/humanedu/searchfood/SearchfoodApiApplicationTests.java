package com.humanedu.searchfood;

import com.humanedu.searchfood.naver.NaverAPIClient;
import com.humanedu.searchfood.naver.dto.ImageRegionRequest;
import com.humanedu.searchfood.naver.dto.ImageRegionResponse;
import com.humanedu.searchfood.naver.dto.SearchRegionRequestDto;
import com.humanedu.searchfood.naver.dto.SearchRegionResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SearchfoodApiApplicationTests {
	@Autowired
	private NaverAPIClient naverAPIClient;

	@Test
	void contextLoads() {
	}

	@Test //네이버 지역검색 OpenAPI 테스트
	void naverSearchRegionAPITest(){
		String paramQuery = "커피";

		SearchRegionRequestDto a = new SearchRegionRequestDto();
		a.setQuery(paramQuery);
		//네이버 지역 검색 OpenAPI Call method 테스트
		SearchRegionResponseDto searchRegionResponseDto =naverAPIClient.searchRegion(a);

		System.out.println("네이버 지역 검색"+searchRegionResponseDto);
	}

	@Test
	void naverImageRegionAPITest(){
		String paramQuery = "커피";
		ImageRegionRequest a = new ImageRegionRequest();
		a.setQuery(paramQuery);

		ImageRegionResponse b = naverAPIClient.imageRegion(a);
		System.out.println("네이버 이미지 검색"+b);
	}
}
