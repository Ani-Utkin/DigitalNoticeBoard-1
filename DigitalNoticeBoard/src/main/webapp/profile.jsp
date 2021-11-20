<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link href="${contextPath}/resources/css/home.css" rel="stylesheet">
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
        <a class="nav-link" href="${contextPath}/${user.username}/userhome">Public <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <div class="dropdown">
	  <a class="btn btn-secondary dropdown-toggle" href="1" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		${user.username} 
	  </a>
	  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
		<a class="dropdown-item" href="${contextPath}/${user.username}/profile">Profile</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/notice/addedNotices">Added Notices</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/bookmarkednotices">BookMarked Notices</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/notice/addNotice">Add Notice</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/notice/addShortNotice">Add Short Notice</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/channel/add">Add Channel</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/newGroup">New Group</a>
		<a class="dropdown-item" href="${contextPath}/signout">SignOut</a>
	  </div>
	</div>
  </div>
</nav>
<body>
	<div class="maincontent">
	<!-- <section id="">
		<div class="item row align-items-center">
		    <div class="col-sm-9">
	            <p>: ${profile.firstName}</p>
	            <p>Last Name: ${profile.lastName}</p>
	            <p>Address : ${profile.address1},<br>${profile.address2}</p>
	            <p>Phone : ${profile.phone}</p>
	            <img src="${profile.image}"></img>
	    	</div>
             <div class="col-sm-3">
             	<a href="${contextPath}/${user.username}/profile/edit">Edit Profile</a>
            </div>  
		</div>
    </section>-->
	<div class="col-md-12">
		<div class="card mb-3">
			<div class="card-body">
				<div class="row">
					<div class="col-sm-3">
						<h6 class="mb-0">First Name</h6>
					</div>
					<div class="col-sm-9 text-secondary"> ${profile.firstName}</div>
				</div><hr><div class="row">
					<div class="col-sm-3">
						<h6 class="mb-0">Last Name</h6>
					</div>
					<div class="col-sm-9 text-secondary"> ${profile.lastName}</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-sm-3">
						<h6 class="mb-0">Email</h6></div>
						<div class="col-sm-9 text-secondary">${profile.user.email}</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-3">
							<h6 class="mb-0">Phone</h6>
						</div
						><div class="col-sm-9 text-secondary"> ${profile.phone}</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-3">
							<h6 class="mb-0">Address</h6></div>
							<div class="col-sm-9 text-secondary"> ${profile.address1},<br>${profile.address2}</div>
						</div><hr>
						<div class="row">
							<div class="col-sm-12">
								 <a class="btn btn-info "  href="${contextPath}/${user.username}/profile/edit">Edit</a>
								</div>
							</div>
						</div>
					</div>
				</div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
</body>
</html>
