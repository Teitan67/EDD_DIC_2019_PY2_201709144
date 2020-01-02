/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _EDD;
import clases.Usuario;
/**
 *
 * @author Oscar-Laptop
 */
class nodoHash
{
    String llave;
    Usuario User;
    public nodoHash(String carne, String Nombre,String Apellido,String Password)
    {
        this.llave=carne;
        this.User=new Usuario(Nombre,Apellido,carne,Password);
    }
}
public class tablaHash
{
    private int size;
    private static int [] sizes;
    private int indiceTam;
    private int ocpudados;
    private float porcentajeUtil;
    private float factorUtil;
    private nodoHash [] vectorHash;
    
    public tablaHash()
    {
        this.sizes= new int[]{37,41,43,47,53,59,61,71,73,79,83,89,97,103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271,313,509};
        this.size=0;
        this.ocpudados=0;
        this.factorUtil=55.0f;
        this.size=sizes[indiceTam];
        this.vectorHash=new nodoHash[size];
        this.porcentajeUtil=calcularPorcentajeUtil();
    }
    int funcion1(int clave){
        return clave%size;
    }
    int function2(int clave,int i){
        return (clave % 7 + 1 ) * i;
    }
    float calcularPorcentajeUtil()
    {
        return ((ocpudados*100)/size);
    }
    int generarClave(String carne)
    {
        String codigo="";
        int tmp=0;
        for(int i=0;i<carne.length();i++){
            codigo+=carne.codePointAt(i);
        }
        if(codigo.length()>9)
        {
            return reduccion(codigo);
        }
        else
        {
            return Integer.parseInt(codigo);
        }
    }
    private int reduccion(String codigo){
        int tmp=0;
        while(codigo.length()>9)
        {
            String aux="";
            for(int i=0;i<codigo.length()/2;i++){
                aux+=codigo.charAt(i);
            }
            if(aux.length()>9)
            {
                tmp=reduccion(aux);
                aux="";
            }
            else
            {
                tmp=Integer.parseInt(aux);
                aux="";
            }
            for(int i=codigo.length()/2;i<codigo.length();i++)
            {
                aux+=codigo.charAt(i);
            }
            if(aux.length()>9)
            {
                
            }
        }
        return 0;
    }
    
}
