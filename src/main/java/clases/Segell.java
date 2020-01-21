/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import interfaz.InterfaceDataAlfabetic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author pguitart
 */
public class Segell implements Comparable<Segell>, InterfaceDataAlfabetic {
    private static int nSegells = 0;
    
    private final int id;
    private String tipus;
    private String descripcio;
    private double valor;
    private LocalDate data;

    public Segell(String tipus, String descripcio, double valor, LocalDate data) {
        this.tipus = tipus;
        this.descripcio = descripcio;
        this.valor = valor;
        this.data = data;
        nSegells++;
        id = nSegells;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Segell other = (Segell) obj;
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.tipus, other.tipus)) {
            return false;
        }
        if (!Objects.equals(this.descripcio, other.descripcio)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }
    
    
    

    @Override
    public String toString() {
        return "Segell{" + "id=" + id + ", tipus=" + tipus + ", descripcio=" + descripcio + ", valor=" + valor + ", data=" + data + '}';
    }

    //Ordre NATURAL
    @Override
    public int compareTo(Segell o) {
        return (int) (o.valor - valor);
    }

    public String getTipus() {
        return tipus;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public LocalDate getGenericData() {
        return getData();
    }

    @Override
    public String getGenericAlfabetic() {
        return getTipus() + getDescripcio();
        
    }

    @Override
    public int getGenericValor() {
        return 0;
    }

    @Override
    public double getGenericValorDouble() {
        return getValor();
    }


}
