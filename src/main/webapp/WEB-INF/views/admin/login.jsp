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
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="/resources/admin/login/css/main.css">
    
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
                    <div class="container col-sm-12" id="login_box">
                        <div class="row">
                            <input type="text" class="form-control" id="normid" placeholder="ID">
                        </div>
                        <div class="row">
                            <input type="password" class="form-control" id="normpassword" placeholder="PASSWORD">
                        </div>
                        <div class="row">
                            <div class="text-right" id="submit_box">
                                <button type="submit" class="btn btn-primary" id="submit">Login</button>
                            </div>
                        </div>
                        <div class="row" id="result">
            				<ul>
                			<c:if test="${ errors.id == true }">
                    			<li>아이디가 존재하지 않습니다.</li>
                			</c:if>
                			<c:if test="${ errors.password == true }">
                    			<li>비밀번호가 맞지 않습니다.</li>
                			</c:if>
            				</ul>
        				</div>
                    </div>
                </div>
            </div>
        </div>
    </div>    
    <form id="loginform" action="/adlogin" method="post">
        <input type="hidden" id="id" name="id" />
        <input type="hidden" id="password" name="password" />
    </form>

    <script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/jsbn.js"></script>
    <script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/rsa.js"></script>
    <script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/prng4.js"></script>
    <script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/rng.js"></script>
    <script type="text/javascript" src="/resources/admin/login/js/main.js"></script>
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.js"></script>
</body>
</html>