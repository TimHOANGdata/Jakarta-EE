<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DISTRIBUTER - BASKET</title>
    </head>
    <body>
        <h1>DISTRIBUTEUR</h1>
        
        
        <a href="distributeur">RETURN TO DISTRIBUTEUR</a>
        
        <h2>BASKET</h2>
        <c:if test="${not empty Error}">
            ${Error}
        </c:if>
         <ul>
            <c:forEach items="${productsBasket}" var="product">
                 <li> ${ product.name } | quantity = ${ product.quantity } | price = ${ product.price }
            </c:forEach>             
         </ul>
        <h2> total price : ${totalPrice} </h2>
        <h2> remain credit : ${remainCredit} </h2>
        
    </body>
</html>