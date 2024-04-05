//console.log("찍어");

//검색 버튼을 눌렀을 때 이벤트
var imageUL=$('#imgfile');
var listUL=$('#searchList');
$('#searchButton').click(function(){

    const query = $('#searchBox').val(); //검색어

    imageService.getList(
        { searchQuery:query},
        function(list) {
            var str = "";
            var str2 = "";
            str+="<li id='title' class='list-group-item'>"+list.title+"</li>";
            str+="<li id='category' class='list-group-item'>"+list.category+"</li>";
            str+="<li id='jibunAddress' class='list-group-item'>"+list.jibunAddress+"</li>";
            str+="<li id='roadAddress' class='list-group-item'>"+list.roadAddress+"</li>";
            str+="<li class='list-group-item'><a id='homepageLink' href='"+list.homepageLink+"' target='_blank'>홈페이지</a></li>";
            listUL.html(str);

            str2+="<img id='imgtag' src='"+list.imageLink+"' style='width: 100%; height: 100%;' alt='검색결과 이미지'/>";
            imageUL.html(str2);

        }
    );
});


var contents = $('#contents');
$('#wishPlus').click(function(){
    var title = $('#title').text();
    var category = $('#category').text();
    var jibunAddress = $('#jibunAddress').text();
    var roadAddress = $('#roadAddress').text();
    var homepageLink = $('#homepageLink').prop('href');
    var imgtag = $('#imgtag').attr("src");

    var str3 = "";
    str3+="<br><br>";
    str3+="<div class='row'>";
    str3+="<div class='col-md-8'>";
    str3+="<img src='"+imgtag+"' style='width: 100%; height: 100%;' alt='검색결과 이미지'/>";
    str3+="</div>";
    str3+="<div class='col-md-4'>";
    str3+="<ul class='list-group list-group-flush'>";
    str3+="<li class='list-group-item'>"+title+"</li>";
    str3+="<li class='list-group-item'>"+category+"</li>";
    str3+="<li class='list-group-item'>"+jibunAddress+"</li>";
    str3+="<li class='list-group-item'>"+roadAddress+"</li>";
    str3+="<li class='list-group-item'><a href='"+homepageLink+"'>홈페이지</a></li>";
    str3+="</ul>";
    str3+="<button type='button' class='btn btn-primary' style='position:absolute; bottom:0px; width: 100%;'>위시리스트 삭제</button>";
    str3+="</div>";
    str3+="</div>";
    contents.append(str3);
});

var imageService = (function() {

    //댓글 조회
    function getList(param, callback, error){
        var searchQuery = param.searchQuery;
        $.getJSON("/api/search/"+searchQuery,
            function(data){
                if(callback){
                    callback(data);
                }
        }).fail(function(xhr,status,err){
            if(error){
                error();
            }
        });
    }

    return {
        getList:getList
    };       // replyAdd function의 내용이 나옴
})();

