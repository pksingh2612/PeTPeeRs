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
							<a class="navbar-brand" href="/PetPeers/">PetShop</a>
							<button class="navbar-toggler" type="button" data-toggle="collapse"
								data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
								aria-expanded="false" aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>

							<div class="collapse navbar-collapse" id="navbarSupportedContent">
								<ul class="navbar-nav mr-auto">
									<li class="nav-item active">
										<a class="nav-link" href="/PetPeers/home">Home <span
												class="sr-only">(current)</span></a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="/PetPeers/myPets">My Pet</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="/PetPeers/addPet">Add Pet</a>
									</li>
								</ul>
								<ul class="navbar-nav">
									<li class="nav-item">
										<a class="nav-link" href="/PetPeers/login">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-power" viewBox="0 0 16 16">
												<path d="M7.5 1v7h1V1h-1z" />
												<path
													d="M3 8.812a4.999 4.999 0 0 1 2.578-4.375l-.485-.874A6 6 0 1 0 11 3.616l-.501.865A5 5 0 1 1 3 8.812z" />
											</svg>
											Logout
										</a>
									</li>
								</ul>
							</div>
						</nav>
						<!-- NavBar Finished -->
					</header>

					<section>
						<div class="container mt-5">
							<c:url var="petAction" value="/savePet" />
							<form:form action="${petAction}" method="post" modelAttribute="petForm">
								<table class="table table-bordered">
									<caption class="table-secondary crtable">Pet Information</caption>
									<tbody>
										<tr>
											<td>Name</td>
											<td>
												<form:input type="text" path="petName" />
												<font color="red">
													<form:errors path="petName" />
												</font>
											</td>
										</tr>
										<tr>
											<td>Age</td>
											<td>
												<form:input type="number" path="petAge" />
												<font color="red">
													<form:errors path="petAge" />
												</font>
											</td>
										</tr>
										<tr>
											<td>Place</td>
											<td>
												<form:input type="text" path="petPlace" />
												<font color="red">
													<form:errors path="petPlace" />
												</font>
											</td>
										</tr>
										<tr>
											<td colspan="2">
												<div class="d-flex justify-content-center">
													<div class="p-3">
														<input type="submit" value="Add Pet"
															style="background-color: aqua; border:0; color: aliceblue; border-radius: 5px; padding-left: 10px;" />
														<input type="reset" value="Cancel"
															style="background-color: aqua; border:0; color: aliceblue; border-radius: 5px;" />
													</div>
												</div>

											</td>
										</tr>
									</tbody>
								</table>
							</form:form>
						</div>
					</section>

					<footer>
						<c:set var="now" value="<%= new java.util.Date()%>" />
						<p class="text-center text-muted">&#169; Copyright
							<fmt:formatDate pattern="yyyy" value="${now}" /> HCLT
						</p>
					</footer>
				</body>

				</html>