<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ecommerce</title>
    </head>
    <body>
        <h1>Ecommerce</h1>
        
        
        <a href="store">Retour au magasin</a>
       
        <h2>Contenu du panier</h2>
         <ul>
            <c:forEach items="${items}" var="item">
                 <li> ${ item.article.name } [${ item.quantity }]
            </c:forEach>             
         </ul>
         
    </body>
</html>
