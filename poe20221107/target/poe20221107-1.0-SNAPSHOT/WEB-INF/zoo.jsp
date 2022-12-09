
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            #error-container{
                border: chocolate 1px solid;
            }
        </style>
        <title>Zoo JSP</title>
    </head>
    <body>
        <h1>Welcome to the zoo</h1>
        <c:if test="${not empty error}">
            <div id="error-container">
                ${error}
            </div>
        </c:if>   
        <form method="POST" action="zoo">
            <label>Tigre</label><input type="radio" name="type-animal" value="tigre" />
            <label>Elephant</label><input type="radio" name="type-animal" value="elephant"/> 
            <label for="nom">nom :</label><input type="text" name="nom" id="nom" placeholder="Alexandre"/>
            <label for="pays">pays :</label><input type="text" name="payname="type-animal"s" id="pays" placeholder="Vietnam"/>
            <label for="age">age :</label><input type="text" name="age" id="age"placeholder="5"/>
            <input type="submit" value="Envoyer"/>
        </form>
        <h2>list des tigres</h2>
        <ul>
            <c:forEach items="${animaux}" var="animal">
                <c:if test="${animal.getClass().name.equals(\"com.poe20221107.Tigre\")}">
                    <li> nom:${ animal.nom } | pays: ${ animal.pays } | age: ${ animal.age }
                </c:if>
            </c:forEach>                          
        </ul>
        <h2>list des elephants</h2> 
        <ul>
            <c:forEach items="${animaux}" var="animal">
                <c:if test="${animal.getClass().name.equals(\"com.poe20221107.Elephant\")}">
                    <li> nom:${ animal.nom } | pays: ${ animal.pays } | age: ${ animal.age }
                </c:if>
            </c:forEach>       
        </ul>
    </body>
</html>
