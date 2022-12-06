

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <h1>Personne :</h1>
        <h2>nom: ${personne.nom}</h2>
        <h2>prenom: ${personne.prenom}</h2>
        <h2>age: ${personne.age}</h2>
        
        <c:if test="${personne.age>18}">
            <p>vous etes une personne majeure</p>
        </c:if>
        <c:if test="${personne.age<18}">
            <p> vous etes une personne mineure</p>       
        </c:if>        
        
        
        <form method="POST" action="personnesession">
            <label for="prenom">prénom</label><input type="text" name="prenom" id="prenom"/>
            <label for="nom">nom</label><input type="text" name="nom" id="nom"/>
            <label for="age">age</label><input type="text" name="age" id="age"/>
            
            <input type="submit" value="Envoyer"/>
        </form>
            <ul>
                <c:forEach items="${personnes}" var="personne">
                    <li> ${ personne.prenom } ${ personne.nom }
                </c:forEach>             
            </ul>
        <!-- POST pour envoyer des données -->
        
    </body>
</html>
