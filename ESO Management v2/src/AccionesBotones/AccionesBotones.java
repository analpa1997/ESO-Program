/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccionesBotones;

import Paneles.*;
import VPrincipal.ESO_Management_v2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class AccionesBotones implements ActionListener {

        ESO_Management_v2 pantallaPrincipal;

        public AccionesBotones() {

        }

        public AccionesBotones(ESO_Management_v2 contenedorPpal) {
                this();
                pantallaPrincipal = contenedorPpal;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                Stack<JPanel> pantallas = pantallaPrincipal.getPantallas();
                Liga liga = pantallaPrincipal.getLiga();
                switch (e.getActionCommand()) {
                        case "mPlantillas":
                                pantallaPrincipal.remove(pantallas.lastElement());
                                ElegirRoster mPlantillas = new ElegirRoster(liga.getEquipos(), pantallaPrincipal);
                                pantallas.push(mPlantillas);
                                pantallaPrincipal.add(pantallas.lastElement());
                                mPlantillas.updateUI();
                                mPlantillas.repaint();
                                pantallaPrincipal.repaint();
                                break;
                        case "mSelecciones":
                                pantallaPrincipal.remove(pantallas.lastElement());
                                ElegirRoster mSelecciones = new ElegirRoster(liga.getTodasSelecciones(), pantallaPrincipal);
                                pantallas.push(mSelecciones);
                                pantallaPrincipal.add(mSelecciones);
                                mSelecciones.updateUI();
                                mSelecciones.repaint();
                                pantallaPrincipal.repaint();
                                break;
                        case "mSeleccionesLiga":
                                pantallaPrincipal.remove(pantallas.lastElement());
                                ElegirRoster mSeleccionesLiga = new ElegirRoster(liga.getSeleccionesLiga(), pantallaPrincipal);
                                pantallas.push(mSeleccionesLiga);
                                pantallaPrincipal.add(mSeleccionesLiga);
                                mSeleccionesLiga.updateUI();
                                mSeleccionesLiga.repaint();
                                pantallaPrincipal.repaint();
                                break;
                        case "salarios":
                                System.out.println("Boton Salarios");
                                break;
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
