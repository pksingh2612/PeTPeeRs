<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
        </head>

        <body>
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