<%@ page import="java.util.List" %>
<%@ page import="jugador.Jugador" %>

<% 
//obtengo los jugadores del request
List<Jugador> jugadores = (List<Jugador>) request.getAttribute("jugadores"); 
%>

<!DOCTYPE>
<html lang=es>
  <head>
    <title>Votaci&oacute;n mejor jugador liga ACB</title>
    <link href="estilos.css" rel="stylesheet" type="text/css" />
  </head>
  <body class="resultado">
    <h1>Votos de los jugadores de la liga ACB</h1>
    <table border="1" >
    <caption>Tabla con jugadores de la liga ACB con sus votos</caption>
      <tr>
        <th>Jugador</th>
        <th>Votos</th>
      </tr>
      <% 
      //itero los jugadores en una tabla, si no son nulos
      if(jugadores!=null){
        for (Jugador jugador : jugadores) { %>
        <tr>
          <td><%= jugador.getNombre() %></td>
          <td><%= jugador.getVotos() %></td>
        </tr>
      <% }} %>
    </table>

    <a href="index.html"> Ir al comienzo</a>
  </body>
</html>
