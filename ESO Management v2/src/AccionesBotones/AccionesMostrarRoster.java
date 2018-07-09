/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccionesBotones;

import Paneles.MostrarRoster;
import VPrincipal.ESO_Management_v2;
import java.awt.event.ActionEvent;

/**
 *
 * @author Antonio
 */
public class AccionesMostrarRoster extends Acciones {

        private MostrarRoster llamada;
        private boolean mayorMenorEdad = false, mayorMenorNombre = false, mayorMenorRendimiento = false;

        public AccionesMostrarRoster() {
                super();
        }

        public AccionesMostrarRoster(ESO_Management_v2 ventana) {
                super(ventana);
        }

        public MostrarRoster getLlamada() {
                return llamada;
        }

        public void setLlamada(MostrarRoster llamada) {
                this.llamada = llamada;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                int numero = 0;
                switch (e.getActionCommand()) {
                        case "salir":
                                salir();
                                break;
                        case "gInformacion":
                                llamada.guardarTexto();
                                break;
                        case "ordenarMedia":
                                mayorMenorEdad = false;
                                mayorMenorRendimiento = false;
                                mayorMenorNombre = false;
                                numero = -1;
                                llamada.getEquipo().ordenarRoster(-1, 0);
                                llamada.refrescarPlantilla();
                                break;
                        case "ordenarEdad":
                                mayorMenorRendimiento = false;
                                mayorMenorNombre = false;
                                if (mayorMenorEdad) {
                                        numero = 1;
                                } else {
                                        numero = 2;
                                }
                                mayorMenorEdad = !mayorMenorEdad;
                                llamada.getEquipo().ordenarRoster(numero, 0);
                                llamada.refrescarPlantilla();
                                break;
                        case "ordenarRendimiento":
                                mayorMenorEdad = false;
                                mayorMenorNombre = false;
                                if (mayorMenorRendimiento) {
                                        numero = 9;
                                } else {
                                        numero = 10;
                                }
                                mayorMenorRendimiento = !mayorMenorRendimiento;
                                llamada.getEquipo().ordenarRoster(numero, 0);
                                llamada.refrescarPlantilla();
                                break;
                        case "ordenarNombre":
                                mayorMenorEdad = false;
                                mayorMenorRendimiento = false;
                                if (mayorMenorNombre) {
                                        numero = 3;
                                } else {
                                        numero = 4;
                                }
                                mayorMenorNombre = !mayorMenorNombre;
                                llamada.getEquipo().ordenarRoster(numero, 0);
                                llamada.refrescarPlantilla();
                                break;
                }
        }

}
