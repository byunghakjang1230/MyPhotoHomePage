<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>관리자 페이지</title>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
	<link rel="stylesheet" href="/resources/admin/viewvisiter/css/main.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.10/handlebars.js"></script>
    
</head>
<body>
    <div id="title_box">
        방문자 현황
    </div>
    <div id="visiter_count">
        <ul>
            <li>
                <div class="list_box">
                    <div id="today" class="visit_box">
                        <div id="chart">

                        </div>
                    </div>
                    <div id="month" class="visit_box">
                        <div id="chart">

                        </div>
                    </div>
                </div>                
            </li>
            <li>
                <div class="list_box">
                    <div id="year" class="visit_box">
                        <div id="chart">

                        </div>
                    </div>
                    <div id="total" class="visit_box">
                        <div id="chart">

                        </div>
                    </div>
                </div>                
            </li>
        </ul>
    </div>
    <div id="map">

    </div>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="/resources/admin/viewvisiter/js/main.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBsq7zXwLco2xIOT7vLSCUju_W3vIQWjx4&callback=initMap"
            async defer></script>
	
</body>
</html>