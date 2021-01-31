<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
	<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.10/handlebars.js"></script>
    <link rel="stylesheet" href="/resources/admin/message/css/main.css" type="text/css" />
    <link rel="stylesheet" href="/resources/admin/message/css/popup.css" type="text/css" />
    <title>관리자 페이지</title>
</head>
<body>
	<div id="loading">

    </div>
    
    <div class="cont">
        <div class="outer">
            <div class="inner">
                <div class="centered">
                    <div class="container col-sm-12" id="login_box">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th width="5%">No.</th>
                                    <th width="15%">Name</th>
                                    <th width="50%">Message</th>
                                    <th width="30%">Date</th>
                                </tr>
                            </thead>
                            <tbody id="list">
                                <c:forEach var="list" items="${ msglist }">
                                    <tr>
                                    	<td id="num">${ list.no }</td>
                                        <td id="name">${ list.name }</td>
                                        <td id="message"><a href="${ list.no }">${ list.message }</a></td>
                                        <td id="date">${ list.regdate }
                                            <div>
                                                <input type="hidden" id="h_name" class="${ list.no }" value="${ list.name }" />
                                                <input type="hidden" id="h_email" class="${ list.no }" value="${ list.email }" />
                                                <input type="hidden" id="h_message" class="${ list.no }" value="${ list.message }" />
                                                <input type="hidden" id="h_regdate" class="${ list.no }" value="${ list.regdate }" />
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <nav>
                            <ul class="pagination">
                                <c:if test="${ page.prevGroup == true }">
                                <li><a href="/ad/ml/${ page.beginPage - page.numOfLine }" aria-label="Previous">
                        				<span aria-hidden="true">&laquo;</span>
                        			</a></li>
                    			</c:if>
                    			
                    			
                                <c:forEach var="pageNo" begin="${ page.beginPage }" end="${ page.endPage }">
                        			<c:if test="${ pageNo == page.currentPage }">
                            			<li class="active"><a href="/ad/ml/${ pageNo }">${ pageNo }</a></li>
                        			</c:if>
                        			<c:if test="${ pageNo != page.currentPage }">
                            			<li><a href="/ad/ml/${ pageNo }">${ pageNo }</a></li>
                        			</c:if>
                    			</c:forEach>
                    			
                    			<c:if test="${ page.nextGroup == true }">
                    				<li><a href="/ad/ml/${ page.endPage + 1 }" aria-label="Next">
                                        	<span aria-hidden="true">&raquo;</span>
                                    	</a></li>
                    			</c:if>
                                
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
   
	<div id="content_board">
        <div class="outter_1">
            <div class="inner_1">
                <div id="content_box" class="panel panel-primary">

                    <div class="panel-heading">
                        <table id="heading">
                            <tr>
                                <td width="90%" style="text-align:left;">
                                Message
                                </td>
                                <td width="10%" style="text-align:right;">
                                    <button id="exit_button" type="button" class="btn btn-default" aria-label="Left Align">
                                        <i class="fa fa-times" aria-hidden="true"></i>
                                    </button>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="container">
                        <div class="row" style="height:30px;">
                            <div class="col-sm-6" id="con_no">

                            </div>
                            <div class="col-sm-6" id="con_date">

                            </div>
                        </div>

                        <div class="row" style="height:30px;">
                            <div class="col-sm-6" id="con_name">

                            </div>
                            <div class="col-sm-6" id="con_email">

                            </div>
                        </div>

                        <div class="row" style="height:120px;">
                            <div class="col-sm-12">
                                <textarea id="text_read" readonly></textarea>
                            </div>
                        </div>

                        <div class="row" style="height:80px;">
                            <div class="col-sm-10">
                                <textarea id="text_write"></textarea>
                            </div>
                            <div class="col-sm-2">
                                <button class="btn btn-default" id="send_button">Send</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!--
    <div id="content_board">
        <div class="outter_1">
            <div class="inner_1">
                <div id="content_box">
                    <ul>
                        <li class="small_li">
                            <div id="con_no" class="con_info"></div>
                            <div id="exit"><button id="exit_button">X</button></div>
                            <div id="con_date" class="con_info"></div>
                        </li>
                        <li class="small_li">
                            <div id="con_name" class="con_info"></div>
                            <div id="con_email" class="con_info"></div>
                        </li>
                        <li class="message_li">
                            <div id="con_message">
                                <textarea id="text_read" readonly></textarea>
                            </div>
                        </li>
                        <li class="message_li">
                            <div id="send_box">
                                <div id="con_send_message">
                                    <textarea id="text_write"></textarea>
                                </div>
                                <div id="send">
                                <button id="send_button">Send</button>
                                
                                	<c:if test="${ admin.authority == 'guest' }">
                                        <button id="no_action">No Action</button>
                                    </c:if>
                                    <c:if test="${ admin.authority == 'super' }">
                                        
                                    </c:if>  
                                    
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    -->
    
    <script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/jsbn.js"></script>
    <script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/rsa.js"></script>
    <script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/prng4.js"></script>
    <script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/rng.js"></script>
    <script src="/resources/admin/message/js/main.js"></script>
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.js"></script>
</body>
</html>