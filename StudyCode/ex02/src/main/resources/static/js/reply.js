console.log('Reply Module...');

var replyService = (function() {
//    return { name: "AAAA" };

    // 댓글 등록 ajax 호출함수
    function replyAdd(reply, callback, error) {
        $.ajax({
            //request처리
            type : 'post',                                      // form의 method속성 값
            url : '/replies/new',                               // form의 action값
            data : JSON.stringify(reply),                       // json으로 string처리
            contentType : "application/json; charset=utf-8",    // content-type지정
            //response처리
            success : function(result, status, xhr) {           // call 성공시 오는 처리되는 함수
                if (callback) {
                    callback(result);
                }
            },
            error : function(xhr, status, er) {                 // call 실패시 오는 처리되는 함수
                if (error) {
                    error(er);
                }
            }
        });
    }

    //댓글 조회
    function getList(param, callback, error){
        var bno = param.bno;
        var page = param.page || 1;
        $.getJSON("/replies/board/"+bno+"/page/"+page+"/pagesize/3",
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

    //댓글 삭제
    function remove(rno,callback,error){
        $.ajax({
            type:'delete',
            url:'/replies/'+rno,
            success:function(deleteResult, status, xhr){
                if(callback){
                    callback(deleteResult);
                }
            },
            error:function(xhr,status,er){
                if(error){
                    error(er);
                }
            }
        });
    }

    //댓글 수정
    function update(reply,callback,error){
        console.log("RNO: "+reply.rno);

        $.ajax({
            type:'put',
            url:'/replies/'+reply.rno,
            data:JSON.stringify(reply),
            contentType:"application/json; charset=utf-8",
            success:function(result,status,xhr){
                if(callback){
                    callback(result);
                }
            },
            error:function(xhr,status,er){
                if(error){
                    error(er);
                }
            }
        });
    }

    //댓글 상세 조회
    function get(rno, callback,error){
        $.get("/replies/"+rno,function(result){
            if(callback){
                callback(result);
            }
        }).fail(function(xhr,status,err){
            if(error){
                error();
            }
        });
    }

    function displayTime(timeValue) {
            var today = new Date(); //현재 날짜 및 시간
            var replyDate =  new Date(timeValue); //년 월 일 시 분 초
            var replyDateTime = replyDate.getTime();

            var gap = today.getTime() - replyDateTime;
    		var dateObj = new Date(replyDateTime);
    		var str = "";
    		if (gap < (1000 * 60 * 60 * 24)) {
    			var hh = dateObj.getHours();
    			var mi = dateObj.getMinutes();
    			var ss = dateObj.getSeconds();

    			return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi,
    					':', (ss > 9 ? '' : '0') + ss ].join('');
    		} else {
    			var yy = dateObj.getFullYear();
    			var mm = dateObj.getMonth() + 1; // getMonth() is zero-based
    			var dd = dateObj.getDate();

    			return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/',
    					(dd > 9 ? '' : '0') + dd ].join('');
    		}
        }

    return {
        add: replyAdd,
        getList:getList,
        remove:remove,
        update:update,
        get:get,
        displayTime:displayTime
    };       // replyAdd function의 내용이 나옴
})();