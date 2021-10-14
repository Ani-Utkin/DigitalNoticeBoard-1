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

    <script type="text/javascript">
      function fn1(){
          var t = document.getElementById("test");
          if(t.style.display === "none") {
              t.style.display = 'block';
          } else {
              t.style.display = 'none'; 
          }
      }
    </script>
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

 
    <h1>marked notice page</h1>

    <h2 class="text-danger" style="text-align:center;" >University notices</h2>
    <div class="table table-bordered" style="background-color:#fdd70085;height:500px;width:900px;margin:0 auto;">
      <table class="table">
        <thead>
          <tr>
            <th style="text-align:center;">title</th>
            <th style="text-align:center;">detail</th>
            <th style="text-align:center;">operation</th>
          </tr>
        </thead>
        <tbody>
          <tr id="test">
            <td  style="text-align:center;">COVID-19 Mask</td>
            <td>Required to wear mask on Campus</td>
            <td style="text-align:center;"><input type="button" style="background:rgb(255, 0, 0);color:rgb(0, 0, 0)" value="delete" onclick="fn1()"></td>
          </tr>
          <tr>
            <td style="text-align:center;">COVID Vaccine</td>
            <td>Vaccination complusiry for all in coming students</td>
            <td style="text-align:center;"><input type="button" style="background:rgb(255, 0, 0);color:rgb(0, 0, 0)" value="delete"></td>
          </tr>
          <tr>
            <td style="text-align:center;">Welcome Back</td>
            <td>Welcome back to Fall 2021</td>
            <td style="text-align:center;"><input type="button" style="background:rgb(255, 0, 0);color:rgb(0, 0, 0)" value="delete"></td>
          </tr>
        </tbody>
    </table>
    </div>
    <ul class="pagination">
      <li><a href="#">&laquo;</a></li>
      <li class="active"><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li><a href="#">&raquo;</a></li>
    </ul>

    <h2 class="text-danger" style="text-align:center;">Interships</h2>
    <div class="table table-bordered" style="background-color:#fdd70085;height:500px;width:900px;margin:0 auto;">
      <table class="table">
        <thead>
          <tr>
            <th style="text-align:center;">title</th>
            <th style="text-align:center;">detail</th>
            <th style="text-align:center;">operation</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style="text-align:center;">Interships at MS</td>
            <td>Microsoft- enddate: 1 Oct 2021</td>
            <td style="text-align:center;"><input type="button" style="background:rgb(255, 0, 0);color:rgb(0, 0, 0)" value="delete"></td>
          </tr>
        </tbody>
    </table>
    </div>
    <ul class="pagination">
      <li><a href="#">&laquo;</a></li>
      <li class="active"><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li><a href="#">&raquo;</a></li>
    </ul>

    <h2 class="text-danger" style="text-align:center;">Buy/sell</h2>
    <div class="table table-bordered" style="background-color:#fdd70085;height:500px;width:900px; margin:0 auto;">
      <table class="table">
        <thead>
          <tr>
            <th style="text-align:center;">title</th>
            <th style="text-align:center;">detail</th>
            <th style="text-align:center;">operation</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style="text-align:center;">Old Text Books</td>
            <td>I want to sell Cormen 3rd edition</td>
            <td style="text-align:center;"><input type="button" style="background:rgb(255, 0, 0);color:rgb(0, 0, 0)" value="delete"></td>
          </tr>
        </tbody>
    </table>
    </div>
    <ul class="pagination">
      <li><a href="#">&laquo;</a></li>
      <li class="active"><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li><a href="#">&raquo;</a></li>
    </ul>

    <h2 class="text-danger" style="text-align:center;">Short Notices</h2>
    <div class="table table-bordered" style="background-color:#fdd70085;height:500px;width:900px;margin:0 auto;">
      <table class="table">
        <thead>
          <tr>
            <th style="text-align:center;">title</th>
            <th style="text-align:center;">detail</th>
            <th style="text-align:center;">operation</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style="text-align:center;">-</td>
            <td>Ride share from Madison Avenue</td>
            <td style="text-align:center;"><input type="button" style="background:rgb(255, 0, 0);color:rgb(0, 0, 0)" value="delete"></td>
          </tr>
          <tr>
            <td style="text-align:center;">-</td>
            <td>Food is going to be finished at sub-connection</td>
            <td style="text-align:center;"><input type="button" style="background:rgb(255, 0, 0);color:rgb(0, 0, 0)" value="delete"></td>
          </tr>
        </tbody>
    </table>
    </div>
    <ul class="pagination">
      <li><a href="#">&laquo;</a></li>
      <li class="active"><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li><a href="#">&raquo;</a></li>
    </ul>
    
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      <script src="${contextPath}/resources/js/bootstrap.min.js"></script> 

</body>
</html>