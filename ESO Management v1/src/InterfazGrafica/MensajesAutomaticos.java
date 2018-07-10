/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;
import Contenedor.*;
import java.util.*;
import EquipoDep.*;
import java.text.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
/**
 *
 * @author usuario
 */
public class MensajesAutomaticos extends javax.swing.JDialog {
    Contenedor liga;
    Equipo seleccionado = new Equipo();
    LocalDate fecha;
    String fechaW;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
    /**
     * Creates new form MensajesAutomaticos
     */
    public MensajesAutomaticos(java.awt.Frame parent, boolean modal, Contenedor liga) {
        super(parent, modal);
        initComponents();
        actualizarFecha(2017, 1, 1);
        SpinnerNumberModel dia = new SpinnerNumberModel();
        dia.setMinimum(1);
        dia.setMaximum(31);
        jDia.setModel(dia);
        jDia.setValue(Integer.valueOf(1));
        SpinnerNumberModel mes = new SpinnerNumberModel();
        mes.setMinimum(1);
        mes.setMaximum(12);
        jMes.setModel(mes);
        jMes.setValue(Integer.valueOf(1));
        SpinnerNumberModel anyo= new SpinnerNumberModel();
        anyo.setMinimum(2000);
        anyo.setMaximum(2100);
        jA�o.setModel(anyo);
        jA�o.setValue(Integer.valueOf(2000));
        this.setLocationRelativeTo(null);
        this.liga = liga;
        for (Equipo e: liga.getEquipos()){
            if (!e.getAbrev().toLowerCase().equals("lib")){
                jEquipos.addItem(e.getNombre());
            }
        }
        boolean encontrado = false;
        Iterator it = liga.getEquipos().iterator();
        while (it.hasNext() && !encontrado){
            Equipo e = (Equipo) it.next();
            encontrado = e.getNombre().equals(jEquipos.getSelectedItem().toString());
            if (encontrado) seleccionado = e;
        }
        
    }

    /***
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jNombreJugador = new javax.swing.JTextField();
        jDinero = new javax.swing.JTextField();
        jEquipos = new javax.swing.JComboBox<>();
        NombreJugador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jHora = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDia = new javax.swing.JSpinner();
        jMes = new javax.swing.JSpinner();
        jA�o = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Crear Mensaje");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));
        jPanel1.add(jNombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 200, -1));
        jPanel1.add(jDinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 200, -1));

        jEquipos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jEquiposItemStateChanged(evt);
            }
        });
        jEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEquiposActionPerformed(evt);
            }
        });
        jPanel1.add(jEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 200, -1));

        NombreJugador.setText("Jugador");
        jPanel1.add(NombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel1.setText("Equipo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel2.setText("Cantidad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jLabel3.setText("Fecha");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHoraActionPerformed(evt);
            }
        });
        jPanel1.add(jHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 200, -1));

        jLabel4.setText("Hora");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jDia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jDiaStateChanged(evt);
            }
        });
        jPanel1.add(jDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 50, -1));

        jMes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jMesStateChanged(evt);
            }
        });
        jPanel1.add(jMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 60, -1));

        jA�o.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jA�oStateChanged(evt);
            }
        });
        jPanel1.add(jA�o, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 530, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        File mensajes = new File ("Mensajes");
        mensajes.mkdir();
        try {
            FileWriter mensaje = new FileWriter (mensajes + "\\mensaje.txt");
            BufferedWriter bW = new BufferedWriter (mensaje);
            PrintWriter pW = new PrintWriter (bW);
            pW.println("Jugador: " + jNombreJugador.getText());
            pW.println("Equipo que inicia la puja: (" + seleccionado.getAbrev().toLowerCase() + ")." );
            pW.println("Cantidad: " + jDinero.getText());
            pW.println("Fecha: " + fechaW);
            pW.println("Hora: " + jHora.getText());
            pW.println();
            pW.close();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEquiposActionPerformed

    private void jEquiposItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jEquiposItemStateChanged
       boolean encontrado = false;
       Iterator it = liga.getEquipos().iterator();
       while (it.hasNext() && !encontrado){
            Equipo e = (Equipo) it.next();
            encontrado = e.getNombre().equals(jEquipos.getSelectedItem().toString());
            if (encontrado) seleccionado = e;
       }
    }//GEN-LAST:event_jEquiposItemStateChanged

    private void jHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jHoraActionPerformed

    private void jDiaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jDiaStateChanged
        actualizarFecha (fecha.getYear(), fecha.getMonthValue(), (int)jDia.getValue());
    }//GEN-LAST:event_jDiaStateChanged

    private void jMesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jMesStateChanged
        actualizarFecha (fecha.getYear(), (int)jMes.getValue(), fecha.getDayOfMonth());
    }//GEN-LAST:event_jMesStateChanged

    private void jA�oStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jA�oStateChanged
       actualizarFecha ((int)jA�o.getValue(), fecha.getMonthValue(), fecha.getDayOfMonth());
    }//GEN-LAST:event_jA�oStateChanged

    private void actualizarFecha (int a�o, int mes, int dia){
        try{
           fecha = LocalDate.of(a�o, mes, dia);
           fechaW = formato.format(fecha);
           jButton1.setEnabled(true);
        }catch (DateTimeException dE){
            jButton1.setEnabled(false);
        }
    }
    
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
            java.util.logging.Logger.getLogger(MensajesAutomaticos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MensajesAutomaticos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MensajesAutomaticos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MensajesAutomaticos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MensajesAutomaticos dialog = new MensajesAutomaticos(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NombreJugador;
    private javax.swing.JSpinner jA�o;
    private javax.swing.JButton jButton1;
    private javax.swing.JSpinner jDia;
    private javax.swing.JTextField jDinero;
    private javax.swing.JComboBox<String> jEquipos;
    private javax.swing.JTextField jHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner jMes;
    private javax.swing.JTextField jNombreJugador;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
