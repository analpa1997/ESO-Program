/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Data.*;
import Data.escribirAlineaciones.*;
import java.awt.Dimension;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio
 */
public class Actualizador extends javax.swing.JFrame {

        Contenedor liga = new Contenedor();
        ArrayList<ArchivosStt> estadisticas = new ArrayList();
        SEquipo equipoSemana;
        AlineacionWriter aW = new AlineacionWriter();

        /**
         * Creates new form Actualizador
         */
        public Actualizador() throws IOException {
                initComponents();
                jLog.setText("");
                try {
                        liga.cargarDatos();
                        FileReader stats = new FileReader("stats.dir");
                        BufferedReader bR = new BufferedReader(stats);
                        String s;
                        while ((s = bR.readLine()) != null) {
                                FileReader archivo = new FileReader(s);
                                BufferedReader bArchivo = new BufferedReader(archivo);
                                estadisticas.add(new ArchivosStt(bArchivo, liga));
                        }
                } catch (Exception ex) {
                        new JOptionPane(ex.getMessage()).setVisible(true);
                }
                this.setSize(new Dimension(700, 500));
                this.setLocationRelativeTo(null);
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
                java.awt.GridBagConstraints gridBagConstraints;

                jPanel1 = new javax.swing.JPanel();
                jButton1 = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                jLog = new javax.swing.JTextArea();
                jSeparator1 = new javax.swing.JSeparator();
                jSeparator2 = new javax.swing.JSeparator();
                jSeparator3 = new javax.swing.JSeparator();
                jSeparator4 = new javax.swing.JSeparator();
                fitPorteros = new javax.swing.JButton();
                jDf = new javax.swing.JTextField();
                jDm = new javax.swing.JTextField();
                jMf = new javax.swing.JTextField();
                jAm = new javax.swing.JTextField();
                jFw = new javax.swing.JTextField();
                jSeparator9 = new javax.swing.JSeparator();
                jInfoDf = new javax.swing.JLabel();
                jInfoDm = new javax.swing.JLabel();
                jInfoMf = new javax.swing.JLabel();
                jInfoAm = new javax.swing.JLabel();
                jInfoFw = new javax.swing.JLabel();
                jSeparator10 = new javax.swing.JSeparator();
                jSeparator11 = new javax.swing.JSeparator();
                jTitulo = new javax.swing.JLabel();
                jNombreEquipo = new javax.swing.JTextField();
                jElegirNombreEquipo = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setLayout(new java.awt.GridBagLayout());

                jButton1.setText("Actualizar Liga");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 9;
                gridBagConstraints.gridwidth = 10;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
                jPanel1.add(jButton1, gridBagConstraints);

                jLog.setColumns(20);
                jLog.setRows(5);
                jScrollPane2.setViewportView(jLog);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 11;
                gridBagConstraints.gridwidth = 11;
                gridBagConstraints.gridheight = 10;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 1.3;
                gridBagConstraints.weighty = 2.1;
                jPanel1.add(jScrollPane2, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = 13;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weighty = 0.2;
                jPanel1.add(jSeparator1, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.gridheight = 20;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.2;
                jPanel1.add(jSeparator2, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 12;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.gridheight = 20;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.2;
                jPanel1.add(jSeparator3, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 21;
                gridBagConstraints.gridwidth = 13;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weighty = 0.2;
                jPanel1.add(jSeparator4, gridBagConstraints);

                fitPorteros.setText("Fit a 100 (porteros)");
                fitPorteros.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                fitPorterosActionPerformed(evt);
                        }
                });
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 3;
                gridBagConstraints.gridy = 10;
                gridBagConstraints.gridwidth = 5;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(2, 0, 5, 0);
                jPanel1.add(fitPorteros, gridBagConstraints);

                jDf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jDf.setText("4");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 7;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 0.3;
                gridBagConstraints.weighty = 0.1;
                jPanel1.add(jDf, gridBagConstraints);

                jDm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jDm.setText("1");
                jDm.setToolTipText("");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 3;
                gridBagConstraints.gridy = 7;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 0.3;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
                jPanel1.add(jDm, gridBagConstraints);

                jMf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jMf.setText("2");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 5;
                gridBagConstraints.gridy = 7;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 0.3;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
                jPanel1.add(jMf, gridBagConstraints);

                jAm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jAm.setText("1");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 7;
                gridBagConstraints.gridy = 7;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 0.3;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 21);
                jPanel1.add(jAm, gridBagConstraints);

                jFw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jFw.setText("2");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 9;
                gridBagConstraints.gridy = 7;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 0.3;
                gridBagConstraints.weighty = 0.1;
                jPanel1.add(jFw, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 8;
                gridBagConstraints.gridwidth = 11;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weighty = 0.1;
                jPanel1.add(jSeparator9, gridBagConstraints);

                jInfoDf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jInfoDf.setText("DF");
                jInfoDf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 5;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weighty = 0.1;
                jPanel1.add(jInfoDf, gridBagConstraints);

                jInfoDm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jInfoDm.setText("DM");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 3;
                gridBagConstraints.gridy = 5;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weighty = 0.1;
                jPanel1.add(jInfoDm, gridBagConstraints);

                jInfoMf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jInfoMf.setText("MF");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 5;
                gridBagConstraints.gridy = 5;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weighty = 0.1;
                jPanel1.add(jInfoMf, gridBagConstraints);

                jInfoAm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jInfoAm.setText("AM");
                jInfoAm.setToolTipText("");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 7;
                gridBagConstraints.gridy = 5;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weighty = 0.1;
                jPanel1.add(jInfoAm, gridBagConstraints);

                jInfoFw.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jInfoFw.setText("FW");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 9;
                gridBagConstraints.gridy = 5;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weighty = 0.1;
                jPanel1.add(jInfoFw, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 6;
                gridBagConstraints.gridwidth = 11;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weighty = 0.1;
                jPanel1.add(jSeparator10, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.gridwidth = 11;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weighty = 0.1;
                jPanel1.add(jSeparator11, gridBagConstraints);

                jTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jTitulo.setText("Elige la formaci�n usada para el 11 de la jornada");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.gridwidth = 13;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weighty = 0.1;
                jPanel1.add(jTitulo, gridBagConstraints);

                jNombreEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jNombreEquipo.setText("Equipo de la semana");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.gridwidth = 11;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.insets = new java.awt.Insets(5, 3, 5, 3);
                jPanel1.add(jNombreEquipo, gridBagConstraints);

                jElegirNombreEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jElegirNombreEquipo.setText("Elige el nombre del equipo de la jornada");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.gridwidth = 11;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(8, 6, 8, 6);
                jPanel1.add(jElegirNombreEquipo, gridBagConstraints);

                getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                FileWriter subidas = null;
                FileReader reports = null;
                try {
                        reports = new FileReader("reports.txt");
                        BufferedReader bR = new BufferedReader(reports);
                        subidas = new FileWriter("resumen.txt", true);
                        BufferedWriter bW = new BufferedWriter(subidas);
                        PrintWriter pW = new PrintWriter(bW);
                        String[] sancionesYLesiones = new String[2];
                        sancionesYLesiones[0] = "";
                        sancionesYLesiones[1] = "";
                        String sLog = jLog.getText();
                        pW.println("[spoiler=\"ESTADISTICAS\"]<pre>");
                        String s = "";
                        pW.println("[b]RESULTADOS DE LA JORNADA[/b]");
                        pW.println();
                        while ((s = bR.readLine()) != null) {
                                pW.println(s);
                        }
                        pW.println();
                        s = "";
                        for (ArchivosStt a : estadisticas) {
                                s += a.escribirSkillsch(a.jLocal, a.local);
                                sLog += "Actualizadas medias y experiencias: " + a.local.getAbrev() + ".txt\n";
                                s += a.escribirSkillsch(a.jVisitante, a.visitante);
                                sLog += "Actualizadas medias y experiencias: " + a.visitante.getAbrev() + ".txt\n";
                                jLog.setText(sLog);
                        }
                        String[] cadena = s.split("\n");
                        s = "";
                        for (ArchivosStt a : estadisticas) {
                                try {
                                        a.actualizarBase(25, liga, a.local, a.jLocal);
                                        sLog += "Actualizadas estadisticas y fit: " + a.local.getAbrev() + ".txt\n";
                                        a.actualizarBase(25, liga, a.visitante, a.jVisitante);
                                        sLog += "Actualizadas estadisticas y fit: " + a.visitante.getAbrev() + ".txt\n";
                                        jLog.setText(sLog);
                                } catch (IOException ex) {
                                        jLog.setText("Error al actualizar las estad�sticas: " + ex.getMessage());
                                }
                        }
                        pW.println();
                        pW.println("[b]MEDIAS[/b]");
                        pW.println();
                        for (int i = 0; i < cadena.length; i++) {
                                pW.println(cadena[i]);
                        }
                        pW.println();
                        pW.println("[b]LESIONES[/b]");
                        pW.println();
                        for (ArchivosStt a : estadisticas) {
                                sancionesYLesiones = a.escribirLesiones(a.local, a.jLocal, sancionesYLesiones);
                                sLog += "Actualizadas lesiones: " + a.local.getAbrev() + ".txt\n";
                                sancionesYLesiones = a.escribirLesiones(a.visitante, a.jVisitante, sancionesYLesiones);
                                sLog += "Actualizadas lesiones:  " + a.visitante.getAbrev() + ".txt\n";
                                jLog.setText(sLog);
                        }
                        s = sancionesYLesiones[0] + sancionesYLesiones[1];
                        cadena = s.split("\n");
                        for (int i = 0; i < cadena.length; i++) {
                                pW.println(cadena[i]);
                        }
                        pW.println();
                        sancionesYLesiones[0] = "";
                        sancionesYLesiones[1] = "";
                        s = "";
                        pW.println("[b]SANCIONES[/b]");
                        pW.println();
                        for (ArchivosStt a : estadisticas) {
                                sancionesYLesiones = a.escribirSanciones(a.local, a.jLocal, sancionesYLesiones);
                                sLog += "Actualizada s sanciones: " + a.local.getAbrev() + ".txt\n";
                                sancionesYLesiones = a.escribirSanciones(a.visitante, a.jVisitante, sancionesYLesiones);
                                sLog += "Actualizadas sanciones:  " + a.visitante.getAbrev() + ".txt\n";
                                jLog.setText(sLog);
                        }
                        s = sancionesYLesiones[0] + sancionesYLesiones[1];
                        cadena = s.split("\n");
                        for (int i = 0; i < cadena.length; i++) {
                                pW.println(cadena[i]);
                        }
                        pW.println("</pre>[/spoiler]");
                        pW.println();
                        pW.close();
                        FileReader ratings = new FileReader("ratings.txt");
                        bR = new BufferedReader(ratings);
                        equipoSemana = new SEquipo(liga, bR, jNombreEquipo.getText());
                        String[] formacionElegidaStr = {jDf.getText(), jDm.getText(), jMf.getText(), jAm.getText(), jFw.getText()};
                        int[] formacionElegida = new int[5];
                        for (int i = 0; i < formacionElegida.length; i++) {
                                formacionElegida[i] = Integer.parseInt(formacionElegidaStr[i]);
                        }
                        equipoSemana.elegirAlineacion(formacionElegida);
                        aW.escribirFormacion(equipoSemana);
                        sLog += "Escogido equipo de la semana\n";
                        jLog.setText(sLog);
                        try {
                                liga.guardarEquipos();
                                sLog += "\n\n\n\n\n\nTODO ACTUALIZADO CORRECTAMENTE";
                                jLog.setText(sLog);
                        } catch (IOException ex) {
                                jLog.setText("Error, no se pudieron actualizar las plantillas: " + ex.getMessage());
                        }

                } catch (IOException ex) {
                        new JOptionPane(ex.getMessage()).setVisible(true);
                }
        }//GEN-LAST:event_jButton1ActionPerformed

        private void fitPorterosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fitPorterosActionPerformed
                for (Equipo e : liga.getEquipos()) {
                        for (Jugador j : e.getRoster()) {
                                if (j.getPosicion().equals(Jugador.Posicion.gk)) {
                                        j.getStats().setFit(100);
                                }
                        }
                }
                try {
                        liga.guardarEquipos();
                        jLog.setText("Fit de los porteros puesto a 100");
                } catch (IOException ex) {
                        jLog.setText("Error, no se pudieron actualizar las plantillas: " + ex.getMessage());
                }
        }//GEN-LAST:event_fitPorterosActionPerformed

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
                        java.util.logging.Logger.getLogger(Actualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(Actualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(Actualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Actualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        new Actualizador().setVisible(true);
                                } catch (IOException ex) {
                                        System.out.println("Error");
                                }
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton fitPorteros;
        private javax.swing.JTextField jAm;
        private javax.swing.JButton jButton1;
        private javax.swing.JTextField jDf;
        private javax.swing.JTextField jDm;
        private javax.swing.JLabel jElegirNombreEquipo;
        private javax.swing.JTextField jFw;
        private javax.swing.JLabel jInfoAm;
        private javax.swing.JLabel jInfoDf;
        private javax.swing.JLabel jInfoDm;
        private javax.swing.JLabel jInfoFw;
        private javax.swing.JLabel jInfoMf;
        private javax.swing.JTextArea jLog;
        private javax.swing.JTextField jMf;
        private javax.swing.JTextField jNombreEquipo;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JSeparator jSeparator10;
        private javax.swing.JSeparator jSeparator11;
        private javax.swing.JSeparator jSeparator2;
        private javax.swing.JSeparator jSeparator3;
        private javax.swing.JSeparator jSeparator4;
        private javax.swing.JSeparator jSeparator9;
        private javax.swing.JLabel jTitulo;
        // End of variables declaration//GEN-END:variables
}