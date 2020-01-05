/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _EDD;

import clases.usuario;
import clases.nodoHash;
/**
 *
 * @author Oscar-Laptop
 */


public class tablaHash {

    public int size;
    private static int[] sizes;
    private int indiceTam;
    private int ocupados;
    private float porcentajeUtil;
    private float factorUtil;
    public nodoHash[] vectorHash;

    public tablaHash() {
        this.sizes = new int[]{37, 59, 61, 71, 89, 97, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 313, 509,547,613};
        this.size = 0;
        this.ocupados = 0;
        this.factorUtil = 55.0f;
        this.size = sizes[indiceTam];
        this.vectorHash = new nodoHash[size];
        this.porcentajeUtil = calcularPorcentajeUtil();
        
    }

    int funcion1(int clave) {
        return clave % size;
    }

    int funcion2(int clave, int i) {
        return (clave % 7 + 1) * i;
    }

    float calcularPorcentajeUtil() {
        return ((ocupados * 100) / size);
    }

    int generarClave(String carne) {
        String codigo = "";
        int tmp = 0;
        for (int i = 0; i < carne.length(); i++) {
            codigo += carne.codePointAt(i);
        }
        if (codigo.length() > 9) {
            return reduccion(codigo);
        } else {
            return Integer.parseInt(codigo);
        }
    }

    private int reduccion(String codigo) {
        int tmp = 0;
        while (codigo.length() > 9) {
            String aux = "";
            for (int i = 0; i < codigo.length() / 2; i++) {
                aux += codigo.charAt(i);
            }
            if (aux.length() > 9) {
                tmp = reduccion(aux);
                aux = "";
            } else {
                tmp = Integer.parseInt(aux);
                aux = "";
            }
            for (int i = codigo.length() / 2; i < codigo.length(); i++) {
                aux += codigo.charAt(i);
            }
            if (aux.length() > 9) {
                tmp = reduccion(aux);
                aux = "";
            } else {
                tmp = Integer.parseInt(aux);
                aux = "";
            }
            codigo = tmp + "";
        }
        return tmp;
    }

    private int DobleHashing(String id, int factor) {
        int tmp = generarClave(id);
        return funcion1((tmp) + (factor * funcion2(tmp, factor) % size))%size;
    }

    void reHashing() {
        nodoHash [] tmp=vectorHash;
        int sizeTmp=size;
        if(indiceTam<sizes.length){
            indiceTam+=1;
            if(indiceTam==sizes.length-1){
                System.out.println("Tabla Hash a su maxima capacidad");
            }
        }
        size=sizes[indiceTam];
        vectorHash = new nodoHash[size];
        ocupados=0;
        porcentajeUtil=calcularPorcentajeUtil();
        for(int i=0;i<sizeTmp;i++){
            if(tmp[i]!=null){
                insertar(tmp[i].User.getCarne(),tmp[i].User.getNombre(),tmp[i].User.getApellido(),tmp[i].User.getPassword());
            }
        }
        System.out.println("Rehashin realizado correctamente");

    }

    public String insertar(String carne, String nombre, String apellido, String password) {
        boolean insertado = false;
        String aux = "";
        if (porcentajeUtil <= 55.00f) {
            for (int i = 0; i < size; i++) {
                int posicion = DobleHashing(carne, i);
                if (posicion > size) {
                    posicion -= size;
                }
                if (vectorHash[posicion] == null || vectorHash[posicion].estado == 'b') {
                    vectorHash[posicion] = new nodoHash(carne, nombre, apellido, password);
                    ocupados += 1;
                    porcentajeUtil = calcularPorcentajeUtil();
                    insertado = true;
                    break;
                } else {
                    if (vectorHash[posicion].User.getCarne().equals(carne)) {
                        System.out.println("El usuario " + carne + " ya existe");
                        aux = carne;
                        break;
                    } else {
                        System.out.println("El usuario " + carne + " colisiono en " + posicion);
                    }
                }
            }
            if (insertado) {
                System.out.println("El usuario " + carne + " fue insertado");
            } else {
                 System.out.println("El usuario " + carne + " no fue insertado");
            }

        } else {
            System.out.println("Rehashing -> Porcentaje util: "+porcentajeUtil);
            reHashing();
            insertar(carne, nombre, apellido, password);
        }
        return aux;
    }
    
    public usuario obtenerNodo(String carne){
        boolean encontrado=false;
        usuario tmp = null;
        int pos=0;
        for(int i=0;i<size;i++){
            int posicion=DobleHashing(carne,i);
            if(posicion>=size){
                posicion-=size;
                pos=posicion;
            }
            if(vectorHash[posicion]!=null){
                if(vectorHash[posicion].User.getCarne().equals(carne)&&vectorHash[posicion].estado!='b'){
                    tmp=vectorHash[posicion].User;
                    encontrado=true;
                    break;
                }
            }
        }
        if(encontrado){
            System.out.println("Nodo "+carne+" encontrado");
        }else{
            System.out.println("Nodo "+carne+" no encontrado!!!");
        }
        return tmp;
    }
    public void eliminarNodo(String carne){
        boolean encontrado=false;
        int pos=0;
        for(int i=0;i<size;i++){
            int posicion=DobleHashing(carne,i);
            if(posicion>=size){
                posicion-=size;
                pos=posicion;
            }
            if(vectorHash[posicion]!=null){
                if(vectorHash[posicion].User.getCarne().equals(carne)){
                    vectorHash[posicion].estado='b';
                    encontrado=true;
                    break;
                }
            }
        }
        if(encontrado){
            System.out.println("Nodo "+carne+" borrado :D");
        }else{
            System.out.println("Nodo "+carne+" no encontrado!!!");
        }
    }
    
}
