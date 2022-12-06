
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jeux du nombre</title>
    </head>
    <body>
        <h1>JEUX DU NOMBRE</h1>
       
        <form method="POST" action="exo1">
            <label for="number">nombre</label>
            <input type="text" name="number" id="number"/>
            <input type="submit" value="Jouer"/>
        </form>
        
        <h2>nombre à deviné: ${random_int}</h2>
        <h2>nombre de tentative restant: ${nombreDeTentative-tentative+1}</h2>
      
      
    </body>
</html>
