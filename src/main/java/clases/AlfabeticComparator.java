package clases;

import interfaz.InterfaceDataAlfabetic;

import java.util.Comparator;

/**
 * Esta clase servira para poder comparar datos que contengan letras
 */
//public class AlfabeticComparator implements Comparator<Moneda> {// Se modificada por la linea de abajo para que esta clase sea generica
public class AlfabeticComparator<E extends InterfaceDataAlfabetic> implements Comparator<E> {

    @Override
    public int compare(E generico1, E generico2) {
        return generico1.getGenericAlfabetic().compareTo(generico2.getGenericAlfabetic());
    }
}
