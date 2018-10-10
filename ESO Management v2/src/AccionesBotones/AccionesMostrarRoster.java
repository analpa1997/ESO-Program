/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccionesBotones;

import Paneles.MostrarRoster;
import VPrincipal.ESO_Management_v2;
import java.awt.event.ActionEvent;
import java.util.Comparator;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import program.model.Tabla.ModeloTabla;

/**
 *
 * @author Antonio
 */
public class AccionesMostrarRoster extends Acciones {

        private MostrarRoster llamada;
        private boolean mayorMenorEdad = false, AZNombre = false, mayorMenorRendimiento = false, AZNacionalidad = false, mayorMenorSalario = false;
        private String ultimaAccion = "";

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
                mayorMenorSalario = false;
                ultimaAccion = "";
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                int numero = 0;
                switch (e.getActionCommand()) {
                        case "salir":
                                salir();
                                break;
                        case "gInformacion":
                                ultimaAccion += llamada.getEquipo().getAbreviatura().toLowerCase();
                                llamada.guardarTexto(ultimaAccion);
                                break;
                        case "ordenarMedia":
                                mayorMenorEdad = false;
                                mayorMenorRendimiento = false;
                                AZNombre = false;
                                AZNacionalidad = false;
                                mayorMenorSalario = false;
                                ultimaAccion = "";
                                numero = -1;
                                llamada.getEquipo().ordenarRoster(-1, 0);
                                // llamada.refrescarPlantilla(llamada.getEquipo().toString());
                                break;
                        case "ordenarEdad":
                                mayorMenorRendimiento = false;
                                AZNombre = false;
                                AZNacionalidad = false;
                                mayorMenorSalario = false;
                                if (mayorMenorEdad) {
                                        numero = 1;
                                        ultimaAccion = "Plantilla por edades (mayor a menor) ";
                                } else {
                                        numero = 2;
                                        ultimaAccion = "Plantilla por edades (menor a mayor) ";
                                }
                                mayorMenorEdad = !mayorMenorEdad;
                                llamada.getEquipo().ordenarRoster(numero, 0);
                                //     llamada.refrescarPlantilla(llamada.getEquipo().toString());
                                break;
                        case "ordenarRendimiento":
                                mayorMenorEdad = false;
                                AZNombre = false;
                                AZNacionalidad = false;
                                mayorMenorSalario = false;
                                if (mayorMenorRendimiento) {
                                        numero = 10;
                                        ultimaAccion = "Rendimiento (mayor a menor) ";
                                } else {
                                        numero = 9;
                                        ultimaAccion = "Rendimiento (menor a mayor) ";
                                }
                                mayorMenorRendimiento = !mayorMenorRendimiento;
                                llamada.getEquipo().ordenarRoster(numero, 0);
                                //   llamada.refrescarPlantilla(llamada.escribirRendimiento());
                                break;
                        case "ordenarNombre":
                                mayorMenorEdad = false;
                                mayorMenorRendimiento = false;
                                AZNacionalidad = false;
                                mayorMenorSalario = false;
                                if (AZNombre) {
                                        numero = 3;
                                        ultimaAccion = "Plantilla por nombre (A - Z) ";
                                } else {
                                        numero = 4;
                                        ultimaAccion = "Plantilla por nombre (Z - A) ";
                                }
                                AZNombre = !AZNombre;
                                llamada.getEquipo().ordenarRoster(numero, 0);
                                //     llamada.refrescarPlantilla(llamada.getEquipo().toString());
                                break;
                        case "ordenarNacionalidad":
                                mayorMenorEdad = false;
                                mayorMenorRendimiento = false;
                                AZNombre = false;
                                mayorMenorSalario = false;
                                if (AZNacionalidad) {
                                        numero = 6;
                                        ultimaAccion = "Nacionalidades (Z - A) ";
                                } else {
                                        numero = 5;
                                        ultimaAccion = "Nacionalidades (A - Z) ";
                                }
                                AZNacionalidad = !AZNacionalidad;
                                llamada.getEquipo().ordenarRoster(numero, 0);
                                //   llamada.refrescarPlantilla(llamada.organizarPorNacionalidades());
                                break;
                        case "ordenarSalario":
                                /*  mayorMenorEdad = false;
                                mayorMenorRendimiento = false;
                                AZNombre = false;
                                AZNacionalidad = false;
                                if (mayorMenorSalario) {
                                        numero = 8;
                                        ultimaAccion = "Salarios (menor a mayor) ";
                                } else {
                                        numero = 7;
                                        ultimaAccion = "Salarios (mayor a menor) ";
                                }
                                mayorMenorSalario = !mayorMenorSalario;
                                llamada.getEquipo().ordenarRoster(numero, 0);
                                //   llamada.refrescarPlantilla(llamada.escribirSalarios());*/
                                llamada.getEquipo().calcularSalario();
                                llamada.actualizarModelo(new ModeloTabla(llamada.getEquipo().rosterSalariosTabulado(), llamada.getEquipo().getCabeceraTablaRosterSalarioTabulado()));
                                TableRowSorter<TableModel> ordenacion = new TableRowSorter(llamada.getModeloTabla());
                                ordenacion.setComparator(3, new Comparator<Object>() {
                                        @Override
                                        public int compare(Object o1, Object o2) {
                                                String a = (String) o1;
                                                String b = (String) o2;
                                                System.err.println(a);
                                                System.out.println(a);
                                                a = a.replaceAll("\\.", "");
                                                b = b.replaceAll("\\.", "");
                                                a = a.replaceAll("¤", "");
                                                b = b.replaceAll("¤", "");
                                                return (Integer.parseInt(a) - Integer.parseInt(b));

                                        }
                                });
                                llamada.actualizarOrdenacion(ordenacion);
                                break;
                }
        }

}
