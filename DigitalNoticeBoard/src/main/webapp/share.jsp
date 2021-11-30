<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>email</title>
<script>   
  function   email()   {      
	var to = document.form1.address.value;
    var subject = document.form1.title.value; 
	var name = document.form1.name.value;
	var link = document.form1.link.value;
	var message = document.form1.message.value;
	var p = " \r "; 
	var body = link+ p + message;  
    var   mailURL   = "mailto:"+ to + "?subject=" + subject + "&body=" + body;     
  	window.location = mailURL;   
  }     
</script>

<style>
	body
	{
		background-image: url("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.pptbz.com%2Fd%2Ffile%2Fp%2F201708%2F060f13ccbc95bc1f83f719fc107677c9.png&refer=http%3A%2F%2Fwww.pptbz.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1638573241&t=5bcf5a63251c091f4073fe2cb04617ff");
	}
</style>
</head>

<body>
	<form name="form1" action="" style="background-color:#ffffff00;height:500px;width:900px;margin:0 auto" style = "text-align:center;">
		<table>
			<tr>
				<td style="text-align:center;">address</td>
				<td style="text-align:center;"><input type="text" value="" name="address" style="background-color:#ffffff;height:40px;width:300px;"  /></td>
			</tr>
			<tr>
				<td style="text-align:center;">title</td>
				<td style="text-align:center;"><input type="text" id="notice-email-title" disabled="disabled" value="Enter Title" name="title" style="background-color:#ffffff;height:40px;width:300px;" /></td>
			</tr>
			<tr>
				<td style="text-align:center;">notice content</td>
				<td style="text-align:center;"><input type="text" id="notice-email-content" disabled="disabled" value="Enter Content" name="link" style="background-color:#ffffff;height:40px;width:300px;"  /></td>
			</tr>			
			<tr>
				<td style="text-align:center;">message</td>
				<td style="text-align:center;"><input type="text" value="" name="message" style="background-color:#ffffff;height:40px;width:300px;"/></td>
	            <td>Write down something?(optional)</td>		
			</tr>
			<tr>
				<td style="text-align:center;"><input type="button" value="send" onclick="email();" /></td>
				<td style="text-align:center;"><input type="reset" value="reset"/></td>
			</tr>
		</table>
	</form>

</body>
</html>
