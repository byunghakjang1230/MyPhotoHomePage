<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<!--
	Spectral by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>WEB PORTFOLIO</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="/resources/webpf/assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="/resources/webpf/assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="/resources/webpf/assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="/resources/webpf/assets/css/ie9.css" /><![endif]-->
	</head>
	<body class="landing">

		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Header -->
					<header id="header" class="alt">
						<h1><a href="index.html">Portfolio</a></h1>
						<nav id="nav">
							<ul>
								<li class="special">
									<a href="#menu" class="menuToggle"><span>Menu</span></a>
									<div id="menu">
										<ul>
											<li><a href="/">Home</a></li>
											<li><a href="/adlogin">Log In</a></li>
										</ul>
									</div>
								</li>
							</ul>
						</nav>
					</header>

				<!-- Banner -->
					<section id="banner">
						<div class="inner">
							<h2>포트 폴리오 페이지</h2>
						</div>
						<a href="#one" class="more scrolly">Learn More</a>
					</section>

				<!-- One -->
					<section id="one" class="wrapper style1 special">
						<div class="inner">
							<header class="major">
								<h2>프로젝트 소개</h2>
								<p>
                                홈페이지의 사진을 관리자 페이지를 통해서 작가가 직접 사진 업로드 밋 수정, 삭제.<br />
								방문자 위치정보를 저장하고 조회페이지에서 통계 및 접속 지역을 표시.<br />
                                RESTFull 방식의 데이터 전송구현.<br />
                                BigIntegers and RSA in JavaScript 라이브러리를 사용하여 데이터 암호화 전송<br />
                                사용한 API - ip-api, instagram-api, googlemap-api <br />
                                ※실제 접속자수가 많지 않아 더미데이터를 사용하여 얻은 결과를 사진으로 첨부하였습니다.
                                </p>
                                <p>
                                    게스트로 로그인 하면 관리자 페이지를 둘러볼 수 있습니다.<br />(일부 기능은 제한됩니다.)<br />
                                    ID: guest<br />
                                    PW: guest<br />
                                </p>
							</header>
						</div>
					</section>

				<!-- Two -->
					<section id="two" class="wrapper alt style2">
                        <section class="spotlight">
                            <div class="image"><img src="/resources/webpf/images/api_.jpg" alt="" /></div><div class="content">
                                <h2>
                                    서버에서 외부 API와 통신 <br />
                                </h2>
                                <p>
                                    IP-API와 Instagram-API는 각각 IP주소와 사용자 계정으로 승인을 받아 얻게된 토큰을 파라미터값으로 하여 데이터를 전송받게 됩니다. HTML페이지에서 API에 접근을 하게 되면 이러한 정보가 노출되기에 HttpClient를 사용하여 서버에서 직접 외부 API와 통신하고 전송받은 데이터를 가공한 후 필요한 경우 다시 HTML페이지로 결과를 전송합니다.<br /> 
                                </p>
                            </div>
                        </section>
                        <section class="spotlight">
                            <div class="image"><img src="/resources/webpf/images/gooleMap.jpg" alt="" /></div><div class="content">
                                <h2>
                                    API를 사용한 방문자 정보 시각화
                                </h2>
                                <p>
                                    IP-API와 HttpClient, Gson을 사용하여 방문자 정보를 데이터베이스 자료구조에 맞게 가공한 뒤 저장하게 되고, 이 데이터를 바탕으로하여 구글맵 API및 구글차트를 사용하여 방문자 정보를 시각화 하였습니다.<br />
                                    방문자가 최초로 홈페이지에 접속 시 IP정보를 수집합니다. 수집된 IP주소로 IP-API를 사용하여 사용자의 접속 지역과 나라 등의 정보를 추가적으로 전송 받는데 이때, 서버 내에서 HttpClient 클래스를 사용하여 방문자 접속정보를 JSON형태의 문자열 데이터로 받게 됩니다.(계속..)
                                </p>
                            </div>
                        </section>
                        <section class="spotlight">
                            <div class="image"><img src="/resources/webpf/images/goolechart.jpg" alt="" /></div><div class="content">
                                <p>
                                    받은 문자열 데이터를 Gson을 사용하여 객체로 변환한 뒤 비지니스계층을 통해 데이터베이스로 데이터를 전달하게 됩니다. 이렇게 저장 된 데이터 중 위도와 경도를 사용하여 구글맵에 방문자 접속위치 마커로 표시합니다. 
                                    그리고 Select문으로 검색하여 얻게된 나라이름과 나라이름별 데이터의 개수를 구글차트를 이용하여 도표로 표시합니다. 필요한 데이터는 데이터베이스에 저장되어 있는 상태에서 관리자가 페이지 접속 시 ajax통신으로 데이터를 받아오게됩니다.
                                </p>
                            </div>
                        </section>
                        <section class="spotlight">
                            <div class="image"><img src="/resources/webpf/images/rsa.jpg" alt="" /></div><div class="content">
                                <h2>
                                    BigIntegers and RSA<br />
                                    in JavaScript 라이브러리를 사용한 <br />
                                    RSA암호화.
                                </h2>
                                <p>
                                    클라이언트에서는 BigIntegers and RSA in JavaScript 라이브러리를 사용하여 서버에서 생성한 공개키를 ajax요청으로 받아 데이터를 암호화 한 뒤 서버로 암호화 된 데이터를 전송합니다. 개인키를 받아오는 방식을 이 전의 input태그로 받아 javascript에서 다시 받아오는 방식에서, 전송요청을 하는 순간 ajax요청을 통해 받아오도록 변경함으로써 HTML 태그 내에 개인키가 노출되던 문제를 해결하였습니다. <br />
                                    RSA 암호화는 관리자 로그인, 작가에게 메시지 전송, 방문자의 메시지에 이메일 답장을 할 때 적용하였습니다.
                                </p>
                            </div>
                        </section>
                        <section class="spotlight">
                            <div class="image"><img src="/resources/webpf/images/email.jpg" alt="" /></div><div class="content">
                                <h2>방문자 메시지 관리 및 답장기능</h2>
                                <p>
                                    Contact페이지를 통해서 방문자는 작가에게 메시지를 전송할 수 있고 전송된 메시지는 데이터베이스에 등록된 시간과 함께 저장됩니다. 최초 전송시 쿠키를 발급받게 되고 쿠키가 존재하는 30분간은 메시지 전송을 제한하는 기능을 구현하였습니다.<br />
                                    관리자가 페이지에 접속하게 되면 저장된 메시지 리스트를 데이터베이스에서 읽어와 게시판 형태로 볼 수 있게 하였고 메시지를 보면서 email답장을 할 수 있게 구현하였습니다. root-context.xml에 등록한 Email계정 정보로 JavaEmailSender를 얻게되고 SimpleMailMessage사용하여 서버로 전달받은 데이터를 방문자 Email로 보내게 됩니다.<br />
                                    이메일 답장 시 데이터 전송은 ajax통신을 사용하여 페이지의 전환 없이 이메일을 보낼 수 있게 하였습니다.
                                </p>
                            </div>
                        </section>
						<section class="spotlight">
							<div class="image"><img src="/resources/webpf/images/upload.png" alt="" /></div><div class="content">
								<h2>드래그 앤 드롭방식의 사진 등록</h2>
								<p>
                                    드래그 앤 드롭 및 파일 입력, 두가지 방식으로 사진을 입력합니다.<br />
                                    사진을 놓으면 ajax로 사진파일을 서버로 전송해 임시폴더에 저장 하게 되고 페이지에서는 텍스트 정보만 전달받게 됩니다. 이후 삭제, 순서변경 등을 하고 저장을 하게 되면 서버에서 카테고리에 맞게 폴더를 생성하고 그 안에 사진을 복사한 뒤 임시폴더 사진을 삭제하는 과정을 거치게 됩니다.<br />
                                    카테고리 선택순간, 사진 입력 순간마다 ajax로 서버에 데이터를 호출하게 되고 전달 받은 데이터는 Handlebars 템플릿을 사용하여 화면에 표시해줍니다.
                                </p>
							</div>
						</section>
						<section class="spotlight">
							<div class="image"><img src="/resources/webpf/images/modify.PNG" alt="" /></div><div class="content">
								<h2>사진 순서와 텍스트 변경 및 삭제</h2>
								<p>
                                    카테고리별로 저장되어 있는 사진을 불러옵니다. 그리고 제목, 내용, 순서 변경 및 삭제 기능을 수행하게 됩니다.<br />
                                    제목, 내용, 순서 변경이 이루어 지게 되면 저장 시 변경이 적용 된 게시물의 데이터만 업데이트가 이루어지게 하여 불필요한 데이터 수정을 줄였습니다. 데이터 삭제시 DELETE방식, 수정시 PUT방식을 적용하였습니다.
                                </p>
							</div>
						</section>
					</section>

				<!-- Three -->
					<section id="three" class="wrapper style3 special">
						<div class="inner">
							<header class="major">
								<h2>그 외 구현한 내용</h2>
							</header>
							<ul class="features">
								<li class="icon fa-code">
									<h3>사용자페이지 로그인 접근제한</h3>
									<p>인터셉터를 사용하여 사용자페이지 접근 시 관리자권한을 가진 세션이 있는지 확인하고 없다면 로그인페이지로 리다이렉트합니다.</p>
								</li>
                                <li class="icon fa-code">
                                    <h3>방문자 접속횟수 제한</h3>
                                    <p>최초 방문시 쿠키를 생성해 클라이언트에 등록하고 특정시간 내에 재접속 하는 방문자 정보는 등록하지 않도록하여 부정확한 통계가 생기지 않도록 하였습니다.</p>
                                </li>
								<li class="icon fa-code">
									<h3>자주사용되는 기능은 <br />Util클래스로 제작</h3>
									<p>이미지 삭제, 복사, 등록기능은 ImageUtil클래스로. 외부 api접근은 위해 자주 사용되는 HttpClient를 HttpClientUtil로. RSA의 키 생성과 관련된 기능을 RSAUtil클래스로 만들어 컨트롤러 및 비지니스계층에서의 코드를 간결하게 하였고 보다 쉽게 사용할 수 있도록 만들었습니다.</p>
								</li>
								<li class="icon fa-code">
									<h3>RestController 구성.</h3>
									<p>GET, POST, PUT, DELETE 방식을 적극적으로 활용하고 RestController는 요청을 처리하도록 구성하였습니다. 서버에서는 결과에 따라 적절한 응답코드를 반환하고 클라이언트에서는 응답코드에 따른 적절한 동착을 취하도록 하였습니다.</p>
								</li>
                                <li class="icon fa-code">
                                    <h3>Instagram 사진 얻어오기</h3>
                                    <p>Instagram 계정승인을 통해 얻은 토큰을 사용하여 계정에 게시되어있는 게시물과 관련된 데이터가 들어있는 JSON파일을 전달받습니다. 데이터를 파싱하여 필요한 데이터를 취한 뒤 Instagram에 게시되어 있는 사진을 Contact페이지에 보여주고 사진 클릭 시 Instagram사이트의 관련 게시물로 이동되도록 하였습니다.</p>
                                </li>
							</ul>
						</div>
					</section>

				<!-- CTA -->
					<section id="cta" class="wrapper style4">
						<div class="inner">
							<header>
								<h2>아래 정보로 로그인</h2>
								<p>
                                    게스트로 로그인 하면 관리자 페이지를 둘러볼 수 있습니다.<br />(일부 기능은 제한됩니다.)<br />
                                    ID: guest<br />
                                    PW: guest<br />
                                </p>
							</header>
							<ul class="actions vertical">
                                <li></li>
                                <li></li>
								<li><a href="/adlogin" class="button fit special">Admin-Page</a></li>
							</ul>
						</div>
					</section>

				<!-- Footer -->
					<footer id="footer">
						<ul class="copyright">
							<li>&copy; Untitled</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
						</ul>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="/resources/webpf/assets/js/jquery.min.js"></script>
			<script src="/resources/webpf/assets/js/jquery.scrollex.min.js"></script>
			<script src="/resources/webpf/assets/js/jquery.scrolly.min.js"></script>
			<script src="/resources/webpf/assets/js/skel.min.js"></script>
			<script src="/resources/webpf/assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="/resources/webpf/assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="/resources/webpf/assets/js/main.js"></script>

	</body>
</html>