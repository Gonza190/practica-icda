
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.List;

public class Acb extends HttpServlet {

    private ModeloDatos bd;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        bd = new ModeloDatos();
        bd.abrirConexion();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession s = req.getSession(true);

        // poner votos a cero
        if (req.getParameter("cero") != null) {
            bd.ponerVotosACero();
            res.sendRedirect(res.encodeRedirectURL("index.html"));
            return;
        }

        // ir a VerVotos.jsp
        if (req.getParameter("verVotos") != null) {
            req.setAttribute("jugadores", bd.obtenerJugadores());
            req.getRequestDispatcher("VerVotos.jsp").forward(req, res);
            return;
        }

        String nombreP = req.getParameter("txtNombre");
        String nombre = req.getParameter("R1");

        if (nombre.equals("Otros")) {
            nombre = req.getParameter("txtOtros");
        }
        if (bd.existeJugador(nombre)) {
            bd.actualizarJugador(nombre);
        } else {
            bd.insertarJugador(nombre);
        }
        s.setAttribute("nombreCliente", nombreP);
        // Llamada a la página jsp que nos da las gracias
        res.sendRedirect(res.encodeRedirectURL("TablaVotos.jsp"));
    }

    @Override
    public void destroy() {
        bd.cerrarConexion();
        super.destroy();
    }
}
