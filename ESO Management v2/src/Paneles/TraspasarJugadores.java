/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import VPrincipal.ESO_Management_v2;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import javax.swing.*;
import program.model.Equipo.*;
import program.model.Jugador.*;

/**
 *
 * @author analp
 */
public class TraspasarJugadores extends AbstractPanel {

        GrupoBoton equiposLeft = new GrupoBoton(), equiposRight = new GrupoBoton();
        Roster equipoIzq = new Roster(), equipoDer = new Roster();
        ArrayList<JToggleButton> jugadoresIzq = new ArrayList(), jugadoresDer = new ArrayList();
        SortedSet<Roster> equipos;

        /**
         * Creates new form TraspasarJugadores
         */
        public TraspasarJugadores() {
                this(new TreeSet<Roster>());
        }

        public TraspasarJugadores(SortedSet<Roster> equipos) {
                initComponents();
                this.equipos = equipos;
        }

        public void inicializarPaneles() {
                inicializarPanelesEquipos();
                inicializarPanelBotones();
        }

        public void setEscuchadores() {
                ESO_Management_v2 padre = (ESO_Management_v2) this.getPadre();
                this.setListeners(padre.getListeners());
                this.getListeners().get("Traspasar Jugadores").setPanelLlamado(this);
        }

        private void inicializarPanelesEquipos() {
                GridBagConstraints restricciones = new GridBagConstraints();
                restricciones.fill = java.awt.GridBagConstraints.BOTH;
                int i = 2;
                for (Roster r : equipos) {
                        restricciones.gridy = i / 2;
                        restricciones.gridx = i % 2;
                        JToggleButton botonIzq = anadirToggleButtonEquipos(r.getAbreviatura(), r.getImagen()), botonDer = anadirToggleButtonEquipos(r.getAbreviatura(), r.getImagen());

                        equiposLeft.add(botonIzq);
                        equiposLeft.getTodosBotones().add(botonIzq);
                        equiposRight.add(botonDer);
                        equiposRight.getTodosBotones().add(botonDer);
                        panelEquipoLeft.add(botonIzq, restricciones);
                        panelEquipoRight.add(botonDer, restricciones);
                        i++;
                }
        }

        private void inicializarPanelBotones() {
                GridBagConstraints restricciones = ((GridBagLayout) panelBotones.getLayout()).getConstraints(panelBotones);
                traspasarJugadores.setActionCommand("traspasarJugadores");
                traspasarJugadores.addActionListener(this.getListeners().get("Traspasar Jugadores"));
                restricciones.gridy = 1;
                PanelConBoton boton = new PanelConBoton("Salir", "salir");
                ESO_Management_v2 padre = (ESO_Management_v2) getPadre();
                boton.setPadre(this);
                boton.getBoton().setHorizontalTextPosition(SwingConstants.CENTER);
                boton.getBoton().setVerticalTextPosition(SwingConstants.BOTTOM);
                boton.setActionListener(this.getListeners().get("Traspasar Jugadores"));
                boton.anadirImagen(padre.PATH_IMAGEN_SALIR, padre.PATH_IMAGEN_VACIA);
                panelBotones.add(boton, restricciones);
        }

        private JToggleButton anadirToggleButtonEquipos(String nombre, ImageIcon imagen) {
                JToggleButton boton = new JToggleButton(nombre);
                boton.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                                JToggleButton source = (JToggleButton) e.getSource();
                                if (equiposLeft.esBotonEsteGrupo(source)) {
                                        equiposLeft.actualizarPanel(equiposRight, source);
                                        cargarJugadores(panelJugadoresLeft, source.getText());
                                } else {
                                        equiposRight.actualizarPanel(equiposLeft, source);
                                        cargarJugadores(panelJugadoresRight, source.getText());
                                }
                                /* System.out.println(botonSeleccionado.getText());
                                if (antiguoBotonSelected != null) {
                                        System.err.println(antiguoBotonSelected.getText());
                                }*/
                        }
                });
                boton.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
                boton.setHorizontalTextPosition(SwingConstants.CENTER);

                boton.setVerticalTextPosition(SwingConstants.BOTTOM);
                return boton;
        }

        private JToggleButton anadirToggleButtonJugadores(String nombre) {
                JToggleButton boton = new JToggleButton(nombre);
                boton.setHorizontalTextPosition(SwingConstants.CENTER);
                return boton;
        }

        public void recargarPanelesJugadores() {
                cargarJugadores(panelJugadoresLeft, equipoIzq.getAbreviatura());
                cargarJugadores(panelJugadoresRight, equipoDer.getAbreviatura());
        }

        public void cargarJugadores(JPanel panel, String nombreEquipo) {
                Roster r = buscarEquipo(equipos, nombreEquipo);
                if (panel == panelJugadoresLeft) {
                        jugadoresIzq = new ArrayList();
                        equipoIzq = r;
                } else {
                        jugadoresDer = new ArrayList();
                        equipoDer = r;
                }
                panel.setLayout(new GridBagLayout());
                GridBagConstraints restricciones = new GridBagConstraints();
                panel.removeAll();
                restricciones.gridx = 0;
                restricciones.gridy = 0;
                JLabel titulo = new JLabel("Equipo: " + nombreEquipo);
                titulo.setHorizontalTextPosition(SwingConstants.CENTER);
                panel.add(titulo);
                restricciones.gridy++;
                restricciones.insets = new Insets(2, 0, 0, 0);
                for (Jugador j : r.getJugadores()) {
                        JToggleButton b = anadirToggleButtonJugadores(j.getNombre());
                        if (panel == panelJugadoresLeft) {
                                jugadoresIzq.add(b);
                        } else {
                                jugadoresDer.add(b);
                        }
                        panel.add(b, restricciones);
                        restricciones.gridy++;
                }
                panel.updateUI();
                panel.repaint();
        }

        private Roster buscarEquipo(SortedSet<Roster> equipos, String abreviatura) {
                Iterator it = equipos.iterator();
                Roster r = null;
                boolean encontrado = false;
                while (!encontrado && it.hasNext()) {
                        r = (Roster) it.next();
                        encontrado = r.getAbreviatura().equals(abreviatura);
                }
                return r;
        }

        public GrupoBoton getEquiposLeft() {
                return equiposLeft;
        }

        public void setEquiposLeft(GrupoBoton equiposLeft) {
                this.equiposLeft = equiposLeft;
        }

        public GrupoBoton getEquiposRight() {
                return equiposRight;
        }

        public void setEquiposRight(GrupoBoton equiposRight) {
                this.equiposRight = equiposRight;
        }

        public SortedSet<Roster> getEquipos() {
                return equipos;
        }

        public void setEquipos(SortedSet<Roster> equipos) {
                this.equipos = equipos;
        }

        public Roster getEquipoIzq() {
                return equipoIzq;
        }

        public void setEquipoIzq(Roster equipoIzq) {
                this.equipoIzq = equipoIzq;
        }

        public Roster getEquipoDer() {
                return equipoDer;
        }

        public void setEquipoDer(Roster equipoDer) {
                this.equipoDer = equipoDer;
        }

        public ArrayList<JToggleButton> getJugadoresIzq() {
                return jugadoresIzq;
        }

        public void setJugadoresIzq(ArrayList<JToggleButton> jugadoresIzq) {
                this.jugadoresIzq = jugadoresIzq;
        }

        public ArrayList<JToggleButton> getJugadoresDer() {
                return jugadoresDer;
        }

        public void setJugadoresDer(ArrayList<JToggleButton> jugadoresDer) {
                this.jugadoresDer = jugadoresDer;
        }

        public JPanel getPanelJugadoresLeft() {
                return panelJugadoresLeft;
        }

        public void setPanelJugadoresLeft(JPanel panelJugadoresLeft) {
                this.panelJugadoresLeft = panelJugadoresLeft;
        }

        public JPanel getPanelJugadoresRight() {
                return panelJugadoresRight;
        }

        public void setPanelJugadoresRight(JPanel panelJugadoresRight) {
                this.panelJugadoresRight = panelJugadoresRight;
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
                jScrollPane1 = new javax.swing.JScrollPane();
                panelEquipoLeft = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                panelJugadoresLeft = new javax.swing.JPanel();
                panelBotones = new javax.swing.JPanel();
                traspasarJugadores = new javax.swing.JButton();
                jScrollPane3 = new javax.swing.JScrollPane();
                panelJugadoresRight = new javax.swing.JPanel();
                jScrollPane4 = new javax.swing.JScrollPane();
                panelEquipoRight = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();

                setLayout(new java.awt.GridBagLayout());

                jPanel1.setLayout(new java.awt.GridBagLayout());

                panelEquipoLeft.setLayout(new java.awt.GridBagLayout());

                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("Elige Equipo");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                panelEquipoLeft.add(jLabel1, gridBagConstraints);

                jScrollPane1.setViewportView(panelEquipoLeft);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
                jPanel1.add(jScrollPane1, gridBagConstraints);

                javax.swing.GroupLayout panelJugadoresLeftLayout = new javax.swing.GroupLayout(panelJugadoresLeft);
                panelJugadoresLeft.setLayout(panelJugadoresLeftLayout);
                panelJugadoresLeftLayout.setHorizontalGroup(
                        panelJugadoresLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 239, Short.MAX_VALUE)
                );
                panelJugadoresLeftLayout.setVerticalGroup(
                        panelJugadoresLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 558, Short.MAX_VALUE)
                );

                jScrollPane2.setViewportView(panelJugadoresLeft);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
                jPanel1.add(jScrollPane2, gridBagConstraints);

                panelBotones.setLayout(new java.awt.GridBagLayout());

                traspasarJugadores.setText("<- Traspasar Jugadores ->");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new java.awt.Insets(256, 30, 273, 46);
                panelBotones.add(traspasarJugadores, gridBagConstraints);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 2;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
                jPanel1.add(panelBotones, gridBagConstraints);

                javax.swing.GroupLayout panelJugadoresRightLayout = new javax.swing.GroupLayout(panelJugadoresRight);
                panelJugadoresRight.setLayout(panelJugadoresRightLayout);
                panelJugadoresRightLayout.setHorizontalGroup(
                        panelJugadoresRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 239, Short.MAX_VALUE)
                );
                panelJugadoresRightLayout.setVerticalGroup(
                        panelJugadoresRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 558, Short.MAX_VALUE)
                );

                jScrollPane3.setViewportView(panelJugadoresRight);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 3;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
                jPanel1.add(jScrollPane3, gridBagConstraints);

                panelEquipoRight.setLayout(new java.awt.GridBagLayout());

                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel2.setText("Elige Equipo");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = 2;
                panelEquipoRight.add(jLabel2, gridBagConstraints);

                jScrollPane4.setViewportView(panelEquipoRight);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 4;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
                jPanel1.add(jScrollPane4, gridBagConstraints);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                add(jPanel1, gridBagConstraints);
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JPanel panelBotones;
        private javax.swing.JPanel panelEquipoLeft;
        private javax.swing.JPanel panelEquipoRight;
        private javax.swing.JPanel panelJugadoresLeft;
        private javax.swing.JPanel panelJugadoresRight;
        private javax.swing.JButton traspasarJugadores;
        // End of variables declaration//GEN-END:variables
}
