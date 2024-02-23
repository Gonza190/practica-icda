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
        System.out.println(result);
        assertEquals(expResult, result);
        // fail("Fallo forzado.");
    }

    @Test
    public void testActualizarJugador() {

        System.out.println("Prueba de actualizarJugador");

        String nombre = "Llull";
        ModeloDatos instance = new ModeloDatos();
        instance.abrirConexion();

        boolean result = instance.existeJugador(nombre);
        System.out.println(result);

        int antesDeActualizar = instance.cuantosVotosJugador(nombre);
        instance.actualizarJugador(nombre);
        int despuesDeActualizar = instance.cuantosVotosJugador(nombre);

        // Se aumenta en 1 tras actualizar
        assertEquals(antesDeActualizar + 1, despuesDeActualizar);
    }

}