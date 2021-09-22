<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="${contextPath}/resources/img/icon.png" width="30" height="30" alt="">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Public <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <a href="${contextPath}/signin">SignIn</a>
  </div>
</nav>
<body>
    <div class="maincontent">
	    <section id="">
			<div class="item row align-items-center">
              <div class="col-sm-9">
			    <div class="container">
				    <h2>University</h2>
				    <div class="row mx-auto my-auto">
				        <div id="recipeCarousel" class="carousel slide w-100" data-ride="carousel">
				            <div class="carousel-inner w-100" role="listbox">
				                <div class="carousel-item active">
				                	<div class="Notice">
				                		<div class="NoticeHeader">
				                		<h2>Covid-19 Mask Requirement</h2>
				                		</div>
				                		<div class=NoticeBoday>
				                		<p>Full facemask is required for all campus activity </p>
				                		<p><strong>Expire Time :</strong>30 Dec 2021</p>
				                		</div>
				                	</div>
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="https://cdn.shopify.com/s/files/1/2304/9095/files/DBE-ACDBE-logo.png?10873">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="https://cdn.shopify.com/s/files/1/2304/9095/files/MBE_LOGO.png?10873">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="https://cdn.shopify.com/s/files/1/2304/9095/files/2018_WBENC_logo_text_gray.png?10873">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="http://novel-mg.com/assets/cert_logo.png">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="https://www.kriaanet.com/wp-content/uploads/2019/02/300ppi-feat-logo_feat_logo-EDWOSB.png">
				                </div>
				            </div>
				            <a class="carousel-control-prev" href="#recipeCarousel" role="button" data-slide="prev">
				                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				                <span class="sr-only">Previous</span>
				            </a>
				            <a class="carousel-control-next" href="#recipeCarousel" role="button" data-slide="next">
				                <span class="carousel-control-next-icon" aria-hidden="true"></span>
				                <span class="sr-only">Next</span>
				            </a>
				        </div>
				    </div>
				</div>
				<div class="container">
				    <h2>University</h2>
				    <div class="row mx-auto my-auto">
				        <div id="recipeCarousel" class="carousel slide w-100" data-ride="carousel">
				            <div class="carousel-inner w-100" role="listbox">
				                <div class="carousel-item active">
				                    <img width="900" height="1200" class="d-block col-3 img-fluid" src="https://cdn.shopify.com/s/files/1/2304/9095/files/NMSDC.png?10873">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="https://cdn.shopify.com/s/files/1/2304/9095/files/DBE-ACDBE-logo.png?10873">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="https://cdn.shopify.com/s/files/1/2304/9095/files/MBE_LOGO.png?10873">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="https://cdn.shopify.com/s/files/1/2304/9095/files/2018_WBENC_logo_text_gray.png?10873">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="http://novel-mg.com/assets/cert_logo.png">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="https://www.kriaanet.com/wp-content/uploads/2019/02/300ppi-feat-logo_feat_logo-EDWOSB.png">
				                </div>
				            </div>
				            <a class="carousel-control-prev" href="#recipeCarousel" role="button" data-slide="prev">
				                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				                <span class="sr-only">Previous</span>
				            </a>
				            <a class="carousel-control-next" href="#recipeCarousel" role="button" data-slide="next">
				                <span class="carousel-control-next-icon" aria-hidden="true"></span>
				                <span class="sr-only">Next</span>
				            </a>
				        </div>
				    </div>
				</div>
				<div class="container">
				    <h2>Deparment Of Computer Science</h2>
				    <div class="row mx-auto my-auto">
				        <div id="recipeCarousel" class="carousel slide w-100" data-ride="carousel">
				            <div class="carousel-inner w-100" role="listbox">
				                <div class="carousel-item active">
				                    <img width="900" height="1200" class="d-block col-3 img-fluid" src="https://cdn.shopify.com/s/files/1/2304/9095/files/NMSDC.png?10873">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="https://cdn.shopify.com/s/files/1/2304/9095/files/DBE-ACDBE-logo.png?10873">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="https://cdn.shopify.com/s/files/1/2304/9095/files/MBE_LOGO.png?10873">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="https://cdn.shopify.com/s/files/1/2304/9095/files/2018_WBENC_logo_text_gray.png?10873">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="http://novel-mg.com/assets/cert_logo.png">
				                </div>
				                <div class="carousel-item">
				                    <img class="d-block col-3 img-fluid" src="https://www.kriaanet.com/wp-content/uploads/2019/02/300ppi-feat-logo_feat_logo-EDWOSB.png">
				                </div>
				            </div>
				            <a class="carousel-control-prev" href="#recipeCarousel" role="button" data-slide="prev">
				                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				                <span class="sr-only">Previous</span>
				            </a>
				            <a class="carousel-control-next" href="#recipeCarousel" role="button" data-slide="next">
				                <span class="carousel-control-next-icon" aria-hidden="true"></span>
				                <span class="sr-only">Next</span>
				            </a>
				        </div>
				    </div>
				</div>
              </div>
              <div class="col-sm-3">
              	<div class="shortnotice">
              		<p>car raid available from Manning</p>
              		<p>Expaired by: 1:00 PM</p>
              	</div>	
              </div>  
			</div>
        </section>
    </div>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
