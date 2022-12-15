<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<a href="/dojos/new" class="btn btn-primary mt-3">New Dojo</a>
	<p class="display-5 mt-3">New Ninja</p>
	<div class="border container py-3 mb-3">
		<form:form action="/ninjas/new" method="post" class="d-flex gap-3 flex-column" modelAttribute="ninja">
			<div>
			<form:select class="form-select" name="dojo" path="dojo" aria-label="Dojo">
				<c:forEach var="dojo" items="${allDojos}">
			  		<form:option value="${dojo.id}">${dojo.name}</form:option>
			  	</c:forEach>
			</form:select>
			</div>
			<div class="form-group">
			  	<form:label for="firstName" path="firstName">Enter the first name</form:label>
			  	<form:input type="text" class="form-control" id="firstName" path="firstName" placeholder="John" />
			  	<form:errors path="firstName" class="text-danger"/>
			</div>
			<div class="form-group">
			  	<form:label for="lastName" path="lastName">Enter the last name</form:label>
			  	<form:input type="text" class="form-control" id="lastName" path="lastName" placeholder="Doe" />
			  	<form:errors path="lastName" class="text-danger"/>
			</div>
			<div class="form-group">
			  	<form:label for="age" path="age">Enter age</form:label>
			  	<form:input type="number" class="form-control" id="age" path="age" placeholder="0" />
			  	<form:errors path="age" class="text-danger"/>
			</div>
		    <div class="d-flex justify-content-end">
		    	<button type="submit" class="btn btn-primary">Submit</button>
		    </div>
		</form:form>
	</div>
</div>
</body>
</html>