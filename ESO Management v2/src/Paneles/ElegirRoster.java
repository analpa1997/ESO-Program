/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import VPrincipal.*;
import java.net.URL;
import java.util.*;
import javax.swing.JPanel;
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
        private URL PATH_IMAGEN_GUARDAR;

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
                int botonFinal = 0;
                int tipoPanel;
                ESO_Management_v2 padre = (ESO_Management_v2) this.getPadre();
                PATH_IMAGEN_VACIA = padre.PATH_IMAGEN_VACIA;
                PATH_IMAGEN_GUARDAR = padre.PATH_IMAGEN_GUARDAR;
                this.setListeners(padre.getListeners());
                liga = padre.getLiga();
                String nombrePanel;
                panelGuardarSalir.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Arial", 1, 16)));
                if (equipos.getEquipos().equals(liga.getEquiposLiga().getEquipos())) {
                        tipoPanel = 0;
                } else if (equipos.getEquipos().equals(liga.getSeleccionesLiga().getEquipos())) {
                        tipoPanel = 1;
                } else {
                        tipoPanel = 2;
                }
                for (Roster r : equipos.getEquipos()) {
                        URL path = this.getClass().getClassLoader().getResource("imagenes/escudos/" + r.getAbreviatura() + ".png");
                        PanelConBoton b = addBoton(panelBotones, r.getAbreviatura(), i / 11, i % 11, "mPlantilla", path);
                        i++;
                }
                if (equipos.getEquipos().equals(liga.getEquiposLiga().getEquipos())) {
                        PanelConBoton b = addBoton(panelBotones, "<html><p>Todos los</p><p>Jugadores</p></html>", i / 11, i % 11, "mPlantilla", PATH_IMAGEN_VACIA);
                        i++;
                }
                PanelConBoton guardarSalariosMayMenor = addBoton(panelGuardarSalir, "<html><p>Guardar Salarios</p><p>(mayor a menor)</p></html>", 2, 0, "gSalariosMayMenor", PATH_IMAGEN_VACIA);
                PanelConBoton guardarSalariosAZ = addBoton(panelGuardarSalir, "<html><p>Guardar Salarios</p><p>(orden alfabetico)</p></html>", 3, 0, "gSalariosAZ", PATH_IMAGEN_VACIA);

                switch (tipoPanel) {
                        case 0:
                                nombrePanel = "Equipos de ESO";
                                addBoton(panelGuardarSalir, "Guardar Rosters", 0, 0, "gEquipos", PATH_IMAGEN_GUARDAR);
                                addBoton(panelGuardarSalir, "<html><p>Sumar</p><p>Entrenamientos</p></html>", 4, 0, "sumEntrenamientos", PATH_IMAGEN_VACIA);
                                addBoton(panelGuardarSalir, "<html><p>Sumar Bonus</p><p>de Minutos</p></html>", 5, 0, "sumBonusMinutos", PATH_IMAGEN_VACIA);
                                addBoton(panelGuardarSalir, "Sumar Fit", 6, 0, "sumFit", PATH_IMAGEN_VACIA);
                                addBoton(panelGuardarSalir, "<html><p>Sumar Exp</p><p>por posicion</p></html>", 7, 0, "sumExpPosicion", PATH_IMAGEN_VACIA);
                                botonFinal = 7;

                                break;
                        case 1:
                                nombrePanel = "Selecciones que compiten en ESO";
                                addBoton(panelGuardarSalir, "Guardar Rosters", 0, 0, "gSelecciones", PATH_IMAGEN_GUARDAR);
                                botonFinal = 3;
                                break;
                        case 2:
                                nombrePanel = "Todas las selecciones de ESO";
                                addBoton(panelGuardarSalir, "Guardar Rosters", 0, 0, "gTodasSelecciones", PATH_IMAGEN_GUARDAR);
                                botonFinal = 3;
                                break;
                        default:
                                nombrePanel = "";
                                break;
                }
                addBoton(panelGuardarSalir, "Guardar potenciales", botonFinal + 1, 0, "gPotenciales", padre.PATH_IMAGEN_VACIA);
                addBoton(panelGuardarSalir, "Guardar calidad actual", botonFinal + 2, 0, "gCalidadActual", padre.PATH_IMAGEN_VACIA);
                addBoton(panelGuardarSalir, "Salir", botonFinal + 3, 0, "salir", padre.PATH_IMAGEN_SALIR);
                panelBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, nombrePanel, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Arial", 1, 16)));
        }

        public PanelConBoton addBoton(JPanel panel, String nombreBoton, int posicionX, int posicionY, String comando, URL imagen) {
                PanelConBoton boton = new PanelConBoton(nombreBoton, comando);
                boton.setPadre(this);
                centrarTextoBoton(boton);
                boton.setActionListener(this.getListeners().get("Elegir Roster"));
                java.awt.GridBagConstraints gridBagConstraints;
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridy = posicionX;
                gridBagConstraints.gridx = posicionY;
                gridBagConstraints.weighty = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                panel.add(boton, gridBagConstraints);
                addImagenBoton(boton, imagen);
                return boton;
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

                jScrollPane1 = new javax.swing.JScrollPane();
                panelBotones = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                panelGuardarSalir = new javax.swing.JPanel();

                setLayout(new java.awt.GridBagLayout());

                panelBotones.setLayout(new java.awt.GridBagLayout());
                jScrollPane1.setViewportView(panelBotones);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = 8;
                gridBagConstraints.gridheight = 5;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.4;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
                add(jScrollPane1, gridBagConstraints);

                panelGuardarSalir.setLayout(new java.awt.GridBagLayout());
                jScrollPane2.setViewportView(panelGuardarSalir);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 8;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = 6;
                gridBagConstraints.gridheight = 5;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
                add(jScrollPane2, gridBagConstraints);
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JPanel panelBotones;
        private javax.swing.JPanel panelGuardarSalir;
        // End of variables declaration//GEN-END:variables
}
