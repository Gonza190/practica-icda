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
        System.out.println("Prueba de actualizarJugador");

        // Variables de entorno
        System.setProperty("DATABASE_HOST", "jdbc:mysql://localhost");
        System.setProperty("DATABASE_PORT", "3306");
        System.setProperty("DATABASE_NAME", "baloncesto");
        System.setProperty("DATABASE_USER", "usuario");
        System.setProperty("DATABASE_PASS", "clave");

        String nombre = "Rudy";
        ModeloDatos instance = new ModeloDatos();

        instance.abrirConexion();

        int antesDeActualizar = instance.cuantosVotosJugador(nombre);
        instance.actualizarJugador(nombre);
        int despuesDeActualizar = instance.cuantosVotosJugador(nombre);

        instance.cerrarConexion();

        // Son diferentes antes y después de actualizar
        assertNotEquals(antesDeActualizar, despuesDeActualizar);

        // Se aumenta en 1 tras actualizar
        assertEquals(antesDeActualizar + 1, despuesDeActualizar);
    }

}