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
		<a href="/ninjas/new" class="btn btn-primary mt-3">New Ninja</a>
		<p class="display-5 mt-3">New Dojo</p>
		<div class="border container py-3 mb-3">
			<form:form action="/dojos/new" method="post" class="d-flex gap-3 flex-column" modelAttribute="dojo">
				<div class="form-group">
				  	<form:label for="name" path="name">Enter the name</form:label>
				  	<form:input type="text" class="form-control" id="name" path="name" placeholder="San Francisco" />
				  	<form:errors path="name" class="text-danger"/>
				</div>
			    <div class="d-flex justify-content-end">
			    	<button type="submit" class="btn btn-primary">Submit</button>
			    </div>
			</form:form>
		</div>
	</div>
</body>
</html>