package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Metodos {
    /**La funcion se encarga de pasar un dato de tipo texto a LocalDate
     * @param dato sera el la fecha en formato cadena de texto
     * @return devuelve un datos de tipo LocalDate con la fecha   */
    public static LocalDate parseFecha(String dato) {
        // pasa de String a LocalDate  dd/mm/aaaa
        LocalDate fecha;
        fecha = LocalDate.parse(dato, DateTimeFormatter.ofPattern("dd/M/uuuu"));
        return fecha;
    }
}
