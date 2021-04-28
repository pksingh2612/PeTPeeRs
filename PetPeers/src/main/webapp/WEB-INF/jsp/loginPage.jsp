<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="ISO-8859-1">
					<title>Login</title>
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
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">

                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="/PetPeers/register"> <svg
                                    xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                    class="bi bi-person-fill" viewBox="0 0 16 16">
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
							<c:url var="userLoginAction" value="/authenticateUser" />
							<form:form action="${userLoginAction}" method="post" modelAttribute="userLoginForm">
								<div class="mb-3">
									<label for="UserName" class="form-label">UserName</label>
									<form:input type="text" path="userName" class="form-control" id="UserName"
										aria-describedby="userName" />
									<font color="red">
										<form:errors path="userName" />
									</font>

								</div>
								<div class="mb-3">
									<label for="Password" class="form-label">Password</label>
									<form:input type="password" path="userPassword" class="form-control"
										id="Password" />
									<font color="red">
										<form:errors path="userPassword" />
									</font>
								</div>
								<button type="submit" class="btn btn-primary">Login</button>
							</form:form>
						</div>
					</section>

					<jsp:include page="./component/footer.jsp"></jsp:include>
				</body>

				</html>