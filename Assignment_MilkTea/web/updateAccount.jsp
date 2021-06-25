<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" 
              crossorigin="anonymous">    
        <link href="css/manaUser.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <h1>Welcome: Admin</h1>
        <form action="MainController">
            
            User ID<input type="text" name="userID" value="${param.userID}" readonly=true /></br>
            User Name<input type="text" name="userName" value="${param.userName}"/></br> 
            Password<input type="password" name="passWord" value="${param.passWord}" readonly="true"/></br>
            address<input type="text" name="address" value="${param.address}"/></br>
            phone<input type="text" name="phone" value="${param.phone}"/></br>
            roleID<input type="text" name="roleID" value="${param.roleID}"/></br>
            <input type="hidden" name="Search" value="${param.Search}"/></br>
            <input type="submit" name="action" value="Update"/></br>
            
        </form>
</body>
</html>
