<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="ISO-8859-1">
					<title>Sign Up</title>
					<jsp:include page="./component/head.jsp"></jsp:include>
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
							<a class="navbar-brand" href="/PetPeers/">PetShop</a>
							<button class="navbar-toggler" type="button" data-toggle="collapse"
								data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
								aria-expanded="false" aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>

							<div class="collapse navbar-collapse" id="navbarSupportedContent">
								<ul class="navbar-nav mr-auto">
								</ul>
								<ul class="navbar-nav">
									<li class="nav-item"><a class="nav-link" href="/PetPeers/login"> <svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-box-arrow-in-right"
												viewBox="0 0 16 16">
												<path fill-rule="evenodd"
													d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z" />
												<path fill-rule="evenodd"
													d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" />
											</svg>
											Login
										</a></li>
								</ul>
							</div>
						</nav>
						<!-- NavBar Finished -->
					</header>

					<section>
						<div class="container mt-5">
							<h2>Register</h2>
							<c:url var="userAction" value="/saveUser" />
							<form:form action="${userAction}" method="post" modelAttribute="userForm">
								<div class="mb-3">
									<label for="userName" class="form-label">UserName</label>
									<form:input type="text" path="userName" class="form-control" id="userName"
										aria-describedby="userName" />
									<font color="red">
										<form:errors path="userName" />
									</font>

								</div>
								<div class="mb-3">
									<label for="Password" class="form-label">Password</label>
									<form:input type="userPassword" path="userPassword" class="form-control"
										id="userPassword" />
									<font color="red">
										<form:errors path="userPassword" />
									</font>
								</div>
								<div class="mb-3">
									<label for="confirmPassword" class="form-label">Confirm Password</label>
									<form:input type="password" path="confirmPassword" class="form-control"
										id="confirmPassword" />
									<font color="red">
										<form:errors path="confirmPassword" />
									</font>
								</div>

								<button type="submit" class="btn btn-primary">Submit</button>
							</form:form>
						</div>
					</section>

					<jsp:include page="./component/footer.jsp"></jsp:include>
				</body>

				</html>