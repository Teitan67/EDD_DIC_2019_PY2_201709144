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
public class nodoAvl {
    public int dato,fe;
    public nodoAvl hDerecho, hIzquierdo;
    public nodoAvl(int dato){
        this.dato=dato;
        this.hDerecho=null;
        this.hIzquierdo=null;
        this.fe=0;
    };
}
