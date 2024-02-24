<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="main.java.ModeloDatos" %>
<%@ page import="main.java.Jugador" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%

    ModeloDatos modeloDatos = new ModeloDatos();
    List<Jugador> jugadores = modeloDatos.obtenerJugadores();
%>

<html>
  <head>
    <title>Votaci&oacute;n mejor jugador liga ACB</title>
    <link href="estilos.css" rel="stylesheet" type="text/css" />
  </head>
  <body class="resultado">
    <h1>Votos</h1>
    <table border="1">
      <tr>
        <th>Jugador</th>
        <th>Votos</th>
      </tr>
      <c:forEach var="jugador" items="${jugadores}">
        <tr>
          <td>${jugador.nombre}</td>
          <td>${jugador.votos}</td>
        </tr>
      </c:forEach>
    </table>

    <a href="index.html"> Ir al comienzo</a>
  </body>
</html>
