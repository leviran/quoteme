<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!--  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/stylesheet.css"> -->
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
</head>
<body>
<h1>hola, soy quoteme</h1>

<h1>Login aqui</h1>

<form:form action="myQuotes" modelAttribute="user">
Username: <form:input path="username"/>
<form:errors path="username" />
<br /><br />
Password: <form:input path="password"/>
<form:errors path="password" />
<br /><br />
<input type="submit" value="Submit" />
</form:form>

<br />
<br />
<a href="/quoteme/testing-user" >Test here</a>

</body>
</html>