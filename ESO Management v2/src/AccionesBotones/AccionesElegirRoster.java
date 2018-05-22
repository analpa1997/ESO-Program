/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccionesBotones;

import Paneles.*;
import VPrincipal.ESO_Management_v2;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import program.model.Equipo.Roster;
import program.model.Liga.Liga;

/**
 *
 * @author Antonio
 */
public class AccionesElegirRoster extends Acciones {

        ESO_Management_v2 pantallaPrincipal;

        public AccionesElegirRoster() {

        }

        public AccionesElegirRoster(ESO_Management_v2 contenedorPpal) {
                this();
                pantallaPrincipal = contenedorPpal;
        }

        public void actionPerformed(ActionEvent e) {
                Stack<JPanel> pantallas = pantallaPrincipal.getPantallas();
                Liga liga = pantallaPrincipal.getLiga();
                switch (e.getActionCommand()) {
                        case "salir":
                                pantallaPrincipal.remove(pantallas.lastElement());
                                pantallas.pop();
                                pantallaPrincipal.add(pantallas.lastElement());
                                pantallas.lastElement().updateUI();
                                pantallas.lastElement().repaint();
                                pantallaPrincipal.repaint();
                                break;
                        case "gEquipos":
                                try {
                                        liga.guardarEquipos();
                                        liga.guardarTodosJugadores();
                                } catch (IOException ex) {
                                        System.err.println("Las plantillas no se pudieron guardar");
                                }
                                break;
                        case "gSelecciones":
                                try {
                                        liga.guardarSeleccionesLiga();
                                } catch (IOException ex) {
                                        System.err.println("Las plantillas no se pudieron guardar");
                                }
                                break;
                        case "gTodasSelecciones":
                                try {
                                        liga.guardarTodasSelecciones();
                                } catch (IOException ex) {
                                        System.err.println("Las plantillas no se pudieron guardar");
                                }
                                break;

                        case "mPlantilla":
                                JButton source = (JButton) e.getSource();
                                String abrev = source.getText().toLowerCase();
                                Roster equipo = null;
                                equipo = liga.buscarEquipo(abrev, liga.getEquipos());
                                if (equipo == null) {
                                        equipo = liga.buscarEquipo(abrev, liga.getSeleccionesLiga());
                                }
                                if (equipo == null) {
                                        equipo = liga.buscarEquipo(abrev, liga.getTodasSelecciones());
                                }
                                MostrarRoster mRoster = new MostrarRoster(equipo);
                                mRoster.setPadre(pantallas.lastElement());
                                ElegirRoster eRoster = (ElegirRoster) pantallas.lastElement();
                                mRoster.setListeners(eRoster.getListeners());
                                pantallaPrincipal.remove(pantallas.lastElement());
                                pantallas.push(mRoster);
                                pantallaPrincipal.add(mRoster);
                                mRoster.updateUI();
                                mRoster.repaint();
                                pantallaPrincipal.repaint();
                                break;
                }
        }

}
