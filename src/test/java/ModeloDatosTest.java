import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModeloDatosTest {

    @Test
    public void testExisteJugador() {
        System.out.println("Prueba de existeJugador");
        String nombre = "Llull";
        ModeloDatos instance = new ModeloDatos();
        instance.abrirConexion();
        boolean expResult = true;
        boolean result = instance.existeJugador(nombre);
        assertEquals(expResult, result);
        instance.cerrarConexion();
        // fail("Fallo forzado.");
    }

    @Test
    public void testActualizarJugador() {

        System.out.println("Prueba de actualizarJugador");

        String nombre = "Llull";
        ModeloDatos instance = new ModeloDatos();

        System.out.println("La instancia es: " + instance.toString());

        instance.abrirConexion();

        int antesDeActualizar = instance.cuantosVotosJugador(nombre);
        instance.actualizarJugador(nombre);
        int despuesDeActualizar = instance.cuantosVotosJugador(nombre);

        instance.cerrarConexion();
        // Se aumenta en 1 tras actualizar
        // assertEquals(antesDeActualizar + 1, despuesDeActualizar);
    }

}