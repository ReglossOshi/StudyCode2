<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../includes/header.jsp" %>
    <div class="col-lg-7">
        <div class="p-5">
            <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">게시판 상세조회</h1>
            </div>
            <form role="form" action="/board/modify" method="post">
                <div class="form-group">
                    <label>Bno</label>
                    <input type="text" class="form-control" id="bno" name="bno" value='<c:out value="${board.bno}" />' readonly />
                </div>
                <div class="form-group">
                    <label>제목</label>
                    <input type="text" class="form-control" id="title" name="title" value='<c:out value="${board.title}" />'/>
                </div>
                <div class="form-group">
                    <label>내용</label>
                    <textarea rows="5" class="form-control" id="content"  name="content"><c:out value="${board.content}" /></textarea>
                </div>
                <div class="form-group">
                    <label>작성자</label>
                    <input type="text" class="form-control" id="writer"  name="writer" value='<c:out value="${board.writer}" />' readonly />
                </div>
                <button class="btn btn-primary" type="submit">
                    수정하기
                </button>
                <button class="btn btn-primary" type="submit" formaction="/board/remove" formmethod="post">
                    삭제하기
                </button>
                <button class="btn btn-default" type="button" onclick="location.href='/'">
                    목록
                </button>
            </form>
        </div>
              <div class="panel panel-default">
                  <div class="panel-body">
                  </div>
                  <div class="panel-heading">
                      <i class="fa fa-comments fa-fw"></i> Reply
                      <input type="text" name="reply" id="reply" style="width:60%;" onkeyup="enterkey()" />
                      <button onclick="lineInsert()" id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
                  </div>
                  <div class="panel-footer"></div>
            </div>
        <hr>
        <div class="">
            <ul class="chat">

            </ul>
        </div>
    </div>
</div>
<script src="/resources/js/reply.js"></script>
<script>
    function enterkey(){
        if(window.event.keyCode==13){
            lineInsert();
        }
    }

    console.log("==================");
    console.log("JS TEST");

    const bnoValue = '<c:out value="${board.bno}" />';

    function lineInsert(){
        const replyDate = new Date();
        const reply = $("#reply").val();
        const replyerWriter='tester';

        replyService.add(
                {reply:reply, replyer:"tester", bno:bnoValue },
                function(result){

                    location.reload(true);
                }
        );
    }

     var replyUL = $(".chat");
     function showReplyList(pageNum) {          // 댓글 목록 가져와서 화면에 뿌려주는 함수 선언
         // 1. 댓글 목록 rest ajax로 가져오기
         replyService.getList(
             { bno: bnoValue, page: pageNum || 1 },
             function(list) {                      // ajax 함수 콜 성공시 처리

                 if(list == null || list.length == 0){       // 댓글 개수가 없을 경우
                     replyUL.html("");
                     return;
                 }
                 var str = "";
                 // 댓글 개수가 있을 경우
                 for(var i = 0, len = list.length || 0; i < len; i++) {
                     str += "<li data-rno='" + list[i].rno + "' style='display:flex; align-items:center;justify-content: space-between;'>";
                     str += "    <div class='use'>";
                     str += "        <div>";
                     str += "            <strong class=''>" + list[i].replyer + "</strong>";
                     //str += "            <small class=''>" + replyService.displayTime(list[i].replyDate) + "</small>";

                     str += "            <small class=''>" + list[i].replyDate + "</small>";

                     str += "        </div>";
                     str += "        <p class='rep'>" + list[i].reply + "</p>" ;
                     str += "    </div>";
                     str +="<div class='btn'>"
                     str +="<button onclick='listUpdate("+list[i].rno+")' class='btn btn-primary btn-xs pull-right updatebtn'>수정</button>"
                     str +="<button onclick='listDelete("+list[i].rno+")' class='btn btn-primary btn-xs pull-right updatebtn2' style='margin-left: 10px;'>삭제</button>"
                     str +="</div>"
                     str += "</li>";
                 }
                 replyUL.html(str);
             }
         );
     }
     showReplyList(1);                        // 댓글 목록 가져와서 화면에 뿌려주는 함수 실행


    function listDelete(rno){
        var con=confirm("삭제하시겠습니까?");
        if(con===true){
            replyService.remove(rno, function(count){
                $("li[data-rno='"+rno+"']").remove();
                if(count==="success"){
                    alert("REMOVED");
                }
            }, function(err){
                alert("error....");
            });
            //showReplyList(1);
        }
    }




    function listUpdate(rno){
        var text1 = $("li[data-rno='"+rno+"']").children().children(".rep");
        var btn = $("li[data-rno='"+rno+"']").children().children(".updatebtn");
        var btn2 = $("li[data-rno='"+rno+"']").children().children(".updatebtn2");

        var textList = text1.html();
        text1.contents().unwrap().wrap("<input type='text' id='replyText' value='"+textList+"'>");
        btn.contents().unwrap().wrap("<button onclick='updatebtn("+rno+")' class='btn btn-primary btn-xs pull-right upload' style='background-color:orange;border-color:orange;margin-left:10px;'></button>");
        btn2.html("취소");
        btn2.contents().unwrap().wrap("<button onclick='cancelbtn("+rno+",0)' class='btn btn-primary btn-xs pull-right cancel' style='background-color:red;border-color:red;margin-left:10px;'></button>");
    }

    function updatebtn(rno){

        var text1 = $("li[data-rno='"+rno+"']").children().children("#replyText").val();
        replyService.update(
            {
                rno:rno,
                bno:bnoValue,
                reply:text1
            }, function(result){
                alert("수정 완료");
                cancelbtn(rno, text1, 1);
            }
        );
    }

    function cancelbtn(rno, text, check){
        var text1 = $("li[data-rno='"+rno+"']").children().children("#replyText");
        var btn = $("li[data-rno='"+rno+"']").children().children(".upload");
        var btn2 = $("li[data-rno='"+rno+"']").children().children(".cancel");

        if(check==1){
            text1.html(text);
        } else if(check==0){
            console.log(check);
        }

        text1.contents().unwrap().wrap("<p class='rep'></p>");

        btn.contents().unwrap().wrap("<button onclick='listUpdate("+rno+")' class='btn btn-primary btn-xs pull-right updatebtn'></button>");
        btn2.html("삭제");
        btn2.contents().unwrap().wrap("<button onclick='listDelete("+rno+")' class='btn btn-primary btn-xs pull-right updatebtn2' style='margin-left: 10px;'></button>");

    }
/*
    removeClass()
    addClass()
    show()
    hide()
    replaceWith()
*/


/*
    console.log(bnoValue);

    replyService.add(
        {reply:"JS Test", replyer:"tester", bno:bnoValue },
        function(result){
            alert("Result: "+result);
        }
    );
*/
/*
    replyService.getList(
        { bno: bnoValue, page:1 },
        function(list) {
            for(var i=0, len= list.length || 0; i < len; i++) {
                console.log(list[i]);
            }
        }
    );
*/
/*
    replyService.remove(23, function(count){
        console.log(count);

        if(count==="success"){
            alert("REMOVED");
        }
    }, function(err){
        alert("error....");
    });
*/
/*
    replyService.update(
        {
            rno:22,
            bno:bnoValue,
            reply:"Modified Reply...."
        }, function(result){
            alert("수정 완료");
        }
    );
*/

/*
    replyService.get(10,function(data){
        console.log(data);
    });
    */



    $(document).ready(function() {
        console.log('replyService: ', replyService);

        /*
        // id가 openForm객체 태그 가져오기
        var operForm = $("#operForm");
        // 수정 버튼 클릭에 대한 리스너 설정
        $("button[data-oper='modify']").on("click", function(e){
            operForm.attr("action","/board/modify").submit();
        });
        */
    });


     // 현재 스크롤 위치 저장
        var lastScroll = 0;
        var replyPage = 2;
        const replyTotalCount = <c:out value="${replyTotalCount}" />;
        const replyMaxPageNum = Math.floor(replyTotalCount / 3) + 1;

        $(document).scroll(function(e) {        // 스크롤 이벤트 리스너
            //console.log('test1', test1++);

            var currentScroll = $(this).scrollTop();        // 현재 높이 저장
            //console.log('currentScroll', currentScroll);
            var documentHeight = $(document).height();      // 전체 문서의 높이
            //console.log('documentHeight', documentHeight);

            // 현재 스크롤된 높이값
            var nowHeight = $(this).scrollTop() + $(window).height();
            //console.log('nowHeight', nowHeight);

            // 스크롤이 아래로 내려갔을때 만 해당 이벤트 진행
            if(currentScroll > lastScroll) {
                // nowHeight값이 현 화면의 끝이 어디까지 내려왔는지 파악 가능 -> 전체 문서의 높이에 일정량 근접했을 댓글 리스트 더 가져오기
                if((documentHeight < (nowHeight + (documentHeight * 0.1))) && replyPage <= replyMaxPageNum) {
                    //console.log("내려왔나? currentScroll", currentScroll);

                    // ajax로 댓글 개수 더 가져오기
                    replyService.getList(
                        { bno: bnoValue, page: replyPage++ || 1 },
                        function(list) {                      // ajax 함수 콜 성공시 처리
                           // console.log('list', list);

                            var str = "";
                            for(var i = 0, len = list.length || 0; i < len; i++) {
                                 str += "<li data-rno='" + list[i].rno + "' style='display:flex; align-items:center;justify-content: space-between;'>";
                                 str += "    <div class='use'>";
                                 str += "        <div>";
                                 str += "            <strong class=''>" + list[i].replyer + "</strong>";
                                 //str += "            <small class=''>" + replyService.displayTime(list[i].replyDate) + "</small>";

                                 str += "            <small class=''>" + list[i].replyDate + "</small>";

                                 str += "        </div>";
                                 str += "        <p class='rep'>" + list[i].reply + "</p>" ;
                                 str += "    </div>";
                                 str +="<div class='btn'>"
                                 str +="<button onclick='listUpdate("+list[i].rno+")' class='btn btn-primary btn-xs pull-right updatebtn'>수정</button>"
                                 str +="<button onclick='listDelete("+list[i].rno+")' class='btn btn-primary btn-xs pull-right updatebtn2' style='margin-left: 10px;'>삭제</button>"
                                 str +="</div>"
                                 str += "</li>";
                            }
                            replyUL.append(str);        // 댓글 화면 출력
                        }
                    );
                }
            }
            lastScroll = currentScroll;
        });

</script>
<%@ include file="../includes/footer.jsp" %>