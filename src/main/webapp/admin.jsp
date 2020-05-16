<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="error" scope="request" type="java.lang.String" class="java.lang.String"/>
<html>
<head>
    <title>Administration</title>
    <%@include file="header.jsp" %>

    <main>
        <div class="container border border-light rounded pt-5 mt-5 mb-5 pb-5">
            <div class="heading text-center pt-4">
                <h3 class="card-title">User list</h3>
            </div>

            <form class="col s12" action="administration" method="post">
                <div class="input-field col s6 row">
                    <input id="username" type="text" name="username" class="validate">
                    <label for="username">Type the username to delete</label>
                    <input id="submit" type="submit" value="Remove user">

                </div>
            </form>

            <div class="row">
                <table class="responsive-table">
                    <thead>
                    <tr>
                        <th>Username</th>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Age</th>
                        <th>City</th>
                    </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="user" items="${user}">
                            <tr>
                                <td><c:out value="${user.username}">${user.username}</c:out></td>
                                <td><c:out value="${user.firstName}">${user.firstName}</c:out></td>
                                <td><c:out value="${user.lastName}">${user.lastName}</c:out></td>
                                <td><c:out value="${user.age}">${user.age}</c:out></td>
                                <td><c:out value="${user.city}">${user.city}</c:out></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </main>
</html>
