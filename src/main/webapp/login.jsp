<jsp:useBean id="error" scope="request" type="java.lang.String" class="java.lang.String"/>
<html>
<head>
    <title>Log in</title>
    <%@include file="header.jsp" %>
    <main>
        <div class="container border border-light rounded pt-5 mt-5 mb-5 pb-5">
            <div class="heading text-center pt-4">
                <h3 class="card-title">Log in</h3>
            </div>
            <form method="post" id="loginForm" action="login">
                <div class="row">
                    <div class="input-field col s12">
                        <input id="username" type="text" name="username" class="validate">
                        <label for="username">Username</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="password" type="password" name="password" class="validate">
                        <label for="password">Password</label>
                    </div>
                </div>
                <div class="row">
                    <div id="error">
                        ${error}
                    </div>
                </div>
                <div class="row">
                    <button class="btn waves-effect waves-light" type="submit" name="action">Log in
                        <i class="material-icons right">security</i>
                    </button>
                </div>
            </form>
            <div>
                <p>Not logged in yet ?
                    <a class="waves-effect waves-light btn-small" href="register">Register</a>
                </p>
            </div>
        </div>

    </main>
    <%@include file="footer.jsp" %>

</html>
