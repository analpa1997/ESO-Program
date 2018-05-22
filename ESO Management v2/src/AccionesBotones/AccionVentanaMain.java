/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccionesBotones;

import Paneles.*;
import VPrincipal.*;
import java.awt.event.ActionEvent;

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
                                ElegirRoster mPlantillas = new ElegirRoster(liga.getEquipos());
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
                                ElegirRoster mSelecciones = new ElegirRoster(liga.getTodasSelecciones());
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
                                ElegirRoster mSeleccionesLiga = new ElegirRoster(liga.getSeleccionesLiga());
                                mSeleccionesLiga.setPadre(pantallaPrincipal);
                                mSeleccionesLiga.inicializarBotones();
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
                                salir();
                                break;
                }
        }

}
