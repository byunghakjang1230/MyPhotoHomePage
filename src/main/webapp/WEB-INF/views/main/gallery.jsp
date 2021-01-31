<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<!--
	Lens by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Lens by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="/resources/gallery/assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="/resources/gallery/assets/css/main.css" />
		<link rel="stylesheet" href="/resources/gallery/assets/css/custom.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="/resources/gallery/assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="/resources/gallery/assets/css/ie9.css" /><![endif]-->
		<noscript><link rel="stylesheet" href="/resources/gallery/assets/css/noscript.css" /></noscript>
		
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Dancing+Script|Crimson+Text|Dosis|Fira+Sans|Noto+Serif|Playfair+Display" />
	</head>

	<body class="is-loading-0 is-loading-1 is-loading-2">
       
		<!-- Main -->
			<div id="main">

				<!-- Header -->
					<header id="header" class="top">
                        <div id="menu_">
                            <ul>
                                <li class="li_bt_menu_">
                                    <div id="bt_menu">
                                        <a href="#" class="drop_menu_bt"><i class="fa fa-bars" aria-hidden="true"></i></a>
                                    </div>                                
                                </li>
                                <li class="li_drop_menu_">
                                    <div id="drop_menu" class="basic_menu">
                                        <ul>
                                            <li><div class="_top_menu"><a href="/">home</a></div></li>
                                            <li><div class="_top_menu"><a href="/pf">portfolio</a></div></li>
                                            <li><div class="_top_menu"><a href="/gm/main">gallery</a></div></li>
                                            <li><div class="_top_menu"><a href="/ct">contact</a></div></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
						<h1 id="main_cate_">${ maincate }</h1>
						<p id="sub_cate_">${ subcate }</p>
						<ul class="icons">
                            <!--
                            <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>    
                            <li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
                            -->
							<li><a href="http://www.instagram.com/hilu03180" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="mailto:byunghak.photo.1230@gmail.com" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
						</ul>
					</header>
                   
				<!-- Thumbnail -->
				<section id="thumbnails">
				<c:forEach var="list" items="${ photolist }">
						<article>
							<a class="thumbnail" href="/file/img/${ list.maincate }/${ list.subcate }?filename=${ list.filename }">
								<img src="/file/img/${ list.maincate }/${ list.subcate }?filename=${ list.thumbname }" alt="" />
							</a>
							<h2>${ list.title }</h2>
							<p>${ list.context }</p>
						</article>
				</c:forEach>
				</section>
				<!-- Footer -->
					<footer id="footer">
						<ul class="copyright">
							<li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a>.</li>
						</ul>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="/resources/gallery/assets/js/jquery.min.js"></script>
			<script src="/resources/gallery/assets/js/skel.min.js"></script>
			<!--[if lte IE 8]><script src="/resources/gallery/assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="/resources/gallery/assets/js/main.js"></script>
			<script src="/resources/gallery/assets/js/custom.js"></script>
			
	</body>
</html>