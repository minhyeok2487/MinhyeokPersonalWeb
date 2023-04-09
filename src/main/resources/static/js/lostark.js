function saveMarketData(categoryCode) {
    $.ajax({
        type : "GET",
        url : "/lostark/api/saveMarketData/"+categoryCode,
        success : function(res){
            // 응답코드 > 0000
            console.log(res);
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("통신 실패.")
        }
    });
}