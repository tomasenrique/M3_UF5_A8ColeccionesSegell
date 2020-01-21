package principal;

import clases.Contenedor;
import clases.Segell;
import excepciones.ElementoDuplicadoException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static principal.Metodos.parseFecha;

public class PrincipalMain {
    public static void main(String[] args) {

        Segell m1 = new Segell("aa", "Moneda", 1.5, parseFecha("01/01/2000"));
        Segell m2 = new Segell("bb", "billete", 2.5, parseFecha("02/02/2001"));
        Segell m3 = new Segell("cc", "cosas", 3.5, parseFecha("03/03/2002"));
        Segell m4 = new Segell("dd", "otros", 4.5, parseFecha("04/04/2003"));
        Segell m5 = new Segell("ee", "no", 5.5, parseFecha("05/05/2004"));
        Segell m6 = new Segell("ff", "Moneda", 2.4, parseFecha("06/06/2005"));
        Segell m7 = new Segell("ff", "Moneda", 2.4, parseFecha("06/06/2005"));

        Contenedor<Segell> contenedor = new Contenedor<>(); // se crea el contenedor generico
        try { // se agrega las monedas al contenedor
            contenedor.guardarObjetoGenerico(m1);
            contenedor.guardarObjetoGenerico(m2);
            contenedor.guardarObjetoGenerico(m3);
            contenedor.guardarObjetoGenerico(m4);
            contenedor.guardarObjetoGenerico(m5);
            contenedor.guardarObjetoGenerico(m6);
            contenedor.guardarObjetoGenerico(m7);
        } catch (ElementoDuplicadoException e) {
            System.out.printf("ERROR: " + e.getMessage()); // mostrara el mensaje de la excepcion personalizada creada
        }


        System.out.println("\n========================================");
        System.out.println("MUESTRA DEL CONTENEDOR SIN APLICAR NADA");
        contenedor.mostrarDatos();

        System.out.println("========================================");
        System.out.println("MUESTRA ORDENADA POR VALOR DE LA MONEDA (VALOR) - ORDEN DECRECIENTE");
        contenedor.ordenarPorValor();
        contenedor.mostrarDatos();

        System.out.println("========================================");
        System.out.println("MUESTRA ORDENADA POR LAS LETRAS DEL CAMPO IMAGEN (ALFABETICO)");
        contenedor.ordenarPorAlfabeto();
        contenedor.mostrarDatos();

        System.out.println("========================================");
        System.out.println("MUESTRA ORDENADA POR FECHA (CRONOLOGICO)");
        contenedor.ordenarPorFecha();
        contenedor.mostrarDatos();

        System.out.println("========================================");
        System.out.println("MUESTRA RECORRIDA CON ITERADOR (ITERATOR)");

        Iterator<Segell> it1 = contenedor.iterator();
        while (it1.hasNext()){
            Segell segell = it1.next();
            System.out.println(segell);
        }

        System.out.println("========================================");
        System.out.println("MUESTRA RECORRIDA CON ITERADOR CON VALOR NIMINO DE LA MONEDA");

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese 'Valor' minimo de atributo para iterar los objetos: ");
        double minVal = sc.nextDouble();

        Iterator<Segell> it2 = contenedor.iterarPorValor(minVal);
        while (it2.hasNext()){
            Segell segell = it2.next();
            System.out.println(segell);
        }

        System.out.println("========================================");
        System.out.println("USANDO METODO CREADO indexOf");

        ArrayList<Segell> otrasSegell = contenedor.getGenerico();
        for (int i = 0; i < otrasSegell.size(); i++) {
            System.out.println("La moneda de " + otrasSegell.get(i).getValor() + " se encuentra en el indice: " +  contenedor.indexOf(otrasSegell.get(i)));
        }

    }
}
