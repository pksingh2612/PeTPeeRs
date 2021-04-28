<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="ISO-8859-1">
					<title>Welcome to Pet Shop</title>
					<jsp:include page="./component/head.jsp"></jsp:include>
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
							<table class="table table-bordered">
								<thead>
									<tr>
										<th> Pet ID </th>
										<th> Pet Name </th>
										<th> Pet Age </th>
										<th> Pet Place </th>
										<th> Buy </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${petList}" var="pet">
										<tr>
											<td>${pet.petId}</td>
											<td>${pet.petName}</td>
											<td>${pet.petAge}</td>
											<td>${pet.petPlace}</td>
											<td><a href="#">Buy</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</section>

					<jsp:include page="./component/footer.jsp"></jsp:include>
				</body>

				</html>