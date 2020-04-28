<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link rel="stylesheet" href="   https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link rel="stylesheet" href="css/custom.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>

<body>

<header>
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Web Application</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <c:choose>
                    <c:when test="${sessionScope.type == 'admin'}">
                        <li>
                            <a href="login">Log out</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="login">Log in</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>
</header>
