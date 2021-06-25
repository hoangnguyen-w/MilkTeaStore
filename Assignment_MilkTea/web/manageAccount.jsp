<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" 
              crossorigin="anonymous">    
        <link href="css/manaUser.css" rel="stylesheet" type="text/css"/>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Account</title>

    </head>
    <body>

        <h1>Welcome: Admin</h1>

        <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
        </form>

        <form action="MainController">
            Search<input type="text" name="Search" value="${param.Search}"/>
            <input type="submit" name="action" value="Search"/>
            <input type="submit" name="action" value="Product"/>
        </form>

        <c:if test="${requestScope.LIST_USER != null}"> 

            <table border="1" class="table table-striped table-dark container">

                <thead>
                    <tr>
                        <th>No</th>
                        <th>User ID</th>
                        <th>User Name</th>
                        <th>Password</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Role ID</th>
                        <th>Delete</th>
                        <th>Update</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.LIST_USER}" varStatus="counter">
                        <form action="MainController" method="POST">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.userID}</td>
                                <td>${dto.userName}</td>
                                <td>
                                    <input type="password" name="txtPW" value="${dto.passWord}" readonly="true"/>
                                </td>
                                <td>${dto.address}</td>
                                <td>${dto.phone}</td>
                                <td>${dto.roleID}</td>

                                <td>
                                    <c:url var="delete" value="MainController">
                                        <c:param name="action" value="Delete"></c:param>
                                        <c:param name="userID" value="${dto.userID}"></c:param>
                                        <c:param name="Search" value="${param.Search}"></c:param>
                                    </c:url>

                                    <a href="${delete}">Delete</a>

                                </td>

                                <td>
                                    <input type="hidden" name="userID" value="${dto.userID}"/>
                                    <input type="hidden" name="userName" value="${dto.userName}"/>
                                    <input type="hidden" name="passWord" value="${dto.passWord}"/>
                                    <input type="hidden" name="address" value="${dto.address}"/>
                                    <input type="hidden" name="phone" value="${dto.phone}"/>
                                    <input type="hidden" name="roleID" value="${dto.roleID}"/>
                                    <input type="hidden" name="Search" value="${param.Search}"/>
                                    <input type="submit" name="action" value="Update"/>
                                </td>

                            </tr>
                        </form>
                </c:forEach>
            </tbody>
        </table>

    </c:if>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>
