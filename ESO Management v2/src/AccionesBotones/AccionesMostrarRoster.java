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
        private boolean mayorMenorEdad = false, AZNombre = false, mayorMenorRendimiento = false, AZNacionalidad = false;

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

        public void inicializarBooleans() {
                mayorMenorEdad = false;
                AZNombre = false;
                mayorMenorRendimiento = false;
                AZNacionalidad = false;
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
                                AZNombre = false;
                                AZNacionalidad = false;
                                numero = -1;
                                llamada.getEquipo().ordenarRoster(-1, 0);
                                llamada.refrescarPlantilla(llamada.getEquipo().toString());
                                break;
                        case "ordenarEdad":
                                mayorMenorRendimiento = false;
                                AZNombre = false;
                                AZNacionalidad = false;
                                if (mayorMenorEdad) {
                                        numero = 1;
                                } else {
                                        numero = 2;
                                }
                                mayorMenorEdad = !mayorMenorEdad;
                                llamada.getEquipo().ordenarRoster(numero, 0);
                                llamada.refrescarPlantilla(llamada.getEquipo().toString());
                                break;
                        case "ordenarRendimiento":
                                mayorMenorEdad = false;
                                AZNombre = false;
                                AZNacionalidad = false;
                                if (mayorMenorRendimiento) {
                                        numero = 9;
                                } else {
                                        numero = 10;
                                }
                                mayorMenorRendimiento = !mayorMenorRendimiento;
                                llamada.getEquipo().ordenarRoster(numero, 0);
                                llamada.refrescarPlantilla(llamada.getEquipo().toString());
                                break;
                        case "ordenarNombre":
                                mayorMenorEdad = false;
                                mayorMenorRendimiento = false;
                                AZNacionalidad = false;
                                if (AZNombre) {
                                        numero = 3;
                                } else {
                                        numero = 4;
                                }
                                AZNombre = !AZNombre;
                                llamada.getEquipo().ordenarRoster(numero, 0);
                                llamada.refrescarPlantilla(llamada.getEquipo().toString());
                                break;
                        case "ordenarNacionalidad":
                                mayorMenorEdad = false;
                                mayorMenorRendimiento = false;
                                AZNombre = false;
                                if (AZNacionalidad) {
                                        numero = 6;
                                } else {
                                        numero = 5;
                                }
                                AZNacionalidad = !AZNacionalidad;
                                llamada.getEquipo().ordenarRoster(numero, 0);
                                llamada.refrescarPlantilla(llamada.organizarPorNacionalidades());
                                break;
                }
        }

}
