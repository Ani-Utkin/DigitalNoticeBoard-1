<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/signup.css" rel="stylesheet">
      
      
  </head>

  <body background="https://i.pinimg.com/564x/03/1d/75/031d75d9a633a918c30d91b82c255f97.jpg">
      <div class="container">
      	<h2 class="form-signin-heading">Create your account</h2>
        <form:form method="POST" action="${contextPath}/signup" modelAttribute="userForm" class="form-signin">
          <div class="row">
            <spring:bind path="username">
                <div class=" errorblock form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>
           </div> 
			 <spring:bind path="email">
                <div class="errorblock form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="email" name="email" class="form-control" placeholder="Email"></form:input>
                    <form:errors path="email"></form:errors>
                </div>
            </spring:bind>          

            <spring:bind path="password">
                <div class="errorblock form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="passwordConfirm">
                <div class="errorblock form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="Confirm your password"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            <h3 class="text-center"><a href="${contextPath}/signin">Already Have an Account ? Sign in</a></h3>
        </form:form>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script>
         document.getElementById("levelOfDegree").style.display='block';
        function showLevelOfDegree(value){
           if(value == "Faculty"){
               document.getElementById("levelOfDegree").style.display='none';
           }else{
           document.getElementById("levelOfDegree").style.display='block';}
        }
    </script>
      <style>
  .errorblock span{color: #FF0000;
    font-size: 14px;
    padding: 10px;
    display: block;
    border-radius: 5px;
    margin-top: 5px;margin-left:45px!important;}
    .form-signin a,.form-signin-heading{color:#000000!important;}
  </style>
  </body>
</html>
