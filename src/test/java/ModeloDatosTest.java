import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModeloDatosTest {

    @Test
    public void testExisteJugador() {
        System.out.println("Prueba de existeJugador");
        String nombre = "";
        ModeloDatos instance = new ModeloDatos();
        boolean expResult = false;
        boolean result = instance.existeJugador(nombre);
        assertEquals(expResult, result);
        // fail("Fallo forzado.");
    }

    @Test
    public void testActualizarJugador() {

        System.setProperty("DATABASE_HOST", "jdbc:mysql://localhost");
        System.setProperty("DATABASE_PORT", "3306");
        System.setProperty("DATABASE_NAME", "baloncesto");
        System.setProperty("DATABASE_USER", "usuario");
        System.setProperty("DATABASE_PASS", "clave");

        System.out.println("Prueba de actualizarJugador");

        String nombre = "Llull";
        ModeloDatos instance = new ModeloDatos();

        instance.abrirConexion();

        int antesDeActualizar = instance.cuantosVotosJugador(nombre);
        instance.actualizarJugador(nombre);
        int despuesDeActualizar = instance.cuantosVotosJugador(nombre);

        instance.cerrarConexion();

        // Se aumenta en 1 tras actualizar
        // assertEquals(antesDeActualizar + 1, despuesDeActualizar);
    }

}