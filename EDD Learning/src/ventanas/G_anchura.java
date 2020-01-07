/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import _EDD.Cola;
import _EDD.tablaHash;
import clases.nodoGrafo;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Oscar-Laptop
 */
public class G_anchura extends javax.swing.JFrame {

    /**
     * Creates new form G_matriz
     */
    nodoGrafo Nodo;
    ArrayList nodos;
    String contenido = "";
    int iterador = 0;
    Cola cola;
    String contenido21 = "";
    int velocidad = 0;

    public G_anchura() {
        initComponents();
        abrirJson();
        cola = new Cola();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jLabel1);

        jScrollPane2.setViewportView(jLabel2);

        jButton1.setText("Mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Iniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Siguiete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Autotatico");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(170, 170, 170)
                        .addComponent(jButton1)
                        .addGap(88, 88, 88)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 61, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            Thread.sleep(2000);
            mostrarImagen();
        } catch (InterruptedException ex) {
            Logger.getLogger(AVL_recorrido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        generarReporteA();
        generarReporteB();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        recorrer();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        velocidad = Integer.parseInt(jTextField1.getText()) * 1000;
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                //Metodo ejecucion automatica
                recorrer();

                try {
                    Thread.sleep(1500);
                    mostrarImagen();
                } catch (InterruptedException ex) {
                    Logger.getLogger(AVL_recorrido.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        };

        Timer t = new Timer();
        t.schedule(tarea, velocidad, velocidad);


    }//GEN-LAST:event_jButton4ActionPerformed
    void recorrer() {

        if (nodos.size() > iterador) {

            if (cola.vacia() && cola.visitados.size() == 0) {
                nodoGrafo aux = (nodoGrafo) nodos.get(iterador);
                cola.agregar(aux.nodo);
                contenido21 = "";
                contenido21 = "a \n";
            } else {
                String a = cola.obtener();
                if (a.equals("VACIO")) {
                    String a2 = cola.obtener();
                } else {
                    nodoGrafo aux = (nodoGrafo) nodos.get(iterador);
                    nodoGrafo tmp = buscar(a);
                    for (int o = 0; o < tmp.adyacencia.size(); o++) {
                        intercambioPalabras(tmp.adyacencia);
                        cola.agregar(tmp.adyacencia.get(o).toString());
                        contenido21 += tmp.nodo + "->" + tmp.adyacencia.get(o).toString() + "\n";
                    }
                }
                System.out.println(a);
            }

        } else {
            String a2 = cola.obtener();
        }
        generarReporteA();
        generarReporteB();
        iterador++;
    }

    nodoGrafo buscar(String a) {
        nodoGrafo aux = null;
        nodoGrafo aux2 = null;
        for (int i = 0; i < nodos.size(); i++) {
            aux2 = (nodoGrafo) nodos.get(i);
            if (aux2.nodo.equals(a)) {
                aux = aux2;
                break;
            }
        }
        return aux;
    }

    void abrirJson() {

        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON", "json");
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(filter);
        fc.showOpenDialog(this);
        File Archivo = fc.getSelectedFile();
        JSONParser jsonParser = new JSONParser();
        if (Archivo != null) {

            JSONParser parser = new JSONParser();

            try (Reader reader = new FileReader(Archivo.getAbsolutePath())) {

                JSONObject jsonObject = (JSONObject) parser.parse(reader);

                // loop array
                JSONArray grafo = (JSONArray) jsonObject.get("Graph");
                JSONObject nodosAux;
                JSONArray adyacencia;
                JSONObject adyacenciaAux;
                nodos = new ArrayList();
                String tem1, temp2;
                for (int i = 0; i < grafo.size(); i++) {

                    nodosAux = (JSONObject) grafo.get(i);
                    System.out.println(nodosAux.get("Node"));
                    tem1 = (String) nodosAux.get("Node");
                    adyacencia = (JSONArray) nodosAux.get("Adjacency");
                    Nodo = new nodoGrafo(tem1);

                    for (int ii = 0; ii < adyacencia.size(); ii++) {
                        adyacenciaAux = (JSONObject) adyacencia.get(ii);
                        System.out.println("    " + adyacenciaAux.get("Node"));
                        temp2 = (String) adyacenciaAux.get("Node");
                        Nodo.adyacencia.add(temp2);
                    }
                    nodos.add(Nodo);

                }

            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            } catch (org.json.simple.parser.ParseException ex) {
                Logger.getLogger(m_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    int obtenerPosicicion(String nodo) {
        int aux = -1;
        nodoGrafo tmp = null;
        for (int i = 0; i < nodos.size(); i++) {
            tmp = (nodoGrafo) nodos.get(i);
            if (tmp != null && tmp.nodo.equals(nodo)) {
                aux = i;
                break;
            }
        }
        return aux;
    }

    void generarReporteA() {
        contenido = "";
        if (!cola.vacia()) {
            for (int i = 0; i < cola.cola.size(); i++) {

                contenido += "nodo" + i + "X[label=\"" + cola.cola.get(i) + "\", pos=\"" + i + ",-1!\"] \n";

            }
        } else {
            contenido += "nodo[label=\"" + "VACIA" + "\", pos=\"" + "0" + ",-1!\"] \n";
        }

        String contenido2 = ""
                + "digraph cubo{\n"
                + "    rankdir=LR;\n"
                + "    node [shape = box, color=cornflowerblue];\n"
                + "    graph [ranksep=\"1\"];\n"
                + "\n"
                + "    label=\"Recorrido por anchura\";\n"
                + contenido
                + "\n"
                + "}";
        System.out.println(contenido2);
        generarReporte(contenido2);

    }

    public static void intercambioPalabras(ArrayList lista) {

        //Usamos un bucle anidado
        for (int i = 0; i < (lista.size() - 1); i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).toString().compareToIgnoreCase(lista.get(j).toString()) > 0) {
                    //Intercambiamos valores
                    String variableauxiliar = lista.get(i).toString();
                    String a = lista.get(j).toString();
                    lista.set(i, a);
                    lista.set(j, variableauxiliar);

                }
            }
        }
    }

    void generarReporteB() {

        nodoGrafo aux;
        nodoGrafo aux2;
        for (int i = 0; i < nodos.size(); i++) {

        }
        String contenido2 = ""
                + "digraph cubo{\n"
                + "\n"
                + "    label=\"Grafo\";\n"
                + contenido21
                + "\n"
                + "}";
        System.out.println(contenido2);

        try {
            generarReporteB(contenido2);
            Thread.sleep(2000);

        } catch (InterruptedException ex) {
            Logger.getLogger(AVL_recorrido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void mostrarImagen() {
        try {
            File file = new File("C:\\recursos\\matrix.png");
            Image img = ImageIO.read(file);
            ImageIcon icon = new ImageIcon(img);
            File file2 = new File("C:\\recursos\\grafo.png");
            Image img2 = ImageIO.read(file2);
            ImageIcon icon2 = new ImageIcon(img2);
            jLabel1.setIcon(icon);
            jLabel2.setIcon(icon2);

        } catch (IOException ex) {
            Logger.getLogger(visorReporteHash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void generarReporte(String contenido) {
        try {
            File f = new File("C:\\recursos\\matrix.txt");
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter pw = new PrintWriter(bw);
            pw.write(contenido);
            pw.close();
            bw.close();
            try {
                Runtime.getRuntime().exec("C:\\recursos\\matrix.bat");
                System.out.println("REPORTE GENERADO...");
                //Runtime.getRuntime().exec(cmd1);
            } catch (IOException ioe) {
                System.out.println("No se genero" + ioe);
            }

        } catch (IOException ex) {
            Logger.getLogger(tablaHash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void generarReporteB(String contenido) {
        try {
            File f = new File("C:\\recursos\\grafo.txt");
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter pw = new PrintWriter(bw);
            pw.write(contenido);
            pw.close();
            bw.close();
            try {
                Runtime.getRuntime().exec("C:\\recursos\\grafo.bat");
                System.out.println("REPORTE GENERADO...");
                //Runtime.getRuntime().exec(cmd1);
            } catch (IOException ioe) {
                System.out.println("No se genero" + ioe);
            }

        } catch (IOException ex) {
            Logger.getLogger(tablaHash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(G_anchura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(G_anchura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(G_anchura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(G_anchura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new G_anchura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}