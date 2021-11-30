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
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <!--<a class="navbar-brand" href="#">
    <img src="${contextPath}/resources/img/icon.png" width="30" height="30" alt="">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>-->

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="${contextPath}/${user.username}/userhome">Public</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextPath}/${user.username}/${group.name}">${group.name}</a>
      </li>
    </ul>
    <div class="fb-share-button" data-href="https://blackboard.albany.edu" data-layout="button"></div>
    <div class="dropdown">
	  <a class="btn btn-secondary dropdown-toggle" href="1" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		${user.username} 
	  </a>
	  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
		<a class="dropdown-item" href="${contextPath}/${user.username}/profile">Profile</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/${group.id}/addShortNotice">Add Short Notice</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/${group.id}/invite">Invite Member</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/${group.id}/exit">Exit Group</a>
		<a class="dropdown-item" href="${contextPath}/signout">SignOut</a>
	  </div>
	</div>
  </div>
</nav>
<body>
	<div class="container">
	<h2>Inivitations Recieved</h2>
        <table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Received From</th>
			      <th scope="col">Group</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="invite" items="${received}">
                 	<tr>
                      <td>${invite.sender.username}</td>
                      <td>${invite.group.name}</td>
                      <td><button id="acceptBtn" onclick="accept(${invite.id})" class="btn btn-primary float-right">Accept</button></td>
                      <td><button id="declineBtn" onclick="decline(${invite.id})" class="btn btn-primary float-right">Accept</button></td>
                     </tr>
          		</c:forEach>
			  </tbody>
			</table>
		<h2>Inivitations Sent</h2>
        <table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Sent To</th>
			      <th scope="col">Group</th>
			      <th scope="col">Status</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="invite" items="${sent}">
                 	<tr>
                      <td>${invite.receiver.username}</td>
                      <td>${invite.group.name}</td>
                      <td>${invite.inivitationStatus}</td>
                     </tr>
          		</c:forEach>
			  </tbody>
			</table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
  	var contextPath="${contextPath}";
  	var userName="${user.username}"
  	var grpId="${group.id}"
	
	function accept(id){
  		$.ajax({
	        url: contextPath+"/"+userName+"/grpId/"+id+"/accept",
	        method: 'GET',
	        success: function () {
	            window.location.reload();
	        },
	        error: function (error) {
	            alert(error);
	        }
	    })
	};
	function decline(id){
		$.ajax({
	        url: contextPath+"/"+userName+"/grpId/"+id+"/decline",
	        method: 'GET',
	        success: function () {
	            window.location.reload();
	        },
	        error: function (error) {
	            alert(error);
	        }
	    })
	};
    
</body>
</html>
