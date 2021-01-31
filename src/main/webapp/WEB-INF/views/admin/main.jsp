<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	response.setHeader("Cache-Control", "no-cache");    
	response.addHeader( "Cache-Control", "no-store"); 
	response.setHeader("Pragma", "no-cache"); 
	response.setDateHeader("Expire", 1L); 
%>
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/jejugothic.css">
    <link rel="stylesheet" href="/resources/admin/main/css/main.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css" />
    

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.10/handlebars.js"></script>
    
    <title>관리자 페이지</title>
</head>
<body>
	<div class="cont">
        <div class="outer">
            <div class="inner">
                <div class="centered">
					<div class="list-group col-sm-12" id="main_box">
  						<a href="/ad/rp" class="list-group-item">사진 등록</a>
  						<a href="/ad/mp" class="list-group-item">사진 수정</a>
  						<a href="/ad/vv" class="list-group-item">방문자 통계</a>
  						<a href="/ad/ml" class="list-group-item">메시지 관리</a>
  						<a href="/ad/logout" class="list-group-item">로그아웃</a>
					</div>                                        
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.js"></script>
</body>
</html>