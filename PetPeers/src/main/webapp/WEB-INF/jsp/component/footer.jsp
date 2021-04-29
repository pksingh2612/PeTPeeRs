<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <style>
				.footer {
				   position: fixed;
				   left: 0;
				   bottom: 0;
				   width: 100%;
				   color: white;
				   text-align: center;
				}
			</style>
        </head>

        <body>
            <footer>
	            <div class="footer mt-5">
	            <c:set var="now" value="<%= new java.util.Date()%>" />
	                <p class="text-center text-muted">
	                    &#169; Copyright
	                    <fmt:formatDate pattern="yyyy" value="${now}" />
	                    HCLT
	                </p>
	            </div>
            </footer>
        </body>

        </html>