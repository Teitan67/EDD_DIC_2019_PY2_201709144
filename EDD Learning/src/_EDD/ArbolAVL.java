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
import java.util.ArrayList;
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
    public String labels = "label=\"Arboles AVL\";";
    public String nodos = "";
    public String rotacion = "";
    public ArrayList in;

    public ArbolAVL() {
        raiz = null;
        in = new ArrayList();
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
        nodos = "";
        rotacion = "";
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
                        rotacion = "I";
                    } else {
                        nuevoPadre = rotacionDobleIzquierda(subArb);
                        // System.out.println("II");
                        rotacion = "II";
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
                        rotacion = "D";
                        // System.out.println("D");
                    } else {
                        nuevoPadre = rotacionDobleDerecha(subArb);
                        //System.out.println("DD");
                        rotacion = "DD";
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
        nodos = "";

        nodoAvl nuevo = new nodoAvl(d);
        if (raiz == null) {
            raiz = nuevo;
            posOrderG(raiz, -1);
        } else {
            raiz = insertarAVL(nuevo, raiz);
        }
        graficar();
        //Recorridos
    }

    public void inOrder(nodoAvl r) {
        if (r != null) {
            inOrder(r.hIzquierdo);
            System.out.print(r.dato + " , ");
            in.add(r.dato);
            inOrder(r.hDerecho);
        }
    }

    public void preOrder(nodoAvl r) {
        if (r != null) {
            in.add(r.dato);
            System.out.print(r.dato + " , ");
            preOrder(r.hIzquierdo);
            preOrder(r.hDerecho);
        }
    }

    public void posOrder(nodoAvl r) {
        if (r != null) {
            posOrder(r.hIzquierdo);
            posOrder(r.hDerecho);
            in.add(r.dato);
            System.out.print(r.dato + " , ");
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

    public nodoAvl buscar(nodoAvl inicio, int buscando) {
        nodoAvl aux=null;
        
        if (inicio.dato == buscando) {
            aux= inicio;
        } else {
            if (buscando < inicio.dato) {
                if (inicio.hIzquierdo != null) {
                   aux= buscar(inicio.hIzquierdo, buscando);
                } else {
                    System.out.println("Menor");
                    aux= null;
                }
            } else {
                if (inicio.hDerecho != null) {
                    aux=buscar(inicio.hDerecho, buscando);
                } else {
                    System.out.println("Mayoer");
                    aux= null;
                }
            }
        }
       
        in.add(inicio.dato);
        System.out.println("Busqueda "+inicio.dato);
        return aux;
    }

    public boolean eliminar(int d) {
        nodoAvl aux = raiz;
        nodoAvl padre = raiz;
        boolean esHijoIzq = true;
        while (aux.dato != d) {
            padre = aux;
            if (d < aux.dato) {
                esHijoIzq = true;
                aux = aux.hIzquierdo;
            } else {
                esHijoIzq = false;
                aux = aux.hDerecho;
            }
            if (aux == null) {
                return false;
            }
        }//fin while
        if (aux.hIzquierdo == null && aux.hDerecho == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (esHijoIzq) {
                padre.hIzquierdo = null;
            } else {
                padre.hDerecho = null;
            }
        } else if (aux.hDerecho == null) {
            if (aux == raiz) {
                raiz = aux.hIzquierdo;
            } else if (esHijoIzq) {
                padre.hIzquierdo = aux.hIzquierdo;
            } else {

                padre.hDerecho = aux.hIzquierdo;
            }
        } else if (aux.hIzquierdo == null) {
            if (aux == raiz) {
                raiz = aux.hDerecho;
            } else if (esHijoIzq) {
                padre.hIzquierdo = aux.hDerecho;
            } else {

                padre.hDerecho = aux.hDerecho;
            }
        } else {
            nodoAvl reemplazo = obtenerRemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.hIzquierdo = reemplazo;
            } else {
                padre.hDerecho = reemplazo;
            }
            reemplazo.hIzquierdo = aux.hIzquierdo;
        }
        return true;
    }

    public nodoAvl obtenerRemplazo(nodoAvl nodoRe) {
        nodoAvl remPadre = nodoRe;
        nodoAvl rem = nodoRe;
        nodoAvl aux = nodoRe.hDerecho;
        while (aux != null) {
            remPadre = rem;
            rem = aux;
            aux = aux.hIzquierdo;
        }
        if (rem != nodoRe.hDerecho) {
            remPadre.hIzquierdo = rem.hDerecho;
            rem.hDerecho = nodoRe.hDerecho;
        }
        System.out.println("Nodo reemplazo " + rem.dato);
        return rem;

    }

    public void posOrderG(nodoAvl r, int i) {
        if (r != null) {
            posOrderG(r.hIzquierdo, i);

            if (i == r.dato) {
                labels += " nodo" + r.dato + "[label=\"" + r.dato + "\nFE:" + r.fe + " \",style=filled,fillcolor=red];";
            } else {
                labels += " nodo" + r.dato + "[label=\"" + r.dato + "\nFE:" + r.fe + " \"]; ";
            }
            posOrderG(r.hDerecho, i);

        }
    }

    public void recorrido(nodoAvl r, int i) {
        if (r != null) {

            recorrido(r.hIzquierdo, i);

            if (i == r.dato) {
                labels += " nodo" + r.dato + "[label=\"" + r.dato + "\nFE:" + r.fe + " \",style=filled,fillcolor=blue];";
            } else {
                labels += " nodo" + r.dato + "[label=\"" + r.dato + "\nFE:" + r.fe + " \"]; ";
            }
            recorrido(r.hDerecho, i);

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
            f = new File("C:\\recursos\\COD-G.txt");
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            pw = new PrintWriter(bw);
            pw.write(contenido);
            pw.close();
            bw.close();
            try {
                Runtime.getRuntime().exec("C:\\recursos\\GenerarAVL.bat");
                System.out.println("REPORTE GENERADO...");
                //Runtime.getRuntime().exec(cmd1);
            } catch (IOException ioe) {
                System.out.println("No se genero" + ioe);
            }

        } catch (IOException ex) {
            Logger.getLogger(tablaHash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
