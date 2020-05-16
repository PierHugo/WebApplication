<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="error" scope="request" type="java.lang.String" class="java.lang.String"/>
<html>
<head>
    <title>User information</title>
    <%@include file="header.jsp" %>

    <main>
        <div class="container border border-light rounded pt-5 mt-5 mb-5 pb-5">
            <div class="heading text-center pt-4">
                <h3 class="card-title"> <c:out value="${user.username}">${user.username}</c:out> information's </h3>
            </div>

            <div class="row">
                <p> First name: <c:out value="${user.firstName}">${user.firstName}</c:out> </p>
                <p> Last name: <c:out value="${user.lastName}">${user.lastName}</c:out> </p>
                <p> Age: <c:out value="${user.age}">${user.age}</c:out> </p>
                <p> City: <c:out value="${user.city}">${user.city}</c:out> </p>
            </div>
        </div>
    </main>
</html>
