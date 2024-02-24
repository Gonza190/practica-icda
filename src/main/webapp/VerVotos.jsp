<%@ page import="java.util.List" %>
<%@ page import="baloncesto.ModeloDatos" %>
<%@ page import="baloncesto.Jugador" %>

<html>
  <head>
    <title>Votaci&oacute;n mejor jugador liga ACB</title>
    <link href="estilos.css" rel="stylesheet" type="text/css" />
  </head>
  <body class="resultado">
    <h1>Votos</h1>
    <table border="1">
      <tr>
        <th>baloncesto.Jugador</th>
        <th>Votos</th>
      </tr>
      <% 
        ModeloDatos modeloDatos = new ModeloDatos();
        modeloDatos.abrirConexion();
        List<Jugador> jugadores = modeloDatos.obtenerJugadores();
        for (Jugador jugador : jugadores) { %>
        <tr>
          <td><%= jugador.getNombre() %></td>
          <td><%= jugador.getVotos() %></td>
        </tr>
      <% } %>
    </table>

    <a href="index.html"> Ir al comienzo</a>
  </body>
</html>
