package _EDD;

/**
 *
 * @author Oscar-Laptop
 */
import clases.nodoAvl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventanas.visorReporteHash;

public class ArbolAVL {

    public nodoAvl raiz;
    public String grafo = "";
    public String Descripcion = "";
    private File f;
    private FileWriter w;
    private BufferedWriter bw;
    private PrintWriter pw;
    private visorReporteHash reporte;
    String labels = "";
    String nodos="";

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
        labels = "";
        nodos="";
        nodoAvl nuevoPadre = subArb;
        if (nuevo.dato < subArb.dato) {
            if (subArb.hIzquierdo == null) {
                subArb.hIzquierdo = nuevo;
                posOrderG(raiz, -1);
            } else {
                subArb.hIzquierdo = insertarAVL(nuevo, subArb.hIzquierdo);
                if (obtenerFE(subArb.hIzquierdo) - obtenerFE(subArb.hDerecho) == 2) {
                    posOrderG(raiz, subArb.dato);
                    if (nuevo.dato < subArb.hIzquierdo.dato) {
                        nuevoPadre = rotacionIzquierda(subArb);
                        // System.out.println("I");
                    } else {
                        nuevoPadre = rotacionDobleIzquierda(subArb);
                        // System.out.println("II");
                    }
                } else {
                    posOrderG(raiz, -1);
                }
            }
        } else if (nuevo.dato > subArb.dato) {
            if (subArb.hDerecho == null) {
                subArb.hDerecho = nuevo;
                posOrderG(raiz, -1);
            } else {
                subArb.hDerecho = insertarAVL(nuevo, subArb.hDerecho);

                if (obtenerFE(subArb.hDerecho) - obtenerFE(subArb.hIzquierdo) == 2) {
                    posOrderG(raiz, subArb.dato);
                    if (nuevo.dato > subArb.hDerecho.dato) {
                        nuevoPadre = rotacionDerecha(subArb);
                        // System.out.println("D");
                    } else {
                        nuevoPadre = rotacionDobleDerecha(subArb);
                        //System.out.println("DD");
                    }
                } else {
                    posOrderG(raiz, -1);
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
        labels = "";
        nodos="";
        nodoAvl nuevo = new nodoAvl(d);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarAVL(nuevo, raiz);
        }
        //Recorridos
    }

    public void inOrder(nodoAvl r) {
        if (r != null) {
            inOrder(r.hIzquierdo);
            System.out.print(r.dato + " , ");
            inOrder(r.hDerecho);
        }
    }

    public void preOrder(nodoAvl r) {
        if (r != null) {
            inOrder(r.hIzquierdo);
            System.out.print(r.dato + " , ");
            inOrder(r.hDerecho);
        }
    } 

    public void posOrder(nodoAvl r) {
        if (r != null) {
            inOrder(r.hIzquierdo);
            System.out.print(r.dato + " , ");
            inOrder(r.hDerecho);
        }
    }

    public void preOrderG(nodoAvl r) {
        if (r != null) {
            if (r.hIzquierdo != null) {
                nodos += "nodo" + r.dato + "->";
            } else {

                nodos += "nodo" + r.dato + "\n";
            }
            preOrderG(r.hIzquierdo);
            if (r.hDerecho != null) {

                nodos += "nodo" + r.dato + "->";
            } else {
                nodos += "nodo" + r.dato + "\n";

            }
            preOrderG(r.hDerecho);

        }
    }

    public void posOrderG(nodoAvl r, int i) {
        if (r != null) {
            posOrderG(r.hIzquierdo, i);

            if (i == r.dato) {
                labels += " nodo" + r.dato + "[label=\"" + r.dato + "\",style=filled,fillcolor=red];";
            } else {
                labels += " nodo" + r.dato + "[label=\"" + r.dato + "\"]; ";
            }
            posOrderG(r.hDerecho, i);

        }
    }

    public void graficar() {
        preOrderG(raiz);
        String contenido = "digraph G{\n"
                + "\n"
                + labels
                + nodos
                + "}";
        System.out.println(contenido);
        generarReporte(contenido);
    }

    void generarReporte(String contenido) {
        try {
            f = new File("COD-G.txt");
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            pw = new PrintWriter(bw);
            pw.write(contenido);
            pw.close();
            bw.close();
            try {
                Runtime.getRuntime().exec("GenerarAVL.bat");
                //Runtime.getRuntime().exec(cmd1);
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
            System.out.println("REPORTE GENERADO...");
        } catch (IOException ex) {
            Logger.getLogger(tablaHash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
