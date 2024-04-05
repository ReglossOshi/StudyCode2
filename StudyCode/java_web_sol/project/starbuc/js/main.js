// //vanilla js
// const searchEl =document.querySelector('.search');
// const searchInputEl =document.querySelector('input');


// //input과 돋보기 클릭했을 때
// searchEl.addEventListener('click',function(){
//     searchInputEl.focus();
// });

// //포커스가 될때
// searchInputEl.addEventListener('focus',function(){
//     searchInputEl.setAttribute('placeholder','통합검색')
// });

// //포커스를 잃을때
// searchInputEl.addEventListener('blur',function(){
//     searchInputEl.setAttribute('placeholder','')
// });


//jquery is
$('.search').click(function(){
    $('input').focus();
});

$('input').focus(function(){
    $('input').attr('placeholder','통합검색');
});

$('input').blur(function(){
    $('input').attr('placeholder','');
});

var i =0;
window.addEventListener('scroll', _.throttle(function(){
        console.log(window.scrollY);
        if(window.scrollY > 500){
            //배지 숨기기
            gsap.to('header .bener',0.4 ,{opacity:0});
            // $(".bener").css("display" ,"none");
        } else{
            //배지 보이기
            // $(".bener").css("display" ,"block");
            gsap.to('header .bener',0.4,{opacity:1});
        }
}));

//visual 애니메이션
const fadeEls = document.querySelectorAll('.visual .fade-in');
fadeEls.forEach(function(value, index){
    gsap.to(value,1,{
        delay:(index + 1)*0.7,
        opacity:1
    })
})


//스와이퍼
// notice swpier rolling
new Swiper('.notice-line .swiper-container', {
    // Optional parameters
    direction: 'vertical',
    loop: true, //반복재생여부
    autoplay: {
      delay: 2000,  // 단위는 ms
    }
  });

//   let isSlideVisible = true;
//   const menu=document.querySelector('.item__contents');

// $(function(){
//     $('.item').mouseenter(function(){
//         $(menu).css('display','none');
//         $(menu).slideDown();
//     })
//     $('.item').mouseleave(function(){
//         $(menu).css('display','none');
//         $(menu).slideUp();
//     })
// });



// promotion swpier rolling
new Swiper('.promotion .swiper-container', {
    slidesPerView: 3, // 한번 보여줄 슬라이드 개수
    spaceBetween: 10, // 슬라이드 사이 여백
    centeredSlides: true, // 1번 슬라이드가 가운개 보이기
    autoplay: { // 자동재생여부
      delay: 3000,  // 3초마다 슬라이드 바뀜
    },
    loop: true,
    pagination: {
      el: '.promotion .swiper-pagination', // 페이지 번호 요소 선택자
      clickable: true,  // 페이지 번호 클릭 제어 가능
    },
    navigation: {   // 슬라이드 이전/다음 버튼 사용
        prevEl: '.swiper-button-prev',
        nextEl: '.swiper-button-next',
      },
  });
  
//promotion 슬라이드 토글 기능
const promotionEl=document.querySelector('.promotion');
const promotionToggleBtn=document.querySelector('.toggle-promotion');
let isHidePromotion = false;

promotionToggleBtn.addEventListener('click',function(){
    isHidePromotion=!isHidePromotion;
    console.log('눌림');
    if(isHidePromotion){
        promotionEl.classList.add('hide');
    } else{
        promotionEl.classList.remove('hide');
    }
})