<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/header.jsp" %>
<div class="text">점식식사 지도(판교)</div>
<div class="restaurant wrap">
    <div class="restaurant-map" id="map"></div>
    <div class="restaurant-table-wrap">
        <table class="restaurant-table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">이름</th>
                <th scope="col">구분</th>
                <th scope="col">메뉴</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="data" items="${data}">
            <tr id="${data.id}">
                <th scope="row">${data.id}</th>
                <td>${data.name}</td>
                <td>${data.category}</td>
                <td>${data.menu}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f3c36353159681ee258a746648ee5f2&libraries=services"></script>
<script type="text/javascript">

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(37.4003521, 127.1107886), // 지도의 중심좌표
            level: 4 // 지도의 확대 레벨
        };

    // 지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);

    // 인포윈도우에 들어갈 데이터 생성
    var positions = [];
    $.ajax({
        type:"GET",
        url: "api/restaurant",
        dataType:"json",
        async:false,
        success:function(res){
            for(var i=0; i<res.data.length; i++) {
                var position = {};
                position.content = res.data[i].content;
                position.latlng = new kakao.maps.LatLng(res.data[i].y, res.data[i].x);
                position.id = res.data[i].id;
                positions.push(position);
            }
        },
        error:function(e){
            alert(e);
        }
    });

    // 인포윈도우 생성
    var infowindows = [];
    for (var i = 0; i < positions.length; i ++) {
        var marker = new kakao.maps.Marker({
            map: map,
            position: positions[i].latlng
        });

        var infowindow = new kakao.maps.InfoWindow({
            content: positions[i].content,
        });

        var element = document.getElementById(positions[i].id);
        element.addEventListener("click", makeBtnEvent(map, marker, infowindow));
    }

    function makeBtnEvent(map, marker, infowindow) {
        return function() {
            if(infowindows.length > 0) {
                infowindows[0].close();
            }
            infowindows[0]= infowindow;
            infowindows[0].open(map, marker);
        };
    }

    function editData(id) {
        $.ajax({
            type:"POST",
            url: "api/restaurant/editData/"+id,
            dataType:"json",
            success:function(res){
                console.log(res)
            },
            error:function(e){
                alert(e);
            }
        });
    }
</script>
<%@include file="../common/footer.jsp" %>