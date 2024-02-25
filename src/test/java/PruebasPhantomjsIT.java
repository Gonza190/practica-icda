import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class PruebasPhantomjsIT {
        private static WebDriver driver = null;

        @Test
        public void tituloIndexTest() {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setJavascriptEnabled(true);
                caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/bin/phantomjs");
                caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
                                new String[] { "--web-security=no", "--ignore-ssl-errors=yes" });
                driver = new PhantomJSDriver(caps);
                driver.navigate().to("http://localhost:8080/Baloncesto/");
                assertEquals("Votacion mejor jugador liga ACB", driver.getTitle(),
                                "El titulo no es correcto");
                System.out.println(driver.getTitle());
                driver.close();
                driver.quit();
        }

        @Test
        public void ponerVotosACeroTest() {

                // PF-A: poner votos a cero y luego comprobar que están a cero en la tabla
                System.out.println("PF-A: poner votos a cero y luego comprobar que están a cero en la tabla");
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setJavascriptEnabled(true);
                caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/bin/phantomjs");
                caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
                                new String[] { "--web-security=no", "--ignore-ssl-errors=yes" });
                driver = new PhantomJSDriver(caps);
                driver.navigate().to("http://localhost:8080/Baloncesto/");

                // se pulsa en el boton "Poner votos a cero"
                driver.findElement(By.id("cero-btn")).click();

                // se pulsa en el boton "Ver votos"
                driver.findElement(By.id("ver-votos-btn")).click();

                // se busca la tabla
                WebElement tabla = driver.findElement(By.tagName("table"));

                // se busca cada fila y se introduce en una lista
                List<WebElement> filas = tabla.findElements(By.tagName("tr"));

                boolean todasCero = true;

                // se itera sobre la lista de filas
                for (int i = 1; i < filas.size(); i++) {
                        List<WebElement> columnas = filas.get(i).findElements(By.tagName("td"));
                        // si la segunda columna no es igual a cero, error
                        if (!columnas.get(1).getText().equals("0")) {
                                todasCero = false;
                                break;
                        }
                }

                // si todasCero es true, es porque todas las filas tienen cero votos
                assertEquals(true, todasCero);

                driver.close();
                driver.quit();
        }

        @Test
        public void otroJugadorTest() {

                // PF-B: votar con otro jugador y ver que en la tabla de votos aparece un voto
                System.out.println("PF-B: votar con otro jugador y ver que en la tabla de votos aparece un voto");

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setJavascriptEnabled(true);
                caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/bin/phantomjs");
                caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
                                new String[] { "--web-security=no", "--ignore-ssl-errors=yes" });
                driver = new PhantomJSDriver(caps);
                driver.navigate().to("http://localhost:8080/Baloncesto/");

                // nombre del jugador con el que probaremos
                String nombre = "Gasol";

                // se busca el select y el campo de texto para rellenarlos
                driver.findElement(By.id("select-otro")).click();
                driver.findElement(By.id("text-otro")).sendKeys(nombre);

                // se pulsa en el boton "Votar"
                driver.findElement(By.id("votar")).click();

                // se vuelve al index
                driver.navigate().to("http://localhost:8080/Baloncesto/");

                // se pulsa en el boton "Ver votos"
                driver.findElement(By.id("ver-votos-btn")).click();

                // se busca la tabla
                WebElement tabla = driver.findElement(By.tagName("table"));

                // se busca cada fila y se introduce en una lista
                List<WebElement> filas = tabla.findElements(By.tagName("tr"));

                // buscamos solo la columna 4 porque se inserta al final de la tabla
                boolean votado = false;
                List<WebElement> columna = filas.get(4).findElements(By.tagName("td"));

                // si el jugador se inserta y en la columna de votos
                // tiene un 1 es porque funciona
                if (columna.get(1).getText().equals("1") &&
                                columna.get(0).getText().equals(nombre)) {
                        votado = true;
                }

                // Prints para ver desde workflow si se inserta bien la informacion
                System.out.println("JUGADOR: " + columna.get(0).getText());
                System.out.println("VOTOS: " + columna.get(1).getText());

                // si todasCero es true, es porque se ha introducido correctamente
                assertEquals(true, votado);

                driver.close();
                driver.quit();
        }

}
