package _EDD;

/**
 *
 * @author Oscar-Laptop
 */
import clases.nodoAvl;

public class ArbolAVL {

    private nodoAvl raiz;
    public String grafo="";
    public String Descripcion="";
    public ArbolAVL() {
        raiz = null;
    }

    public nodoAvl buscar(int d, nodoAvl r) {
        if (raiz == null) {
            return null;
        } else if (r.dato == d) {
            return r;
        } else if (r.dato < d) {
            return buscar(d, r.hDerecho);
        } else {
            return buscar(d, r.hIzquierdo);
        }
    }

    //Factor de equilibreio
    public int obtenerFE(nodoAvl x) {
        if (x == null) {
            return -1;
        } else {
            return x.fe;
        }
    }

    //Rotaciones
    public nodoAvl rotacionIzquierda(nodoAvl c) {
        nodoAvl aux = c.hIzquierdo;
        c.hIzquierdo = aux.hDerecho;
        aux.hDerecho = c;
        c.fe = Math.max(obtenerFE(c.hIzquierdo), obtenerFE(c.hDerecho)) + 1;
        aux.fe = Math.max(obtenerFE(aux.hIzquierdo), obtenerFE(aux.hDerecho)) + 1;
        return aux;
    }

    public nodoAvl rotacionDerecha(nodoAvl c) {
        nodoAvl aux = c.hDerecho;
        c.hDerecho = aux.hIzquierdo;
        aux.hIzquierdo = c;
        c.fe = Math.max(obtenerFE(c.hIzquierdo), obtenerFE(c.hDerecho)) + 1;
        aux.fe = Math.max(obtenerFE(aux.hIzquierdo), obtenerFE(aux.hDerecho)) + 1;
        return aux;
    }

    public nodoAvl rotacionDobleIzquierda(nodoAvl c) {
        nodoAvl tmp;
        c.hIzquierdo = rotacionDerecha(c.hIzquierdo);
        tmp = rotacionIzquierda(c);
        return tmp;
    }

    public nodoAvl rotacionDobleDerecha(nodoAvl c) {
        nodoAvl tmp;
        c.hDerecho = rotacionIzquierda(c.hDerecho);
        tmp = rotacionDerecha(c);
        return tmp;
    }
    //Metodo para insertar

    public nodoAvl insertarAVL(nodoAvl nuevo, nodoAvl subArb) {
        nodoAvl nuevoPadre = subArb;
        if (nuevo.dato < subArb.dato) {
            if (subArb.hIzquierdo == null) {
                subArb.hIzquierdo = nuevo;
            } else {
                subArb.hIzquierdo = insertarAVL(nuevo, subArb.hIzquierdo);
                if (obtenerFE(subArb.hIzquierdo) - obtenerFE(subArb.hDerecho) == 2) {
                    if (nuevo.dato < subArb.hIzquierdo.dato) {
                        nuevoPadre = rotacionIzquierda(subArb);
                    } else {
                        nuevoPadre = rotacionDobleIzquierda(subArb);
                    }
                }
            }
        } else if (nuevo.dato > subArb.dato) {
            if (subArb.hDerecho == null) {
                subArb.hIzquierdo = nuevo;
            } else {
                subArb.hDerecho = insertarAVL(nuevo, subArb);
                if (obtenerFE(subArb.hDerecho) - obtenerFE(subArb.hIzquierdo) == 2) {
                    if (nuevo.dato > subArb.hDerecho.dato) {
                        nuevoPadre = rotacionDerecha(subArb);
                    } else {
                        nuevoPadre = rotacionDobleDerecha(subArb);
                    }
                }
            }

        } else {
        }
        if ((subArb.hIzquierdo == null) && (subArb.hDerecho != null)) {
            subArb.fe = subArb.hDerecho.fe + 1;
        } else if ((subArb.hDerecho == null) && (subArb.hIzquierdo != null)) {
            subArb.fe = subArb.hIzquierdo.fe + 1;
        } else {
            subArb.fe = Math.max(obtenerFE(subArb.hIzquierdo), obtenerFE(subArb.hDerecho)) + 1;
        }
        return nuevoPadre;
    }

    public void insertar(int d) {
        nodoAvl nuevo = new nodoAvl(d);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarAVL(nuevo, raiz);
        }
        //Recorridos
    }
    public void inOrder(nodoAvl r) {
        if(r!=null){
            inOrder(r.hIzquierdo);
            System.out.println(r.dato+" , ");
            inOrder(r.hDerecho);
        }
    }
     public void preOrder(nodoAvl r) {
        if(r!=null){         
            System.out.println(r.dato+" , ");
            preOrder(r.hIzquierdo);
            preOrder(r.hDerecho);
        }
    }
      public void posOrder(nodoAvl r) {
        if(r!=null){         
            posOrder(r.hIzquierdo);
            posOrder(r.hDerecho);
            System.out.println(r.dato+" , ");
        }
    }
      

}
