/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _EDD;

import java.util.ArrayList;

/**
 *
 * @author Oscar-Laptop
import java.util.ArrayList;

/**
 *
 * @author Oscar-Laptop
 */
public class Pila {

    public ArrayList<String> cola;
    public ArrayList<String> visitados;

    public Pila() {
        cola = new <String>ArrayList();
        visitados = new <String>ArrayList();
    }

    public boolean vacia() {
        return cola.size() == 0;
    }

    public void agregar(String aux) {
        if (!repetido(aux)) {
            cola.add(aux);
            visitados.add(aux);
            System.out.println("Insertado");
        } else if (visitados.size() == 0) {
            cola.add(aux);
            visitados.add(aux);
            System.out.println("Insertado");

        }

    }

    public String obtener() {
        String A = "";
        if (cola.size() != 0) {
            A = cola.get(cola.size() - 1);
            cola.remove(cola.size() - 1);

        } else {
            A = "VACIO";
        }
        return A;
    }

    private boolean repetido(String a) {
        boolean aux = false;
        for (int i = 0; i < visitados.size(); i++) {
            if (visitados.get(i).equals(a)) {
                aux = true;
            }
        }
        return aux;
    }
}
