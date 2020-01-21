package principal;

import clases.Contenedor;
import clases.Moneda;
import excepciones.ElementoDuplicadoException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static principal.Metodos.parseFecha;

public class PrincipalMain {
    public static void main(String[] args) {


        Moneda m1 = new Moneda(5, "Moneda", "5 centimos de España", "Catedral de Santiago de Compostela", parseFecha("01/01/2000"));
        Moneda m2 = new Moneda(10, "Moneda", "10 centimos de España", "Miguel de Cervantes", parseFecha("02/02/2010"));
        Moneda m3 = new Moneda(20, "Moneda", "20 centimos de Andorra", "Iglesia románica de Santa Coloma", parseFecha("03/03/2008"));
        Moneda m4 = new Moneda(50, "Moneda", "50 centimos de la Ciudad del Vaticano", "El papa Francisco", parseFecha("04/04/2017"));
        Moneda m5 = new Moneda(1, "Moneda", "1 euro de Alemania", "El águila", parseFecha("05/05/2006"));
        Moneda m6 = new Moneda(2, "Moneda", "2 euros de Irlanda", "El arpa céltica", parseFecha("03/03/2009"));
        Moneda m7 = new Moneda(2, "Moneda", "2 euros de Irlanda", "El arpa céltica", parseFecha("03/03/2009"));

        Contenedor<Moneda> contenedor = new Contenedor<>(); // se crea el contenedor generico
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

        Iterator<Moneda> it1 = contenedor.iterator();
        while (it1.hasNext()){
            Moneda moneda = it1.next();
            System.out.println(moneda);
        }

        System.out.println("========================================");
        System.out.println("MUESTRA RECORRIDA CON ITERADOR CON VALOR NIMINO DE LA MONEDA");

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese 'Valor' minimo de atributo para iterar los objetos: ");
        int minVal = sc.nextInt();

        Iterator<Moneda> it2 = contenedor.iterarPorValor(minVal);
        while (it2.hasNext()){
            Moneda moneda = it2.next();
            System.out.println(moneda);
        }

        System.out.println("========================================");
        System.out.println("USANDO METODO CREADO indexOf");

        ArrayList<Moneda> otrasMonedas = contenedor.getGenerico();
        for (int i = 0; i < otrasMonedas.size(); i++) {
            System.out.println("La moneda de " + otrasMonedas.get(i).getValor() + " se encuentra en el indice: " +  contenedor.indexOf(otrasMonedas.get(i)));
        }

        //Metodos.parseFecha()








    }
}
