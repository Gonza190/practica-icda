<!DOCTYPE>
<html lang=es>
  <head>
    <title>Votaci&oacute;n mejor jugador liga ACB</title>
    <link href="estilos.css" rel="stylesheet" type="text/css" />
  </head>
  <body class="resultado">
    <p size="10">
      Votaci&oacute;n al mejor jugador de la liga ACB
      <hr />
      <% String nombreP = (String) session.getAttribute("nombreCliente"); %>
      <br />Muchas gracias <%=nombreP%> por su voto
    </p>
    <br />
    <br />
    <a href="index.html"> Ir al comienzo</a>
  </body>
</html>
