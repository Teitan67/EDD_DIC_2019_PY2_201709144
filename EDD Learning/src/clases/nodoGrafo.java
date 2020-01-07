
package clases;

import java.util.ArrayList;

/**
 *
 * @author Oscar-Laptop
 */
public class nodoGrafo {
   public ArrayList adyacencia;
   public String nodo;
   public nodoGrafo(String nodo){
       this.nodo=nodo;
       adyacencia=new ArrayList();
   }
   public boolean adyacente(String nodo){
       boolean adyacente=false;
       if(adyacencia.size()>0){
           for(int i=0;i<adyacencia.size();i++){
               if(nodo.equals(adyacencia.get(i).toString())){
                   adyacente=true;
                   break;
               }
           }
       }
       
       return adyacente;
   }
}
