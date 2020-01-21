package clases;

import excepciones.ElementoDuplicadoException;
import interfaz.InterfaceDataAlfabetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Poniendo lo siguiente ' <T> ' despues de la clase lo que estamos haciendo es ponerle
 * un argumento de tipo, por lo tanto la clase pasaria a ser generica.
 * Por convencion se usan las letras T, U, K, E, N, V y S, donde caa letra es para:
 * E: elemento de una colección.
 * K: clave.
 * V: valor.
 * N: número.
 * T: tipo.
 * S, U, V etc: para segundos, terceros y cuartos tipos.
 *
 * @param <E> sera el datro de tipo generico
 */
//public class Contenedor<E extends Comparable<E> & Serializable> implements Iterable<E> { // para poder heredar el serializable
public class Contenedor<E extends Comparable<E> & InterfaceDataAlfabetic> implements Iterable<E> {

    private ArrayList<E> generico; // lista de tipo generica

    // Builder
    public Contenedor() {
        // se inicializa el arrayList generico
        this.generico = new ArrayList<>();
    }

    // Setter and Getter
    public ArrayList<E> getGenerico() {
        return generico;
    }

    public void setGenerico(ArrayList<E> generico) {
        this.generico = generico;
    }


    // Methods
    public void guardarObjetoGenerico(E generico) throws ElementoDuplicadoException {
        boolean contiene = false; // para saber si el objeto generico existe en la lista
        if (this.generico.contains(generico)) contiene = true; // verifica si el objeto existe en la lista generica
        // Si el valor del boleano es 'true' significa que el objeto existe en la lista generica
        if (contiene)
            throw new ElementoDuplicadoException("Repeated object: Un objeto ya existe, No se agregara a la lista.\n");
        else this.generico.add(generico); // agregara a la lista solo los objetos que no sean iguales
    }


    public void mostrarDatos() {
        // mostrara el contenido del arrayList generico usando un FOREACH
        for (E eGenerico : generico) {
            System.out.println(eGenerico);
        }
    }


    public void ordenarPorValor() {
        /**Para que este metodo funcione hay que agregar una herencia al generico, ver en la parte superior de la clase:
         * EJM => public class Contenedor<E extends Comparable<E>> implements Iterable<E>
         *
         * Se agrega 'extends Comparable<E>' a la parte que solo habia 'Contenedor<E> implements Iterable<E> '  */
        Collections.sort(this.generico);
    }


    public void ordenarPorAlfabeto() {
        /**Para que este metodo funcione hay que modificar la clase 'AlfabeticComparator'
         * DE ==>> public class AlfabeticComparator implements Comparator<Moneda>
         * A ==>> public class AlfabeticComparator<E extends InterfaceDataAlfabetic> implements Comparator<E>
         *
         * Y de aqui implementar el nuevo metodo generico que nos indica al interfaz
         * despuen en la clase 'Moneda' hay que implementar el mentodo 'getGenericAlfabetic'     */
        Collections.sort(generico, new AlfabeticComparator());
    }


    public void ordenarPorFecha() {
        /**Para que este metodo funcione hay que poner lo siguiente en la parte superior de la clase:
         * ANTES ==>> public class Contenedor<E extends Comparable<E>> implements Iterable<E>
         *
         * Se agrega lo siguiente: '& InterfaceDataAlfabetic'
         * NUEVO ==>> public class Contenedor<E extends Comparable<E> & InterfaceDataAlfabetic> implements Iterable<E> {
         *
         * y en la clase Moneda agregar la interface 'InterfaceDataAlfabetic'
         * ASI => public class Moneda implements Comparable<Moneda>, InterfaceDataAlfabetic {      */
        Collections.sort(generico, new Comparator<E>() {
            @Override
            public int compare(E generico1, E generico2) {
                // Comparara por fecha para ordenar
                return generico1.getGenericData().compareTo(generico2.getGenericData());
            }
        });

    }

    @Override
    public Iterator<E> iterator() {
        return generico.iterator();
    }

    // Para iterar la lista generica por un valor ingresado
    public Iterator<E> iterarPorValor(double minVal) {
        return new Iterator<E>() {
            int indice = 0; // servira para poder recorrer el arrayList

            @Override
            public boolean hasNext() {
                boolean resultado = false;
                while (indice < generico.size() && !resultado) {
                    if (generico.get(indice).getGenericValor() >= minVal) resultado = true;
                        //aqui si no se cumple lo anterior, se itera con normalidad el array
                    else indice++;
                }
                return resultado;
            }

            @Override
            public E next() {
                return generico.get(indice++);
            }
        };
    }

    public int indexOf(E generico) {
        return this.generico.indexOf(generico);
    }
}
