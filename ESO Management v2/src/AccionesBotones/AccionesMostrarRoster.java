/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccionesBotones;

import VPrincipal.ESO_Management_v2;
import java.awt.event.ActionEvent;

/**
 *
 * @author Antonio
 */
public class AccionesMostrarRoster extends Acciones {

        public AccionesMostrarRoster() {
                super();
        }

        public AccionesMostrarRoster(ESO_Management_v2 ventana) {
                super(ventana);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                        case "salir":
                                salir();
                                break;

                }
        }

}
