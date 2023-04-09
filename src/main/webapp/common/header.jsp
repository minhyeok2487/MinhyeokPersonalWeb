<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 제이쿼리 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- CSS -->
    <link rel="stylesheet" href="css/index.css">
    <!-- Boxicons CSS -->
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Minhyeok Personal Web</title>
</head>
<body>
<nav class="sidebar">
    <header>
        <div class="image-text">
				<span class="image">
					<img src="resources/logo.png" alt="logo">
				</span>

            <div class="text header-text">
                <span class="name">Minhyeok</span>
                <span class="profession">Personal Web</span>
            </div>
        </div>
        <i class="bx bx-chevron-right toggle"></i>
    </header>
    <div class="menu-bar">
        <div class="menu">
            <li class="search-box">
                <i class="bx bx-search icon"></i>
                <input id="igdb_id" type="text" placeholder="IGDB ID Search..." onkeyup="enterKey();"/>
            </li>
            <ul class="menu-links">
                <li class="nav-link">
                    <a href="/lostark">
                        <img class="img-icon" src="resources/lostark_icon.jpeg" alt="lostark_icon">
                        <span class="text nav-text">로스트아크</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="/restaurant">
                        <i class='bx bx-food-menu icon'></i>
                        <span class="text nav-text">점심식사</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="">
                        <i class="bx bx-bar-chart-alt-2 icon"></i>
                        <span class="text nav-text">Chart</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="">
                        <i class="bx bx-bell icon"></i>
                        <span class="text nav-text">Notifications</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="">
                        <i class="bx bx-pie-chart-alt icon"></i>
                        <span class="text nav-text">Analytics</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="">
                        <i class="bx bx-heart icon"></i>
                        <span class="text nav-text">Likes</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="">
                        <i class='bx bx-data icon'></i>
                        <span class="text nav-text">Datas</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="bottom-content">
            <!--
            <li class="">
                <a href="">
                    <i class="bx bx-log-out icon"></i>
                    <span class="text nav-text">Logout</span>
                </a>
            </li>
            -->
            <li class="mode">
                <div class="moon-sun">
                    <i class="bx bx-moon icon moon"></i>
                    <i class="bx bx-sun icon sun"></i>
                </div>
                <span class="mode-text text">Dark Mode</span>
                <div class="toggle-switch">
                    <span class="switch"></span>
                </div>
            </li>
        </div>
    </div>
</nav>
<section class="home">