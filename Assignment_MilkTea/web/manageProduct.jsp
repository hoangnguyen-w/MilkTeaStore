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
        <title>Manage Product</title>
    </head>
    <body>
        <h1>Welcome: Admin</h1>

        <form action="MainController">
            <input type="submit" name="action" value="Return">
            <input type="submit" name="action" value="Add new">
        </form>

        <c:if test="${requestScope.LIST_PRODUCT != null}">

            <table border="1" class="table table-striped table-dark container">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product Name</th>
                        <th>Image</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Cate Name</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.LIST_PRODUCT}" varStatus="counter">
                       
                        <form action="MainController" method="POST">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.productName}</td>    
                                <td><img  src="${dto.image}" style="width:50px;height:80px;"></td>    
                                <td>${dto.price}</td>
                                <td>${dto.quantity}</td> 
                                <td>${dto.categoryID}</td>   
                                <td>
                                    <form action="MainController" method="Post">                                  
                                    <input type="submit" name="action" value="DeleteP"/>
                                </td>

                                <td>
                                    <input type="hidden" name="proName" value="${dto.productName}"/>
                                    <input type="hidden" name="image" value="${dto.image}"/>
                                    <input type="hidden" name="price" value="${dto.price}"/>
                                    <input type="hidden" name="quantity" value="${dto.quantity}"/>
                                    <input type="hidden" name="cateID" value="${dto.categoryID}"/>
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
