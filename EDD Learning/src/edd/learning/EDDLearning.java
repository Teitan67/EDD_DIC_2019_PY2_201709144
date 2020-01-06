package edd.learning;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ventanas.Login;
import ventanas.m_Administrador;
import _EDD.ArbolAVL;
import ventanas.AVL_insertar;
import ventanas.AVL_recorrido;

/**
 *
 * @author Oscar-Laptop
 */
public class EDDLearning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(m_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login inicio = new Login();
        inicio.setVisible(true);

    }
}
