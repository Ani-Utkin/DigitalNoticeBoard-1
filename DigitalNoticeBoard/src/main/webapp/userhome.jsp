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
<meta property="og:url"           content="http://ec2-18-217-243-133.us-east-2.compute.amazonaws.com:8086/" />
<meta property="og:type"          content="website" />
<meta property="og:title"         content="Digital notice board" />
<meta property="og:description"   content="Check on new notice!" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link href="${contextPath}/resources/css/home.css" rel="stylesheet">
<link href="${contextPath}/resources/css/lightbox.css" rel="stylesheet">
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
 <!-- <a class="navbar-brand" href="#">
    <img src="${contextPath}/resources/img/icon.png" width="30" height="30" alt="">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>-->

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <c:forEach var="grp" items="${groups}">
      <li class="nav-item">
        <a class="nav-link" href="${contextPath}/${user.username}/group/${grp.id}">${grp.name}</a>
      </li>
      </c:forEach>
    </ul>
    <div class="fb-share-button" data-href="http://ec2-18-217-243-133.us-east-2.compute.amazonaws.com:8086/" data-layout="button"></div>
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
		<div class="item row">
            <div class="col-sm-9">
            <c:forEach var="chnl" items="${Channels}">
				<div class="card notice-card" style="">
					<h2 class="card-title bg-primary">${chnl.title}</h2>
					<div class="card-body">
					 <div class="notice-slider">
					  <c:forEach var="note" items="${chnl.notices}">
					   <div class="notice" style="width: 25rem;">
						<div class="notice-header">
						 <h3 class="notice-title">${note.title}</h3>
						</div>
						<div class=notice-body>
						 <p class=notice-summary>${note.summary}</p>
						 <p class=notice-expirationtime><strong>Created Date :</strong><fmt:formatDate value="${note.createdAt}" pattern="yyyy-MM-dd" /></p>
						 <p class=notice-expirationtime><strong>Expire Date :</strong><fmt:formatDate value="${note.expirationDate}" pattern="yyyy-MM-dd" /></p>
					  </div>
					  <button class="bookmarkbutto btn btn-primary" onclick="onBookMarkNotice('${user.username}', '${note.id}')" style="width:60px; height:30px">BM</button>
					  <button  class="btn btn-primary" onclick="openLightBox(); 
						 showNoticeTitle('${note.title}'); 
						 showNoticeSummary('${note.summary}');" style="width:60px; height:30px">View</button>
					  <button class="btn btn-primary" style="width:60px; height:30px" onclick="share('${note.title}', '${note.summary}')">share</button>
					   </div>
					   </c:forEach>
					  </div>
				  </div>
				 </div>
   		    </c:forEach>
	    	</div>
             <div class="col-sm-3 shortnoticeHeight">
              <div class="short-notice-slider bg-primary">
               <h2 class="bg-primary">Short Notices</h2>
               <c:forEach var="shnote" items="${ShortNotices}"> 
                 <div class="shortnotice">
            		<p>${shnote.details}</p>
            		<p>Expires at: <fmt:formatDate value="${shnote.expirationDate}" type="time" pattern="HH:mm" /></p>
            	   <button class=sharebutton onclick="shareShort('${shnote.details}')" style="width:60px; height:30px">share</button>
            	   </div>           	   
               </c:forEach>
             </div>
            </div>  
		</div>

		<div id="Lightbox" class="modal">
				<div class="modal-dialog">
					<div class="modal-content">
				<div class="modal-header">
				  <h3 id="lightbox-notice-title" class="modal-title">${note.title}</h3>
				  <span type="button" class="model-close pointer"  onclick="closeLightBox()" aria-label="Close">X</span>
				</div>
				<div class="modal-body">
				 <p id="lightbox-notice-summary" class=notice-summary>${note.summary}</p>
				 <button class=bookmarkbutton onclick="onBookMarkNotice('${user.username}', '${note.id}')" style="width:60px; height:30px">BM</button> 
				<!--<button class=sharebutton onclick="share('${note.title}', '${note.summary}')" style="width:60px; height:30px">share</button> --> 
				</div>
			</div>
			</div>
		  </div>
		 

    </section>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/js/lightbox.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
      $('.notice-slider').slick({
    	  infinite: true,
    	  slidesToShow: 2,
    	  slidesToScroll: 1,
    	  autoplay: true,
    	  autoplaySpeed: 3000,
    	  variableWidth: true,
    	  variableHeight: true
      });
    });
  	</script>
  	<script type="text/javascript" src="${contextPath}/resources/js/eventshandlers.js">
  	</script>
  	
  	
 
  /*test for share, not completed*/	
  
<script type="text/javascript">
    function openDialog(t, s){undefined

        workerId = window.open('share.jsp','','width=900,height=400');

		workerId.onload = function() {
			workerId.document.getElementById("notice-email-title").value = t;
			workerId.document.getElementById("notice-email-content").value = s;
		}

        if(workerId!=undefined && workerId!=""){undefined
           document.getElementById("leader").value = workerId;
          }
        }
</script>
   
 <script>
  function share(t, s) {
    if (confirm("Share this notice?")) {
    	openDialog(t, s);
    } 
    else {
    }
 }
</script>

 <script>
  function shareShort(s){
    if (confirm("Share this short notice?")) {
    	openDialog("Short Notice", s);
    } 
    else {
    }
 }
</script>   

<div id="fb-root"></div>
	<script>(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id)) return;
			js = d.createElement(s); js.id = id;
			js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.0";
			fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));
	</script>
  	
</body>
</html>
