<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<!--
	Dimension by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>ByungHakPhoto</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="shortcut icon" href="/resources/image/favicon.ico">
		<link rel="stylesheet" href="/resources/dimension/assets/css/main.css" />
		<link rel="stylesheet" href="/resources/dimension/assets/css/custom.css" />
		
		<!--[if lte IE 9]><link rel="stylesheet" href="/resources/dimension/assets/css/ie9.css" /><![endif]-->
		<noscript><link rel="stylesheet" href="/resources/dimension/assets/css/noscript.css" /></noscript>
		
		
	</head>
	<body>

        <style>
            
        </style>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<div class="logo">
							<span class="icon fa-camera-retro" aria-hidden="true"></span>
						</div>
						<div class="content">
							<div class="inner">
								<h1>ByungHak's Place</h1>  
								<!-- 여기다가 문구넣기.
                                <p>A fully responsive site template designed by <a href="https://html5up.net">HTML5 UP</a> and released<br />
								for free under the <a href="https://html5up.net/license">Creative Commons</a> license.</p>
                                    -->
							</div>
						</div>
						<nav>
							<ul>
								<li><a href="#intro">Intro</a></li>
                                <li><a class="linktopf" href="/pf">Portfolio</a></li>
                                <li><a class="linktogm" href="/gm/main">Gallery</a></li>
                                <li><a href="/ct">About</a></li>

                                <!--
								<li><a href="#work">Work</a></li>
								<li><a href="#about">About</a></li>
								<li><a href="#contact">Contact</a></li>
								<li><a href="#elements">Elements</a></li>
								-->
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<div id="main">

						<!-- Intro -->
							<article id="intro">
								<h2 class="major">Hello</h2>
								<span class="image main"><img src="/resources/dimension/images/pic01.jpg" alt="" /></span>
								<p>이곳은 취미로 촬영한 사진을 올리는 곳인 동시에 웹 개발 포트폴리오로 사용하기 위한 홈페이지 입니다.</p>
								<p>여행을 다니며, 일상을 지내며 찍은 사진들입니다.</p>
								<p>홈페이지의 모든 디자인은<a href="https://html5up.net">HTML5 UP</a>에서 만들어 무료로 제공되는 소스를 사용하였으며 필요하신 분들이 계시다면 <a href="https://html5up.net">HTML5 UP</a>사이트를 이용 해 주시기 바랍니다.</p>
								<p>그럼 즐거운시간 되시길...go to <a href="/gm"> Galley</a></p>
							</article>

						<!-- Contact 
							<article id="contact">
								<h2 class="major">Contact</h2>
								<form method="post" action="#">
									<div class="field half first">
										<label for="name">Name</label>
										<input type="text" name="name" id="name" class="in_d"/>
									</div>
									<div class="field half">
										<label for="email">Email</label>
										<input type="text" name="email" id="email"  class="in_d"/>
									</div>
									<div class="field">
										<label for="message">Message</label>
										<textarea name="message" id="message" rows="4"  class="in_d"></textarea>
									</div>
									<ul class="actions">
										<li><input type="submit" id="submit_bt" value="Send Message" class="special" /></li>
										<li><input type="reset" value="Reset" /></li>
									</ul>
								</form>
								<ul class="icons">
								<!--
								<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
								  
									
									<li><a href="mailto:byunghak.photo.1230@gmail.com" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
									<li><a href="http://www.instagram.com/hilu03180" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
									
								</ul>
							</article>-->

					</div>

				<!-- Footer -->
					<footer id="footer">
						<p class="copyright">&copy; Untitled. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
					</footer>

			</div>

		<!-- BG -->
			<div id="bg"></div>
        	<div id="bg_list">
        		<c:forEach var="list" items="${ bgimglist }">
        			<input type="hidden" id="bg_url" value="/file/img/main_bgimg/etc?filename=${ list }" />
        		</c:forEach>
        	</div>
        	
        <!-- RSA Scripts -->
        	<script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/jsbn.js"></script>
    		<script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/rsa.js"></script>
    		<script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/prng4.js"></script>
    		<script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/rng.js"></script>
		<!-- Scripts -->
			<script src="/resources/dimension/assets/js/jquery.min.js"></script>
			<script src="/resources/dimension/assets/js/skel.min.js"></script>
			<script src="/resources/dimension/assets/js/util.js"></script>
			<script src="/resources/dimension/assets/js/main.js"></script>
			<script src="/resources/dimension/assets/js/custom.js"></script>
			
			
	</body>
</html>

