<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>Create Page</title>
    </head>
    <body>        
            <form action="MainController" method="POST" class="form-signup">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Create Account</h1>
                <input name="userName" type="text" id="user-name" class="form-control" placeholder="User name" required="" autofocus="">
                ${requestScope.err.userNameError}
                <input name="passWord" type="password" id="user-pass" class="form-control" placeholder="Password" required autofocus="">
                ${requestScope.err.passWordError}
                <input name="confirm" type="password" id="user-repeatpass" class="form-control" placeholder="Confirm Password" required autofocus="">
                ${requestScope.err.confirmError}
                <input name="address" type="text" id="user-repeatpass" class="form-control" placeholder="Address" required autofocus="">
                ${requestScope.err.addressError}
                <input name="phone" type="text" id="user-repeatpass" class="form-control" placeholder="Phone" required autofocus="">
                ${requestScope.err.phoneError}

                <button class="btn btn-primary btn-block" type="submit" name="action" value="Create"><i class="fas fa-user-plus"></i>Create</button>
                <a href="Login.html" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
            </form>
            <br>
    </body>
</html>
