<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<!--
	Astral by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Astral by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="/resources/contact/assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="/resources/contact/assets/css/main.css" />
		<link rel="stylesheet" href="/resources/contact/assets/css/custom.css" />
		<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/kopubbatang.css" />
		<noscript><link rel="stylesheet" href="/resources/contact/assets/css/noscript.css" /></noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="/resources/contact/assets/css/ie8.css" /><![endif]-->

        <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.10/handlebars.js"></script>
	</head>
	<body>

		<!-- Wrapper-->
			<div id="wrapper">

				<!-- Nav -->
					<nav id="nav">
						<a href="#me" id="home_" class="icon fa-home active"><span>Home</span></a>
                        <a href="#info" id="insta_" class="icon fa-info-circle"><span>Info</span></a>
						<a href="#contact" id="conteact_" class="icon fa-envelope"><span>Contact</span></a>							
					</nav>

				<!-- Main -->
					<div id="main">

						<!-- Me -->
							<article id="me" class="panel">
								<header>
									<h1 class="korea_len">Byunghak.</h1>
									<p class="korea_len" style="font-size:20px;">
                                        Actually, I'm a programmer. :) <br />
                                        want to go Home? <a href="/" style="text-decoration:none; color:darkgray; border-bottom: 1px dashed darkgray; ">Here</a>
                                    </p>
								</header>
								<a href="#info" class="jumplink pic">
									<span class="arrow icon fa-chevron-right"><span>See my work</span></span>
									<img src="/resources/contact/images/me.jpg" alt="" />
								</a>
							</article>

						<!-- Work -->
							<article id="info" class="panel">
								<header>
                                <h2>...</h2>
                            	</header>
                  		        <p class="korea_len">
                  	              	소소한 취미생활..<br /><br />
                 	                #여행 #하늘 #구름 #일상 #노을 #풍경<br />
									대한민국 서울에 거주중<br />
                        	    </p>
                            	<p class="korea_len">
        	                        #travel #sky #clouds #daily #sunset #scenery<br />
            	                    in Seoul, South Korea.<br />
	                            </p>
    	                        <p class="korea_len">
                                	contact me :<br />
	                                <a href="mailto:byunghak.photo.1230@gmail.com" style="text-decoration:none; color:#808080; border-bottom:1px dashed #808080;">byunghak.photo.1230@gmail.com</a> or 
    	                            <a href="#contact" style="text-decoration:none; color:#808080; border-bottom:1px dashed #808080;" class="jumplink pic">Message.</a>
        	                    </p>
                            	<p style="font-size:13px;" class="korea_len">
 		                               	궁금한 점이나 문의사항은 홈페이지에 메시지를 남기거나 이메일을 남겨주시면 감사하겠습니다. :)<br />
 		                               	※홈페이지의 모든 디자인은 <a href="https://html5up.net" target="_blank" style="text-decoration:none; color:black; border-bottom:1px dotted black;">HTML5 UP</a>에서 만들었음을 알립니다.
                            	</p>
                            	<header>
                                <h2>Instagram</h2>
                            	</header>
								<section>
									<div class="row">
                                        
										
									</div>
								</section>
							</article>

						<!-- Contact -->
							<article id="contact" class="panel">
								<header>
									<h2>Contact Me</h2>
								</header>
								<form action="#" method="post">
									<div>
										<div class="row">
											<div class="6u 12u$(mobile)">
												<input type="text" id="name_" class="in_d" name="name" placeholder="Name" />
											</div>
											<div class="6u$ 12u$(mobile)">
												<input type="email" id="email_" class="in_d" name="email" placeholder="Email" />
											</div>
											<div class="12u$">
												<textarea name="message" id="message_" class="in_d" placeholder="Message" rows="8"></textarea>
											</div>
											<div class="12u$">
												<input id="submit_bt" type="submit" value="Send Message" />
											</div>
										</div>
									</div>
								</form>
							</article>

					</div>

				<!-- Footer -->
					<div id="footer">
						<ul class="copyright">
							<li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
						</ul>
					</div>

			</div>

        <script id="insta_tample" type="text/x-handlebars-template">
            {{#each .}}
            <div class="4u 12u$(mobile)">
                <a href="{{link}}" target="_blank" class="image fit"><img src="{{url}}" alt=""></a>
            </div>
            {{/each}}
        </script>
        
        <!-- RSA Scripts -->
        	<script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/jsbn.js"></script>
    		<script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/rsa.js"></script>
    		<script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/prng4.js"></script>
    		<script type="text/javascript" src="http://www-cs-students.stanford.edu/~tjw/jsbn/rng.js"></script>
    		
		<!-- Scripts -->
			<script src="/resources/contact/assets/js/jquery.min.js"></script>
			<script src="/resources/contact/assets/js/skel.min.js"></script>
			<script src="/resources/contact/assets/js/skel-viewport.min.js"></script>
			<script src="/resources/contact/assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="/resources/contact/assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="/resources/contact/assets/js/main.js"></script>
			<script src="/resources/contact/assets/js/custom.js"></script>
        
	</body>
</html>