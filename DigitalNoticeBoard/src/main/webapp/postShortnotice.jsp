<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">My notice tab</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
          notice management
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="${contextPath}/mynoticetab">Marked notices</a>
          <a class="dropdown-item" href="#">posted notices</a>
          <a class="dropdown-item" href="${contextPath}/postShortnotice">post short notices</a>
        </div>
      </li>
      <!-- Dropdown -->
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
          my profile
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">profile setting</a>
          <a class="dropdown-item" href="${contextPath}/home">Log out</a>
        </div>
      </li>
      </li>
      <li class="nav-item">
      <a class="nav-link" href="${contextPath}/userhome">Go back to main page</a>
      </li>
    </ul>
  </nav>
  <br>
    </ul>
  </nav>

 
    <h1>post notice page</h1>

    <script>
      function show(){
          var show = document.getElementById("short_no");
          var content = document.getElementById("content");
          show.innerHTML += "Public content: " + content.value+"<br>"+"Public date: "+Date()+"<p>"+"<p>"+"<p>";
      }
        
      function After(){
        var after = time + oneDay;
        date.setTime(after);
        demo.innerHTML = myGerDate(date);
      }
        
      
      </script>
      <h1 id="showContent">Public short notices</h1>
      <input id="content" name="content"/>
      <button onClick="show()">public</button>
      <h2 id="short_n" style="color:rgb(255, 0, 0)"> Posted short notices History</h2>
      <h2>public content: House rent in 1700 Western Avenue<br></h2>
      <h2>Public date:Tue Oct 12 2021 15:16:25 GMT-0400<br></h2>
      <h2>(EDT)<p><p><p></h2>
      <div id="short_no" style="background-color:#EEEEEE;height:200px;width:400px;float:left;">
      </div>
</body>
</html>