<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Commerce Page</title>
    </head>
    <body>
        <h1>Amazin E-commerce</h1>
        <h1>${av}</h1>
        <div>
        <ul>
        
            <h2>Liste des produits</h2>
        <c:forEach begin="0" end="${fn:length(stock)-1}" var="index">            
            <li>
                nom = ${stock[index].getNom()} | prix = ${stock[index].getPrix()} | quantite = ${stock[index].getQuantite()}
            </li>
        </c:forEach>
        </ul>
        <form method="POST" action="eCommerce">
            <div>
                <label>Produit: </label>
                <select name="produitAjouteId" id="produitAjouteId">
                    <option>-- choisissez un produit --</option>
                    <option value=1>a</option>
                    <option value=2>b</option>
                    <option value=3>c</option>
                    <option value=4>d</option>
                    <option value=5>e</option>
                    <option value=6>f</option>
                    <option value=7>g</option>
                    <option value=8>h</option>
                    <option value=9>i</option>
                </select>        
            </div>
            <label>quantite :</label><input type="text" name="quantite" id="quantite"/>
            <div>
                <input type="submit" value="Ajouter dans le panier"/>
            </div>    
        </form>            
        </div>
        <h2>panier</h2> 
        <ul>
            <c:forEach items="${panier}" var="produitAjoute">
               
                    <li> nom:${produitAjoute.getNom() } | prix: ${ produitAjoute.getPrix() } | quantite: ${produitAjoute.getQuantite()}
                
            </c:forEach>       
        </ul>  
        <h2>prix totale: ${sum}</h2>
         
        <c:if test="${not empty error}">
            <div id="error-container">
                ${error}
            </div>            
        </c:if>
      
    </body>
</html>
