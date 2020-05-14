<jsp:useBean id="error" scope="request" type="java.lang.String" class="java.lang.String"/>
<html>
<head>
    <title>Log in</title>
    <%@include file="header.jsp" %>
    <main>
        <div class="container border border-light rounded pt-5 mt-5 mb-5 pb-5">
            <div class="heading text-center pt-4">
                <h3 class="card-title">Register</h3>
            </div>
            <form method="post" id="registerForm" action="register">
                <div class="row">
                    <div class="input-field col s12">
                        <input id="username" type="text" name="username" class="validate">
                        <label for="username">Username</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="firstname" type="text" name="firstname" class="validate">
                        <label for="firstname">First name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="lastname" type="text" name="lastname" class="validate">
                        <label for="lastname">Last name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="age" type="number" name="age" class="validate">
                        <label for="age">Age</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="city" type="text" name="city" class="validate">
                        <label for="city">City</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="password" type="password" name="password" class="validate">
                        <label for="password">Password</label>
                    </div>
                </div>
                <label>
                    <input id="check_admin" type="checkbox" name="check_admin"/>
                    <span>Je suis administrateur !</span>
                </label>

                <div class="row">
                    <div id="error">
                        ${error}
                    </div>
                </div>
                <div class="row">
                    <button class="btn waves-effect waves-light" type="submit" name="action">Register
                        <i class="material-icons right">security</i>
                    </button>
                </div>
            </form>
            <div>
                <p>Already have an account ?
                    <a class="waves-effect waves-light btn-small" href="login">Log in</a>
                </p>
            </div>
        </div>

    </main>
    <%@include file="footer.jsp" %>

</html>
