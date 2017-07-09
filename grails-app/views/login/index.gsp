<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Amazon Prime</title>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>
<div class="container well">
    <div class="col-md-4 col-md-offset-4">

        <div class="panel panel-default">
            <div class="panel-heading custom-heading">
                <div class="row-fluid user-row">
                    Login
                </div>
            </div>

            <div class="panel-body">
                <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="form form-group"
                      autocomplete="off">

                    <fieldset>
                        <label class="panel-login">
                            <div class="login_result"></div>
                        </label>
                        <input class="form-control" placeholder="User Name/Email Id" id="userName" type="text"
                               name="${usernameParameter ?: 'username'}" required="required"/><br>
                        <input class="form-control" placeholder="Password" id="password" type="password"
                               name="${passwordParameter ?: 'password'}" required="required"/><br>

                        <div class="form-control form-group-lg">
                            <input type="checkbox" class="chk"
                                   name="${rememberMeParameter ?: 'remember-me'}"
                                   id="remember_me" <g:if test='${hasCookie}'>checked="checked"</g:if>/> Remember Me
                        </div>
                        <br>
                        <button type="submit" class="btn btn--right btn-lg btn-success btn-block"
                                id="login">Sign in</button>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
