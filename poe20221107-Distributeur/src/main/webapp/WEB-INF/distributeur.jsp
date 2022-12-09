
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP DISTRIBUTEUR</title>
    </head>
    <body>
        <a href="distributeur?showbasket=true">My Basket</a>

        <h1>DISTRIBUTEUR</h1>
        <h2> remaining credit: ${remainCredit} </h2>
        <ul> 
            <c:forEach items="${stock}" var="product">
                <form method="POST" action="distributeur">
                    <li> name: ${product.name} | quantity: ${product.quantity} |price: ${product.price}

                        <input type="hidden" name="productId" value="${product.getId()}"/>
                        <input type="submit" value="add to basket"/>
                        
                </form>
            </c:forEach>
        </ul>
        <form method="POST" action="money">
            <label>insert your money</label><input type="text" name="moneyString" id="money"/>
            <input type="submit" value="insert"/>
        </form>
            
            
<!--        <form method="POST" action="distributeur">
            
        </form>-->
</body>
</html>
