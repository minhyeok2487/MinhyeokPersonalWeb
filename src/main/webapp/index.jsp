<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="common/header.jsp" %>
<div class="text">Dashboard</div>
<div class="dashboard wrap">
    <div class="dashboard text-box">
        <strong>2023.02.26 IGDB 검색</strong>
        <p>igdb api 연습</p>
    </div>
    <div class="dashboard text-box">
        <strong>2023.03.01 IGDB 검색</strong>
        <p>링크 검색 기능 추가(미완성)</p>
    </div>
    <div class="dashboard text-box">
        <strong>2023.03.05 IGDB 검색</strong>
        <p>출력 방식 변경으로 링크 버그 해결, 삭제 버튼 추가</p>
        <p>(단, 새로고침시 출력된 내용 전체 삭제됨)</p>
    </div>
    <div class="dashboard text-box">
        <strong>2023.03.18 IGDB 검색</strong>
        <p>검색시 IGDB와 구글 검색사이트가 자동으로 동시 열림</p>
        <p>(기존 방식으로 자잘한 버그가 계속 생겨 방식 수정)</p>
    </div>
    <div class="dashboard text-box">
        <strong>2023.03.19 점심식사</strong>
        <p>kakao map api 연습(테스트 데이터 10개)</p>
    </div>
    <div class="dashboard text-box">
        <strong>2023.03.26 점심식사</strong>
        <li>mariadb연동</li>
        <li>데이터 불러오는 과정 수정(ajax호출)</li>
        <li>데이터 수정 기능 추가(X, Y 입력시 자동으로 포인트 생성)</li>
    </div>
    <div class="dashboard text-box">
        <strong>2023.04.08 CSS 작업, IGDB 검색 수정</strong>
        <li>사이드바 추가(메뉴 그냥 채우기용도)</li>
        <li>ID 검색시 IGDB 사이트만 열리게 수정 (굳이 다른 사이트 열릴 필요가 없어보여서 제거)</li>
    </div>
    <div class="dashboard text-box">
        <strong>2023.04.09 로스트아크 작업</strong>
        <p>재련재료 데이터 자정에 API로 불러와서 DB에 저장</p>
        <p>(기존에 데이터가 있으면 데이터 갱신)</p>
    </div>
    <div class="dashboard text-box">
        <strong>2023.04.16 IGDB 작업</strong>
        <p>id 여러개 입력시(엑셀상 id 세로로 드래그) => 여러개 열림</p>
        <p>Related Content 크롤링 => 실패</p>
    </div>
    <div class="dashboard text-box">
        <strong>2023.04.22 로스트아크 작업</strong>
        <p>일일컨텐츠 수확 비교 테이블 출력</p>
        <p>jsp는 jar배포를 지원하고 있지 않아 다른 템플릿 엔진으로 바꿔야함...</p>
    </div>
</div>
<%@include file="common/footer.jsp" %>