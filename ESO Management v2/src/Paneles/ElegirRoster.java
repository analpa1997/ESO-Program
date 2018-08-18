/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import VPrincipal.*;
import java.net.URL;
import java.util.*;
import javax.swing.SwingConstants;
import program.model.Equipo.*;
import program.model.Liga.Equipos;
import program.model.Liga.Liga;

/**
 *
 * @author Antonio
 */
public class ElegirRoster extends AbstractPanel {

        Equipos equipos;
        Liga liga;
        private URL PATH_IMAGEN_VACIA;

        /**
         * Creates new form MostrarPlantillas
         */
        public ElegirRoster() {
                super();
                equipos = new Equipos();
                initComponents();
        }

        public ElegirRoster(TreeSet<Roster> teams) {
                this();
                equipos.setEquipos(teams);

        }

        public Equipos getEquipos() {
                return equipos;
        }

        public void setEquipos(Equipos equipos) {
                this.equipos = equipos;
        }

        public void inicializarBotones() {
                int i = 0;
                ESO_Management_v2 padre = (ESO_Management_v2) this.getPadre();
                PATH_IMAGEN_VACIA = padre.PATH_IMAGEN_VACIA;
                this.setListeners(padre.getListeners());
                liga = padre.getLiga();
                for (Roster r : equipos.getEquipos()) {
                        PanelConBoton b = addBoton(r.getAbreviatura(), i);
                        i++;
                }
                if (equipos.getEquipos().equals(liga.getEquiposLiga().getEquipos())) {
                        PanelConBoton b = addBoton("<html><p>Todos los</p><p>Jugadores</p></html>", i);
                        i++;
                }
                PanelConBoton guardarSalariosMayMenor = addBoton("<html><p>Guardar Salarios</p><p>(mayor a menor)</p></html>", 1 + i / 8, 5, "gSalariosMayMenor");
                PanelConBoton guardarSalariosAZ = addBoton("<html><p>Guardar Salarios</p><p>(orden alfabetico)</p></html>", 1 + i / 8, 6, "gSalariosAZ");
                addBotonSalir("Salir", i);
                if (equipos.getEquipos().equals(liga.getEquiposLiga().getEquipos())) {
                        addBotonGPlantillas("gEquipos", i);
                } else if (equipos.getEquipos().equals(liga.getSeleccionesLiga())) {
                        addBotonGPlantillas("gSelecciones", i);
                } else {
                        addBotonGPlantillas("gTodasSelecciones", i);
                }
        }

        public PanelConBoton addBoton(String nombreBoton, int posicionX, int posicionY, String comando) {
                PanelConBoton boton = new PanelConBoton(nombreBoton, comando);
                boton.setPadre(this);
                URL path = this.getClass().getClassLoader().getResource("imagenes/escudos/" + nombreBoton + ".png");
                centrarTextoBoton(boton);
                boton.setActionListener(this.getListeners().get("Elegir Roster"));
                java.awt.GridBagConstraints gridBagConstraints;
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridy = posicionX;
                gridBagConstraints.gridx = posicionY;
                gridBagConstraints.weighty = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;

                panelBotones.add(boton, gridBagConstraints);
                addImagenBoton(boton, path);
                return boton;
        }

        public PanelConBoton addBoton(String nombreBoton, int posicion) {
                PanelConBoton boton = new PanelConBoton(nombreBoton, "mPlantilla");
                boton.setPadre(this);
                URL path = this.getClass().getClassLoader().getResource("imagenes/escudos/" + nombreBoton + ".png");
                centrarTextoBoton(boton);
                boton.setActionListener(this.getListeners().get("Elegir Roster"));
                java.awt.GridBagConstraints gridBagConstraints;
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridy = posicion / 8;
                gridBagConstraints.gridx = posicion % 8;
                gridBagConstraints.weighty = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;

                panelBotones.add(boton, gridBagConstraints);
                addImagenBoton(boton, path);
                return boton;
        }

        public void addBotonSalir(String nombreBoton, int posicion) {
                PanelConBoton boton = new PanelConBoton(nombreBoton, "salir");
                ESO_Management_v2 padre = (ESO_Management_v2) getPadre();
                boton.setPadre(this);
                centrarTextoBoton(boton);
                boton.setActionListener(this.getListeners().get("Elegir Roster"));
                java.awt.GridBagConstraints gridBagConstraints;
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridy = 1 + posicion / 8;
                gridBagConstraints.gridx = 7;
                gridBagConstraints.weighty = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                panelBotones.add(boton, gridBagConstraints);
                addImagenBoton(boton, padre.PATH_IMAGEN_SALIR);
        }

        public void addBotonGPlantillas(String comandoBoton, int posicion) {
                PanelConBoton boton = new PanelConBoton("Guardar rosters", comandoBoton);
                ESO_Management_v2 padre = (ESO_Management_v2) getPadre();
                boton.setPadre(this);
                centrarTextoBoton(boton);
                boton.setActionListener(this.getListeners().get("Elegir Roster"));
                java.awt.GridBagConstraints gridBagConstraints;
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridy = 1 + posicion / 8;
                gridBagConstraints.gridx = 0;
                gridBagConstraints.weighty = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                panelBotones.add(boton, gridBagConstraints);
                addImagenBoton(boton, padre.PATH_IMAGEN_GUARDAR);
        }

        public void addImagenBoton(PanelConBoton boton, URL path) {
                boton.anadirImagen(path, PATH_IMAGEN_VACIA);
        }

        public void centrarTextoBoton(PanelConBoton boton) {
                boton.getBoton().setHorizontalTextPosition(SwingConstants.CENTER);
                boton.getBoton().setVerticalTextPosition(SwingConstants.BOTTOM);
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
                jScrollPane1 = new javax.swing.JScrollPane();
                panelBotones = new javax.swing.JPanel();

                setLayout(new java.awt.GridBagLayout());

                jLabel1.setText("jLabel1");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = 8;
                gridBagConstraints.ipady = 16;
                add(jLabel1, gridBagConstraints);

                panelBotones.setLayout(new java.awt.GridBagLayout());
                jScrollPane1.setViewportView(panelBotones);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.gridwidth = 8;
                gridBagConstraints.gridheight = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                add(jScrollPane1, gridBagConstraints);
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel jLabel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JPanel panelBotones;
        // End of variables declaration//GEN-END:variables
}
