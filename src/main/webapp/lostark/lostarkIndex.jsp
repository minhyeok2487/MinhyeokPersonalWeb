<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/header.jsp" %>
<div class="text">로스트아크</div>
<div class="lostark wrap">
    <div class="lostark text-box">
        <strong>재련재료 데이터</strong>
        <p>매일 자정 재련재료 데이터 자동 저장</p>
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
<%@include file="../common/footer.jsp" %>