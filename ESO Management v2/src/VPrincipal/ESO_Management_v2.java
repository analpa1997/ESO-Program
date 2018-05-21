/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VPrincipal;

import AccionesBotones.*;
import Paneles.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.*;
import javax.swing.JPanel;
import program.model.Liga.*;

/**
 *
 * @author Antonio
 */
public class ESO_Management_v2 extends javax.swing.JFrame {

        private Liga ESO_Liga = new Liga();

        private Stack<JPanel> pantallas = new Stack();

        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        private final int ANCHO_PANTALLA = screenSize.width;
        private final int ALTO_PANTALLA = screenSize.height;

        private int anchoPrograma = (int) (ANCHO_PANTALLA * 0.85);
        private int altoPrograma = (int) (ALTO_PANTALLA * 0.85);

        private HashMap<String, Acciones> listeners;

        private contenedorPpal primeraPantalla;

        /**
         * Creates new form ESO_Management_v2
         */
        public ESO_Management_v2() {
                initComponents();
                aņadirListeners();
                primeraPantalla = new contenedorPpal();
                primeraPantalla.setPadre(this);
                primeraPantalla.inicializarBotones();
                primeraPantalla.aņadirCuadriculas();
                try {
                        ESO_Liga.cargarPlantillas();
                        ESO_Liga.cargarSelecciones();
                } catch (IOException ex) {
                        System.err.println("No se encontraron las plantillas");
                }
                this.setSize(anchoPrograma, altoPrograma);
                this.setLocationRelativeTo(null);
                this.add(primeraPantalla);
                pantallas.push(primeraPantalla);
        }

        public Stack<JPanel> getPantallas() {
                return pantallas;
        }

        public Liga getLiga() {
                return ESO_Liga;
        }

        public void aņadirListeners() {
                listeners.put("Primera Pantalla", new AccionVentanaMain(this));
        }

        /**
         * This method is called from within the constructor to
         * initialize the form. WARNING: Do NOT modify this code. The
         * content of this method is always regenerated by the Form
         * Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                contenedor = new javax.swing.JPanel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                getContentPane().add(contenedor, java.awt.BorderLayout.CENTER);

                pack();
        }// </editor-fold>//GEN-END:initComponents

        /**
         * @param args the command line arguments
         */
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
                        java.util.logging.Logger.getLogger(ESO_Management_v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(ESO_Management_v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(ESO_Management_v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(ESO_Management_v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new ESO_Management_v2().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel contenedor;
        // End of variables declaration//GEN-END:variables
}
