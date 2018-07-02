/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccionesBotones;

import Paneles.TraspasarJugadores;
import VPrincipal.*;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import program.model.Liga.Liga;

/**
 *
 * @author analp
 */
public class AccionesTraspasarJugadores extends Acciones {

        public AccionesTraspasarJugadores() {
                super();
        }

        public AccionesTraspasarJugadores(ESO_Management_v2 ventana) {
                super(ventana);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                TraspasarJugadores ventanaListener = (TraspasarJugadores) this.getPanelLlamado();
                Liga liga = ((ESO_Management_v2) ventanaListener.getPadre()).getLiga();
                switch (e.getActionCommand()) {
                        case "traspasarJugadores":
                                for (JToggleButton b : ventanaListener.getJugadoresIzq()) {
                                        if (b.isSelected()) {
                                                liga.traspasarJugador(ventanaListener.getEquipoIzq().getAbreviatura(), ventanaListener.getEquipoDer().getAbreviatura(), ventanaListener.getEquipoIzq().buscarJugador(b.getText()));
                                        }
                                }
                                for (JToggleButton b : ventanaListener.getJugadoresDer()) {
                                        if (b.isSelected()) {
                                                liga.traspasarJugador(ventanaListener.getEquipoDer().getAbreviatura(), ventanaListener.getEquipoIzq().getAbreviatura(), ventanaListener.getEquipoDer().buscarJugador(b.getText()));
                                        }
                                }
                                ventanaListener.recargarPanelesJugadores();
                                break;
                        case "salir":
                                salir();
                                break;
                }
        }

}
