<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Reset Password</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
      
      
  </head>

  <body background="https://i.pinimg.com/564x/03/1d/75/031d75d9a633a918c30d91b82c255f97.jpg">
      <div class="container">

        <form:form method="POST" action="${contextPath}/resetpassword" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading">Reset Password</h2>
            
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>

			<spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="email" name="email" class="form-control" placeholder="Email"></form:input>
                    <form:errors path="email"></form:errors>
                </div>
            </spring:bind>          

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            <h3 class="text-center"><a href="${contextPath}/signup">Don't have an account ? Sign Up Here! </a></h3>
        </form:form>

    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
