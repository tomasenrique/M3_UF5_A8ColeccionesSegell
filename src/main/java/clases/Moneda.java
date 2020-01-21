package clases;

import interfaz.InterfaceDataAlfabetic;

import java.time.LocalDate;
import java.util.Objects;

import static java.lang.String.format;

//public class Moneda implements Comparable<Moneda>, Serializable { // poner si queremos que sea serializable la clase
public class Moneda implements Comparable<Moneda>, InterfaceDataAlfabetic {

    // Para poder generar un id diferente a cada moneda nuevo se usara los 2 siguientes atributos
    private static int cantidad = 0;
    private final int id; // identificador unico de la moneda asignar de forma automatica

    private int valor; // valor de la moneda
    private String tipo; // sera para saber si es moneda o billete
    private String detalle; // descripcion de la moneda
    protected String imagen; // sera la imagen que tiene la moneda
    private LocalDate fecha; // fecha de creacion de la moneda

    // Constructor
    public Moneda() {
        cantidad++;
        this.id = cantidad;
    }

    public Moneda(int valor, String tipo, String detalle, String imagen, LocalDate fecha) {
        this.valor = valor;
        this.tipo = tipo;
        this.detalle = detalle;
        this.imagen = imagen;
        this.fecha = fecha;
        // Aqui se asigna un valor diferente de id a cada objeto creado
        cantidad++;
        this.id = cantidad;
    }


    // Setter y Getter
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    // Metodos
    @Override
    public String toString() {
        /**aqui se aplica un formato para la salida en consola, cuando es un numero positivo las letras se alinean a la
         * derecha y si es un numero negativo se alinean a la izquierda  */
        return format("Id: %-3d Valor: %-4d  Tipo: %-8s  Detalle: %-40s Imagen: %-38s Fecha: %-20s", id, valor, tipo, detalle, imagen, fecha);
    }

    @Override
    public int compareTo(Moneda moneda) {
        /**Aqui la forma de comparar se realizara de la sigueinte manera:
         * Si el resultado es -1 indicara que el dato pasado va primero
         * Si el resultado es 0 indicara que el dato pasado es identico y por lo tanto no cambia de pocicion
         * Si el resultado es 1 indicara que el dato pasado va despues  */
        int resultado = 0;
        // Con esta configuracion el orden mostrado de los valores sera DECRECIENTE: de mayor a menor
        if (this.valor > moneda.valor) {
            resultado = -1;
        } else if (this.valor < moneda.valor) {
            resultado = 1;
        }
        return resultado;
    }


    /**
     * Este es el metodo sobrescrito para poder saber si estamos agregando una moneda repetida a la lista
     * El metodo 'equals' utiliza los campos o atributos de la clase para poder saber si un objeto es igual a otro.
     * Se puede configurar para que verifique uno a varios campos.
     * EJM: por lo general hay productos iguales pero tienen versiones diferentes , en ese caso el campo clave seria
     * la 'version' con la que se trabajaria para poder comparar los objetos.
     *
     * @param object Sera el objeto pasado para comprobar si es igual
     * @return Devolvera un valor de tipo boleano, true para indicar que si son iguales
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Moneda) { // Aqui verifica si el objeto pasado es una instancia del objeto Moneda
            /**Se declara un objeto de tipo moneda y se realiza el casting del objeto 'object' para que sea ahora de tipo
             * moneda y asi se pueda acceder al campo con el que se trabajara para saber si es un mismo objeto        */
            Moneda moneda = (Moneda) object;
            /**Aqui con this hace referencia al objeto donde se encuentra, que es esta clase Moneda, para asi poder comparar
             * todos sus atributos con los del objeto pasado como parametro al cual realizo un casting y asi poder comparar
             * sus campos con los de la clase y ver si son iguales      */
            if (this.valor == moneda.valor && Objects.equals(this.tipo, moneda.tipo) && Objects.equals(this.detalle, moneda.detalle) && Objects.equals(this.imagen, moneda.imagen) && Objects.equals(this.fecha, moneda.fecha)) {
                return true; // si son iguales
            } else {
                return false; // no son iguales
            }
        } else {
            return false; // indicara que el objeto pasado no es instacia de la clase Moneda
        }
    }


    /**
     * Este metodo compara dos objetos usando sus valores enteros hashCode indicando que si tiene el mismo valor los
     * objetos seran iguales
     *
     * @param moneda Sera el objeto moneda pasado como parametro
     * @return Devolvera un boleano, true si son iguales y false si no lo son
     */
    public boolean esIgual(Moneda moneda) {
        boolean resultado = false;
        /**Aqui se llama al metodo 'hashCode()' para obtener el numero hash de esta clase para compararla con el hash de
         * del parametro pasado que es el objeto 'Moneda'      */
        if (hashCode()  == moneda.hashCode()) {
            /**Aqui una vez comparados los hash se verifica con 'this' que sera esta clase, se compara con el metodo 'equals'
             * si es igual que el dato pasado 'Moneda'           */
            if (this.equals(moneda)) {
                resultado = true;
            }
        }
        return resultado;
    }


    /**
     * Este metodo hashCode ha sido sobrescrito para poder obtener un numero entero hash de un objeto usando todos los
     * campos o atributos del objeto Moneda
     *
     * @return Sera el resultado hashCode en numero entero
     */
    @Override
    public int hashCode() {
        final int constante = 17; // para tomas como referencia
        int resultado = 1; // para almacenar el hash obtenido

        resultado = constante * resultado + valor; // aqui se obtiene el hash del atributo 'valor'

        /**Aqui se obtiene el hash del atributo 'tipo' usando el condicional if else  y agregandolo al anterior resultado */
        if (this.tipo != null) {
            resultado = constante * resultado + tipo.hashCode();
        } else {
            resultado = constante * resultado;
        }
        /**Aqui se obtiene el hash de los atributos 'detalle', 'imagen' y 'fecha' por medio del operador ternario.
         * El funcionamiento es el siguiente:
         * Se multiplica la 'constante' por el 'resultado' mas el resultado de la operacion ternaria
         * Donde:
         * Si 'detalle' es igual a nulo el valor es cero, Si no se obtiene el hash del atributo 'detalle'
         * detalle == null ? 0 : detalle.hashCode()  */
        resultado = constante * resultado + (detalle == null ? 0 : detalle.hashCode());
        resultado = constante * resultado + (imagen == null ? 0 : imagen.hashCode());
        resultado = constante * resultado + (fecha == null ? 0 : fecha.hashCode());

        /**El 'resultado' se ira sobrescribiendo hasta terminar el ultimo campo, obteniendo asi el hashCode del objeto.
         * En este caso se esta usando todos los campos o atributos de la clase pero se puede configurar para usarlo con
         * uno o todos todo depende de la especificacion y del onjeto a comparar. */
        return resultado;
    }

    /**
     * ESTOS METODOS SERAN PARA LA CLASE GENERICA
     *
     */
    @Override
    public LocalDate getGenericData() {
        return getFecha();  // devuelve la fecha para poder comparar por ello y ordenar la lista
    }

    @Override
    public String getGenericAlfabetic() {
        return getImagen(); // se ordenara tomando como referencia el campo de imagen que es de tipo String
    }

    @Override
    public int getGenericValor() {
        return getValor();
    }


}
