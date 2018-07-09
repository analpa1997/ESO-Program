/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import AccionesBotones.AccionesMostrarRoster;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import program.model.Equipo.Roster;
import program.model.Jugador.Jugador;

/**
 *
 * @author Antonio
 */
public class MostrarRoster extends AbstractPanel {

        private Roster equipo;

        /**
         * Creates new form MostrarRoster
         */
        public MostrarRoster() {
                initComponents();
        }

        public MostrarRoster(Roster equipo) {
                this();
                this.equipo = equipo;
                refrescarPlantilla(equipo.toString());
        }

        public void refrescarPlantilla(String texto) {
                plantillaLabel.setText("<html>" + equipo.escribirHTML(texto) + "</html>");
                plantillaLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        }

        public String organizarPorNacionalidades() {
                String texto = "";
                String nacActual = "";
                String grupoJugadores = "";
                String cabecera = "";
                String lineaSeparadora = "----------------------------------------------------\n\n";
                for (Jugador j : equipo.getJugadores()) {
                        if (nacActual.equals("")) {
                                cabecera = "Jugadores de " + j.getNacionalidad() + ": ";
                                nacActual = j.getNacionalidad();
                        }
                        if (!nacActual.equals(j.getNacionalidad())) {
                                int jugadores = grupoJugadores.split("\n").length;
                                if (jugadores == 1) {
                                        cabecera += jugadores + " jugador\n";
                                } else {
                                        cabecera += jugadores + " jugadores\n";
                                }
                                cabecera += lineaSeparadora;
                                texto += cabecera;
                                texto = texto + grupoJugadores + "\n";
                                grupoJugadores = "";
                                cabecera = "Jugadores de " + j.getNacionalidad() + ": ";
                                nacActual = j.getNacionalidad();
                        }
                        grupoJugadores = grupoJugadores + j.toString() + "\n";
                }
                int jugadores = grupoJugadores.split("\n").length;
                if (jugadores == 1) {
                        cabecera += jugadores + " jugador\n";
                } else {
                        cabecera += jugadores + " jugadores\n";
                }
                cabecera += lineaSeparadora;
                texto += cabecera;
                texto = texto + grupoJugadores + "\n";
                texto = "<pre>" + texto + "</pre>";
                return texto;
        }

        public void inicializarBotones() {
                ((AccionesMostrarRoster) this.getListeners().get("Mostrar Roster")).setLlamada(this);
                ((AccionesMostrarRoster) this.getListeners().get("Mostrar Roster")).inicializarBooleans();
                botonSalir.setActionCommand("salir");
                orderNombre.setActionCommand("ordenarNombre");
                orderEdad.setActionCommand("ordenarEdad");
                orderMedia.setActionCommand("ordenarMedia");
                orderRendimiento.setActionCommand("ordenarRendimiento");
                orderPais.setActionCommand("ordenarNacionalidad");
                saveInformacion.setActionCommand("gInformacion");
                botonSalir.addActionListener(this.getListeners().get("Mostrar Roster"));
                orderNombre.addActionListener(this.getListeners().get("Mostrar Roster"));
                orderEdad.addActionListener(this.getListeners().get("Mostrar Roster"));
                orderMedia.addActionListener(this.getListeners().get("Mostrar Roster"));
                orderRendimiento.addActionListener(this.getListeners().get("Mostrar Roster"));
                orderPais.addActionListener(this.getListeners().get("Mostrar Roster"));
                saveInformacion.addActionListener(this.getListeners().get("Mostrar Roster"));
        }

        public void guardarTexto() {
                String texto = plantillaLabel.getText();
                texto = texto.replaceAll("<pre>", "");
                texto = texto.replaceAll("</pre>", "");
                texto = texto.replaceAll("<html>", "");
                texto = texto.replaceAll("</html>", "");
                texto = texto.replaceAll("<br>", "\n");
                String fileName = JOptionPane.showInputDialog("Introduce el nombre del archivo (sin extensión) donde quieres guardar la información (se guarda en .txt)", "");
                FileWriter fichero;
                try {
                        fichero = new FileWriter(fileName + ".txt");
                        PrintWriter pW = new PrintWriter(fichero);
                        String[] aux = texto.split("\n");
                        for (String s : aux) {
                                pW.println(s);
                        }
                        pW.close();
                        fichero.close();
                } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                }

        }

        public Roster getEquipo() {
                return equipo;
        }

        public void setEquipo(Roster equipo) {
                this.equipo = equipo;
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

                contenedorPlantilla = new javax.swing.JScrollPane();
                jPanel1 = new javax.swing.JPanel();
                plantillaLabel = new javax.swing.JLabel();
                orderMedia = new javax.swing.JButton();
                orderNombre = new javax.swing.JButton();
                orderRendimiento = new javax.swing.JButton();
                orderEdad = new javax.swing.JButton();
                botonSalir = new javax.swing.JButton();
                saveInformacion = new javax.swing.JButton();
                orderPais = new javax.swing.JButton();

                setLayout(new java.awt.GridBagLayout());

                jPanel1.setLayout(new java.awt.GridBagLayout());

                plantillaLabel.setText("jLabel1");
                jPanel1.add(plantillaLabel, new java.awt.GridBagConstraints());

                contenedorPlantilla.setViewportView(jPanel1);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = 3;
                gridBagConstraints.gridheight = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.4;
                gridBagConstraints.weighty = 0.1;
                add(contenedorPlantilla, gridBagConstraints);

                orderMedia.setText("Ordenar por Media");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 2, 6);
                add(orderMedia, gridBagConstraints);

                orderNombre.setText("Ordenar Por Nombre");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 2, 6);
                add(orderNombre, gridBagConstraints);

                orderRendimiento.setText("Ordenar por Rendimiento");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.2;
                gridBagConstraints.insets = new java.awt.Insets(6, 6, 5, 6);
                add(orderRendimiento, gridBagConstraints);

                orderEdad.setText("Ordenar por Edad");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 2, 6);
                add(orderEdad, gridBagConstraints);

                botonSalir.setText("Salir");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 3;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.2;
                gridBagConstraints.insets = new java.awt.Insets(6, 5, 5, 5);
                add(botonSalir, gridBagConstraints);

                saveInformacion.setText("Guardar Información");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.2;
                gridBagConstraints.insets = new java.awt.Insets(6, 5, 5, 5);
                add(saveInformacion, gridBagConstraints);

                orderPais.setText("Ordenar por Nacionalidad");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 2, 6);
                add(orderPais, gridBagConstraints);
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton botonSalir;
        private javax.swing.JScrollPane contenedorPlantilla;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JButton orderEdad;
        private javax.swing.JButton orderMedia;
        private javax.swing.JButton orderNombre;
        private javax.swing.JButton orderPais;
        private javax.swing.JButton orderRendimiento;
        private javax.swing.JLabel plantillaLabel;
        private javax.swing.JButton saveInformacion;
        // End of variables declaration//GEN-END:variables
}
