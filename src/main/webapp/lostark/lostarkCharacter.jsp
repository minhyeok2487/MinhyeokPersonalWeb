<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="../common/header.jsp" %>
<div class="text">로스트아크 > 내 캐릭터(${mainCharacter})</div>
<div class="lostark wrap">
    <div class="lostark-character">
        <c:forEach var="character" items="${characters}">
        <div class="lostark-character-wrap">
            <div class="lostark-character-image">
                <img src="${character.characterImage}">
            </div>
            <div class="lostark-character-text">
                <div class="lostark-character-textbox" style="background: #695CFE;">
                    <p>${character.characterName}</p>
                    <p>캐릭터 클래스 : ${character.characterClassName}</p>
                    <p>아이템 레벨 : ${character.itemMaxLevel}</p>
                </div>
                <div class="lostark-character-textbox" style="background: #FA8072;">
                    <p>카오스 던전 : ${character.chaosName}</p>
                    <p>가디언 토벌 : ${character.guardianName}</p>
                    <p>카오스 던전 휴게 : 개발중</p>
                    <p>가디언 토벌 휴게 : 개발중</p>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>

<%@include file="../common/footer.jsp" %>