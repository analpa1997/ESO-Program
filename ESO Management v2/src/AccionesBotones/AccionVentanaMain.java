/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccionesBotones;

import Paneles.*;
import VPrincipal.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio
 */
public class AccionVentanaMain extends Acciones {

        public AccionVentanaMain() {
                super();

        }

        public AccionVentanaMain(ESO_Management_v2 ventana) {
                super(ventana);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                        case "mPlantillas":
                                pantallaPrincipal.remove(pantallas.lastElement());
                                ElegirRoster mPlantillas = new ElegirRoster(liga.getEquiposLiga().getEquipos());
                                pantallaPrincipal.getListeners().put("Elegir Roster", new AccionesElegirRoster(pantallaPrincipal, mPlantillas.getEquipos()));
                                mPlantillas.setPadre(pantallaPrincipal);
                                mPlantillas.inicializarBotones();
                                pantallas.push(mPlantillas);
                                pantallaPrincipal.add(pantallas.lastElement());
                                mPlantillas.updateUI();
                                mPlantillas.repaint();
                                pantallaPrincipal.repaint();
                                break;
                        case "mSelecciones":
                                pantallaPrincipal.remove(pantallas.lastElement());
                                ElegirRoster mSelecciones = new ElegirRoster(liga.getTodasSelecciones().getEquipos());
                                pantallaPrincipal.getListeners().put("Elegir Roster", new AccionesElegirRoster(pantallaPrincipal, mSelecciones.getEquipos()));
                                mSelecciones.setPadre(pantallaPrincipal);
                                mSelecciones.inicializarBotones();
                                pantallas.push(mSelecciones);
                                pantallaPrincipal.add(mSelecciones);
                                mSelecciones.updateUI();
                                mSelecciones.repaint();
                                pantallaPrincipal.repaint();
                                break;
                        case "mSeleccionesLiga":
                                pantallaPrincipal.remove(pantallas.lastElement());
                                ElegirRoster mSeleccionesLiga = new ElegirRoster(liga.getSeleccionesLiga().getEquipos());
                                pantallaPrincipal.getListeners().put("Elegir Roster", new AccionesElegirRoster(pantallaPrincipal, mSeleccionesLiga.getEquipos()));
                                mSeleccionesLiga.setPadre(pantallaPrincipal);
                                mSeleccionesLiga.inicializarBotones();
                                pantallas.push(mSeleccionesLiga);
                                pantallaPrincipal.add(mSeleccionesLiga);
                                mSeleccionesLiga.updateUI();
                                mSeleccionesLiga.repaint();
                                pantallaPrincipal.repaint();
                                break;
                        case "traspasos":
                                pantallaPrincipal.remove(pantallas.lastElement());
                                TraspasarJugadores traspasos = new TraspasarJugadores(liga.getEquiposLiga().getEquipos());
                                traspasos.setPadre(pantallaPrincipal);
                                traspasos.setEscuchadores();
                                traspasos.inicializarPaneles();
                                pantallas.push(traspasos);
                                pantallaPrincipal.add(traspasos);
                                traspasos.updateUI();
                                traspasos.repaint();
                                pantallaPrincipal.repaint();
                                break;
                        case "salarios":
                                System.out.println("Boton Salarios");
                                break;
                        case "loadSeleccionesMundial": {
                                try {
                                        this.liga.cargarSeleccionesConFicheros();
                                        JOptionPane.showMessageDialog(null, "Jugadores transferidos correctamente");
                                } catch (IOException ex) {
                                        ex.printStackTrace();
                                        JOptionPane.showMessageDialog(null, ex);
                                }
                        }

                        break;
                        case "devolverJugadoresSelecciones":
                                this.liga.devolverJugadoresSelecciones();
                                JOptionPane.showMessageDialog(null, "Jugadores transferidos correctamente");
                                break;
                        case "salir":
                                salir();
                                break;
                }
        }

}
