/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Oscar-Laptop
 */
public class nodoHash {

    public String llave;
    public usuario User;
    public char estado;

    public nodoHash(String carne, String Nombre, String Apellido, String Password) {
        this.llave = carne;
        this.User = new usuario(Nombre, Apellido, carne, Password);
        this.estado='v';
    }
    usuario getUser(){return this.User;}
}