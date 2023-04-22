<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="../common/header.jsp" %>
<div class="text">로스트아크</div>
<div class="lostark wrap">
    <div class="lostark-wrap">
        <div class="lostark-wrap text-box">
            <strong>재련재료 데이터</strong><br>
            <p>6시간 간격으로 재련재료 데이터 자동 저장</p>
        </div>
        <div class="lostark-table-wrap">
            <table class="lostark-table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">이름</th>
                    <th scope="col">구분</th>
                    <th scope="col">묶음</th>
                    <th scope="col">전일 평균가</th>
                    <th scope="col">현재 가격</th>
                    <th scope="col">최근 최저가</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="marketItem" items="${marketItems}">
                    <tr id="${marketItem.id}">
                        <th scope="row"><img src="${marketItem.icon}" alt="${marketItem.name}"></th>
                        <td>${marketItem.name}</td>
                        <td>${marketItem.grade}</td>
                        <td>${marketItem.bundleCount}</td>
                        <td>${marketItem.YDayAvgPrice}</td>
                        <td>${marketItem.recentPrice}</td>
                        <td>${marketItem.currentMinPrice}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="lostark-wrap">
        <div class="lostark-wrap text-box">
            <strong>일일컨텐츠 수익</strong>
            <p>카오스 던전 : 파괴석, 수호석, 보석, 골드(골드&보스방)</p>
            <p>가디언 토벌 : 파괴석, 수호석, 돌파석</p>
        </div>
        <div class="lostark-table-wrap">
            <table class="lostark-table">
                <thead>
                <tr>
                    <th scope="col">레벨</th>
                    <th scope="col">이름</th>
                    <th scope="col">분류</th>
                    <th scope="col">1수 수익</th>
                    <th scope="col">2수 수익(휴게 1수)</th>
                    <th scope="col">휴게 2수 수익</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="contentAvg" items="${contentAvg}">
                    <tr>
                        <th scope="row">${contentAvg.level}</th>
                        <td>${contentAvg.name}</td>
                        <td>${contentAvg.category}</td>
                        <td>${contentAvg.availablePrice}</td>
                        <td>${contentAvg.availablePrice * 2}</td>
                        <td>${contentAvg.availablePrice * 4}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="lostark-wrap">
        <div class="lostark-wrap text-box">
            <strong>일일컨텐츠 수익</strong>
            <p>카오스 던전 : 파괴석, 수호석, 보석, 골드(골드&보스방)</p>
            <p>가디언 토벌 : 파괴석, 수호석, 돌파석</p>
        </div>
        <div class="lostark-table-wrap">
            <table class="lostark-table">
                <thead>
                <tr>
                    <th scope="col">레벨</th>
                    <th scope="col">이름</th>
                    <th scope="col">분류</th>
                    <th scope="col">수익</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="contentAvgTotal" items="${contentAvgTotal}">
                    <tr>
                        <th scope="row">${contentAvgTotal.level}</th>
                        <td>${contentAvgTotal.name}</td>
                        <td>${contentAvgTotal.category}</td>
                        <td>${contentAvgTotal.availablePrice}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../common/footer.jsp" %>