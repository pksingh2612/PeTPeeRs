<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="ISO-8859-1">
					<title>Welcome to Pet Shop</title>
					<link rel="stylesheet"
						href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
						integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
						crossorigin="anonymous">
					<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
						integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
						crossorigin="anonymous"></script>
					<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
						integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
						crossorigin="anonymous"></script>
					<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
						integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
						crossorigin="anonymous"></script>
					<style>
						.crtable {
							caption-side: top;
							padding-left: 10px;
						}
					</style>
				</head>

				<body>
					<header>
						<!-- NavBar Started -->
						<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
							<a class="navbar-brand" href="#">PetShop</a>
							<button class="navbar-toggler" type="button" data-toggle="collapse"
								data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
								aria-expanded="false" aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>

							<div class="collapse navbar-collapse" id="navbarSupportedContent">
								<ul class="navbar-nav mr-auto">
									<li class="nav-item active"><a class="nav-link" href="/PetPeers/home">Home <span
												class="sr-only">(current)</span></a>
									</li>
									<li class="nav-item"><a class="nav-link" href="/PetPeers/myPets">My Pet</a></li>
									<li class="nav-item"><a class="nav-link" href="/PetPeers/addPet">Add Pet</a></li>
								</ul>
								<ul class="navbar-nav">
									<li class="nav-item"><a class="nav-link" href="#"> <svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
												<path
													d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
											</svg> Sign Up
										</a></li>
								</ul>
							</div>
						</nav>
						<!-- NavBar Finished -->
					</header>

					<section>
						<div class="container mt-5">
						<h2>Login</h2>
							<c:url var="userAction" value="/authenticateUser" />
						<form:form action="${userAction}" method="post" modelAttribute="userForm"> 
							<div class="mb-3">
								<label for="UserName" class="form-label">UserName</label>
								<form:input type="text"  path="userName" class="form-control" id="UserName"
									aria-describedby="userName"/>
									<font color="red">
										<form:errors path="userName" />
									</font>
								
							</div>
							<div class="mb-3">
								<label for="Password" class="form-label">Password</label>
								<form:input type="password" path="userPassword" class="form-control" id="Password"/>
									<font color="red">
										<form:errors path="userPassword" />
									</font>
							</div>
							
							<button type="submit" class="btn btn-primary">Login</button>
							 </form:form> 
						</div>
					</section>

					<footer>
						<c:set var="now" value="<%= new java.util.Date()%>" />
						<p class="text-center text-muted">
							&#169; Copyright
							<fmt:formatDate pattern="yyyy" value="${now}" />
							HCLT
						</p>
					</footer>
				</body>

				</html>