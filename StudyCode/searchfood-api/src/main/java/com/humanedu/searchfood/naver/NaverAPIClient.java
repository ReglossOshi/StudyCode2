package com.humanedu.searchfood.naver;

import com.humanedu.searchfood.naver.dto.ImageRegionRequest;
import com.humanedu.searchfood.naver.dto.ImageRegionResponse;
import com.humanedu.searchfood.naver.dto.SearchRegionRequestDto;
import com.humanedu.searchfood.naver.dto.SearchRegionResponseDto;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class NaverAPIClient {
    // 1. 지역검색 API Call method(request dto,response dto)
    public SearchRegionResponseDto searchRegion(SearchRegionRequestDto searchRegionRequestDto){
        //API Call Library -> HttpURLConnection, WebClient, ->RestTemplate, Retry,...
        //(1)Header 설정
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-Naver-Client-Id","ndKeXSlDp_q41qZ18eb_");
//        headers.set("X-Naver-Client-Secret","H9QXU0NsUo");
//        headers.setContentType(MediaType.APPLICATION_JSON);


        // (2) Request 설정
//        URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com")      // 도메인 주소
//                .path("/v1/search/local.json")
//                .queryParam("query", searchRegionRequestDto.getQuery())
//                //.queryParam("display", 1)
//                .encode()
//                .build()
//                .toUri();
        //  (3,4) Response 설정, 실제 API Call
//        HttpEntity httpEntity = new HttpEntity(getHttpHeaders());
//        ResponseEntity<SearchRegionResponseDto> responseRestTemplate
//                = new RestTemplate().exchange(
//                uri, HttpMethod.GET, httpEntity, SearchRegionResponseDto.class);
        URI uri = getURI("/v1/search/local.json",searchRegionRequestDto.getQuery());
        ResponseEntity<SearchRegionResponseDto> responseRestTemplate = getHttpEntity(uri, SearchRegionResponseDto.class);
        return responseRestTemplate.getBody();
    }

    //2.지역 이미지 검색 API Call method(ImageRegionRequest dto, ImageRegionResponse dto)

    public ImageRegionResponse imageRegion(ImageRegionRequest imageRegionRequest){
        // (2) Request 설정
        URI uri = getURI("/v1/search/image",imageRegionRequest.getQuery());
        ResponseEntity<ImageRegionResponse> responseRestTemplate = getHttpEntity(uri,ImageRegionResponse.class);
        return responseRestTemplate.getBody();
    }

    private ResponseEntity getHttpEntity(URI uri, Class name){ //URI 값과 Class 값을 받아옴
        HttpEntity httpEntity = new HttpEntity(getHttpHeaders());//(1-1)Header 사용
        return new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, name); //Rest 방식 API 호출해서 ResponseEntity에 넣음
    }

    private HttpHeaders getHttpHeaders(){
        //(1)Header 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id","ndKeXSlDp_q41qZ18eb_");
        headers.set("X-Naver-Client-Secret","H9QXU0NsUo");
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private URI getURI(String path, String query){
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")      // 도메인 주소
                .path(path)
                .queryParam("query", query)
                .encode()
                .build()
                .toUri();
        return uri;
    }
}
