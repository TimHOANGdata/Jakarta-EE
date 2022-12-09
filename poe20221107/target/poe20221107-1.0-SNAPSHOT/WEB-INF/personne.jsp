

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    
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
        
         <c:choose>
             <c:when test="${ personnes.size() == 0 }">
                 <p>Il n'y a aucune personne à afficher</p> 
             </c:when>
             <c:when test="${ personnes.size() == 1 }">
                 <p>Il y a une personne dans la liste</p> 
             </c:when>
             <c:when test="${ personnes.size() > 1 }">
                 <p>Il y a plusieurs personnes dans la liste</p>
             </c:when>
             <c:otherwise>
                 <p>Probleme la liste ?</p>
             </c:otherwise>
         </c:choose>
        <ul>
            <c:forEach items="${personnes}" var="personne">
                <li> ${ personne.prenom } ${ personne.nom }
            </c:forEach>                 
        </ul>        
             <c:forEach var="compteur" begin="0" end="10" step="1">
                 ${compteur}
             </c:forEach>    
        <!-- POST pour envoyer des données -->
        
    

