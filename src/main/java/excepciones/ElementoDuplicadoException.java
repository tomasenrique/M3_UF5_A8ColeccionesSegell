package excepciones;

public class ElementoDuplicadoException extends  Exception{


    /**Cuando se crea una clase de excepcion propia, este debe de tener dos constructores, uno sin paramatros y otro
     * con un mensaje. 	 */
    public ElementoDuplicadoException() {
    }

    public ElementoDuplicadoException(String message) {
        // aqui se le pasa un mensaje para que se muestre en el mensaje cuando halla una excepcion
        super(message);
    }
}
