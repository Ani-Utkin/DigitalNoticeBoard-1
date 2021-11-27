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
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
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
<div class="container">

        <form:form method="POST" action="${contextPath}/${user.username}/notice/addShortNotice" modelAttribute="shortNoticeForm">
            <h2 class="channel-title">Add Short Notice</h2>
            <spring:bind path="details">
                <form:input path="details" class="form-control" placeholder="Details"
                                autofocus="true"></form:input>
            </spring:bind>
            <spring:bind path="expirationTime">
                <form:input  path="expirationTime" class="form-control" id = "expDatePicker" placeholder="ExpirationTime"></form:input>
            </spring:bind>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
        </form:form>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
    <script>
         $(function () {
             $("#expDatePicker").timepicker({
            	    timeFormat: 'HH:mm',
            	    interval: 60,
            	    maxTime: '23:59',
            	    defaultTime: '01:00',
            	    startTime: '01:00',
            	    dynamic: false,
            	    scrollbar: true});
         });
     </script>
</body>
</html>
