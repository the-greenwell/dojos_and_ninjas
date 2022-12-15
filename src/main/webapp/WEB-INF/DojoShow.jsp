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
	<div class="container my-4">
		<div class="d-flex gap-2">
			<a href="/dojos/new" class="btn btn-primary mb-3">New Dojo</a>
			<a href="/ninjas/new" class="btn btn-primary mb-3">New Ninja</a>
		</div>
		<p class="display-6"><span class="underline">Dojo</span>: ${dojo.name}</p>
		
		
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">First Name</th>
		      <th scope="col">Last Name</th>
		      <th scope="col">Age</th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach var="ninja" items="${allNinjas}">
			    <tr>
			      <td>${ninja.firstName}</td>
			      <td>${ninja.lastName}</td>
			      <td>${ninja.age}</td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>
	</div>	
</body>
</html>