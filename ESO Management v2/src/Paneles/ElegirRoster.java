/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import VPrincipal.*;
import java.util.*;
import program.model.Equipo.*;
import program.model.Liga.Liga;

/**
 *
 * @author Antonio
 */
public class ElegirRoster extends AbstractPanel {

        /**
         * Creates new form MostrarPlantillas
         */
        public ElegirRoster() {
                initComponents();
        }

        public ElegirRoster(SortedSet<Roster> equipos, ESO_Management_v2 vPrincipal) {
                this();
                Liga liga = vPrincipal.getLiga();
                int i = 0;
                for (Roster r : equipos) {
                        addBoton(r.getAbreviatura(), i, vPrincipal);
                        i++;
                }
                addBotonSalir("Salir", i, vPrincipal);
                if (equipos.equals(liga.getEquipos())) {
                        addBotonGPlantillas("gEquipos", i, vPrincipal);
                } else if (equipos.equals(liga.getSeleccionesLiga())) {
                        addBotonGPlantillas("gSelecciones", i, vPrincipal);
                } else {
                        addBotonGPlantillas("gTodasSelecciones", i, vPrincipal);
                }
        }

        public void addBoton(String nombreBoton, int posicion, ESO_Management_v2 vPrincipal) {
                PanelConBoton boton = new PanelConBoton(nombreBoton, "mPlantilla", vPrincipal);
                java.awt.GridBagConstraints gridBagConstraints;
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridy = 1 + posicion / 8;
                gridBagConstraints.gridx = posicion % 8;
                gridBagConstraints.weightx = 1;
                gridBagConstraints.weighty = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                add(boton, gridBagConstraints);
        }

        public void addBotonSalir(String nombreBoton, int posicion, ESO_Management_v2 vPrincipal) {
                PanelConBoton boton = new PanelConBoton(nombreBoton, "salir", vPrincipal);
                java.awt.GridBagConstraints gridBagConstraints;
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridy = 2 + posicion / 8;
                gridBagConstraints.gridx = 7;
                gridBagConstraints.weightx = 1;
                gridBagConstraints.weighty = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                add(boton, gridBagConstraints);
        }

        public void addBotonGPlantillas(String comandoBoton, int posicion, ESO_Management_v2 vPrincipal) {
                PanelConBoton boton = new PanelConBoton("Guardar rosters", comandoBoton, vPrincipal);
                java.awt.GridBagConstraints gridBagConstraints;
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridy = 2 + posicion / 8;
                gridBagConstraints.gridx = 0;
                gridBagConstraints.weightx = 1;
                gridBagConstraints.weighty = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                add(boton, gridBagConstraints);
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

                jLabel1 = new javax.swing.JLabel();

                setLayout(new java.awt.GridBagLayout());

                jLabel1.setText("jLabel1");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = 8;
                gridBagConstraints.ipady = 16;
                add(jLabel1, gridBagConstraints);
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel jLabel1;
        // End of variables declaration//GEN-END:variables
}
