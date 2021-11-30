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
      <c:forEach var="grp" items="${groups}">
      <li class="nav-item">
        <a class="nav-link" href="${contextPath}/${user.username}/group/${grp.id}">${grp.name}</a>
      </li>
      </c:forEach>
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
      <a class="dropdown-item" href="${contextPath}/${user.username}/newGroup">New Group</a>
      <a class="dropdown-item" href="${contextPath}/${user.username}/pendinginvite">Current Invitations</a>
      <a class="dropdown-item" href="${contextPath}/signout">SignOut</a>
	  </div>
	</div>
  </div>
</nav>
<body>
    <div class="maincontent">
	<section id="">
		<form:form method="POST" action="${contextPath}/${user.username}/profile/edit" modelAttribute="profileForm">
            <h2 class="channel-title">Edit profile</h2>
            <spring:bind path="firstName">
                <form:input type="text" path="firstName" class="form-control" placeholder="${profile.firstName}"
                                autofocus="true"></form:input>
            </spring:bind>
			<spring:bind path="lastName">
                <form:input type="text" path="lastName" class="form-control" placeholder="${profile.lastName}"
                                autofocus="true"></form:input>
            </spring:bind>
			 <spring:bind path="address1">
                <form:input type="text" path="address1" class="form-control" placeholder="${profile.address1}"></form:input>
            </spring:bind>
            <spring:bind path="address2">
                <form:input type="text" path="address2" class="form-control" placeholder="${profile.address2}"></form:input>
            </spring:bind>
             <spring:bind path="phone">
                <form:input type="text" path="phone" class="form-control" placeholder= "${profile.phone}"></form:input>
            </spring:bind>
            <spring:bind path="image">
                <form:select multiple="true" path="image" class="form-control" placeholder="${profile.image}"/>
            </spring:bind>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
        	</form:form>
    </section>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
</body>
</html>
