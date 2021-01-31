<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.10/handlebars.js"></script>
    
    <link rel="stylesheet" href="/resources/admin/modify/css/main.css" />
    <title>관리자 페이지</title>
</head>
<body>
	<div id="loading">

    </div>
    <div id="top_" class="main_box">
        <div id="top_cate_">
            <div class="cate">
                <div class="text">
                    메인 카테고리 :
                </div>
                <div class="content">
                    <select id="maincate">
                        <option value="n">-------------</option>
                        <c:forEach var="maincate" items="${ maincate }">
                        <option value="${ maincate }">${ maincate }</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="cate">
                <div class="text">
                    서브 카테고리 :
                </div>
                <div class="content">
                    <select id="subcate">
                        <option value="n">-------------</option>
                    </select>
                </div>
            </div>
        </div>
        <div id="top_send_">
        	<button type="button" id="send_bt">전송버튼</button>    
        </div>
    </div>
    
    <div id="result_" class="main_box">
        <ul>
        
        </ul>
    </div>
    
    <ul id="num_list">
        
    </ul>

    <script id="result_tample" type="text/x-handlebars-template">
		{{#each .}}
        <li>
            <div id="result_field_">
                <div class="img" style="background-image:url('/file/img/{{maincate}}/{{subcate}}?filename={{thumbname}}');">
                    <input type="hidden" id="thumbname" value="{{thumbname}}" />
                    <input type="hidden" id="filename" value="{{filename}}" />
                </div>
                <div class="content_box">
                    <ul>
                        <li>
                            <div class="text">
                                - 제목 : 
                            </div>
                            <div class="content">
                                <input type="text" id="title" value="{{title}}" />
                            </div>
                        </li>
                        <li>
                            <div class="text">
                                - 내용 :
                            </div>
                            <div class="content">
                                <textarea id="context">{{context}}</textarea>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="option_bt">
                    <button type="button" id="del">삭제</button>
                    <button type="button" id="change">자리바꿈 선택</button>
                </div>
				<input type="hidden" id="c_no" value="{{no}}" />
				<input type="hidden" id="m_ch" value="n" />
            </div>
        </li>
		{{/each}}
    </script>
        
    <script id="subcate_tample" type="text/x-handlebars-template">
		<option value="n">-------------</option>
		{{#each .}}
		<option value="{{this}}">{{this}}</option>
		{{/each}}
    </script>
    
    <script id="num_list_tample" type="text/x-handlebars-template">
        {{#each .}}
        <li><input type="hidden" id="no_list" value="{{no}}" class="{{no}}" /></li>
        {{/each}}
    </script>

<script src="/resources/admin/modify/js/main.js"></script>
</body>
</html>
