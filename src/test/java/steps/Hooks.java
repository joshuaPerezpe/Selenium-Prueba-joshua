package steps;

import io.cucumber.java.AfterAll;
import pages.BasePage;

public class Hooks {

    /**
     * Este método se ejecutará una sola vez, después de que TODOS los escenarios
     * de prueba hayan terminado. Es el lugar perfecto para cerrar el navegador.
     */
    @AfterAll
    public static void tearDown() {
        BasePage.closeBrowser();
    }
}