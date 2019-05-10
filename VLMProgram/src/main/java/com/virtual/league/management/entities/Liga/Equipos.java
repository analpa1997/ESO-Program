/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtual.league.management.entities.Liga;

import com.virtual.league.management.entities.Equipo.*;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @author Antonio
 */
public class Equipos {

        private TreeSet<Roster> equipos;
        private String defEquiposContenidos;
        private final String EURO = "\u20ac";

        public Equipos() {
                equipos = new TreeSet<>((o1, o2) -> o1.getAbreviatura().compareTo(o2.getAbreviatura()));
                defEquiposContenidos = "";
        }

        public String getDefEquiposContenidos() {
                return defEquiposContenidos;
        }

        public void setDefEquiposContenidos(String defEquiposContenidos) {
                this.defEquiposContenidos = defEquiposContenidos;
        }

        public TreeSet<Roster> getEquipos() {
                return equipos;
        }

        public void setEquipos(TreeSet<Roster> equipos) {
                this.equipos = equipos;
        }

        public void anadirEquipo(Roster roster) {
                equipos.add(roster);
        }

        public void ordenarRosters(int num, int stat) {
                TreeSet<Roster> aux;
                switch (num) {

                        case 1: //<editor-fold defaultstate="collapsed" desc="Orden equipos Z - A (nombre)">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));
                                break;
//</editor-fold>

                        case 2: //<editor-fold defaultstate="collapsed" desc="Orden equipos A - Z (abreviatura)">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getAbreviatura().compareTo(o2.getAbreviatura()));
                                break;
//</editor-fold>

                        case 3: //<editor-fold defaultstate="collapsed" desc="Orden equipos Z - A (abreviatura)">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getAbreviatura().compareTo(o2.getAbreviatura()));
                                break;
//</editor-fold>

                        case 4: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor tama�o plantilla a menor tama�o plantilla">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getJugadores().size() - o1.getJugadores().size());
                                break;
//</editor-fold>

                        case 5: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor tama�o plantilla a mayor tama�o plantilla">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getJugadores().size() - o2.getJugadores().size());
                                break;
//</editor-fold>

                        case 6: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor numero porteros a menor numero porteros">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getnGk() - o1.getnGk());
                                break;
//</editor-fold>

                        case 7: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor numero porteros a mayor numero porteros">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getnGk() - o2.getnGk());
                                break;
//</editor-fold>

                        case 8: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor numero defensas a menor numero">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getnDf() - o1.getnDf());
                                break;
//</editor-fold>

                        case 9: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor numero defensas a mayor numero">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getnDf() - o2.getnDf());
                                break;
//</editor-fold>

                        case 10: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor numero dm">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getnDm() - o1.getnDm());
                                break;
//</editor-fold>

                        case 11: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor numero dm">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getnDm() - o2.getnDm());
                                break;
//</editor-fold>

                        case 12: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor numero mf">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getnMf() - o1.getnMf());
                                break;
//</editor-fold>

                        case 13: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor numero mf">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getnMf() - o2.getnMf());
                                break;
//</editor-fold>

                        case 14: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor numero am">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getnAm() - o1.getnAm());
                                break;
//</editor-fold>

                        case 15: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor numero am">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getnAm() - o2.getnAm());
                                break;
//</editor-fold>

                        case 16: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor numero fw">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getnFw() - o1.getnFw());
                                break;
//</editor-fold>

                        case 17: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor numero fw">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getnFw() - o2.getnFw());
                                break;
//</editor-fold>

                        case 18: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor salario">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getSalario() - o1.getSalario());
                                break;
//</editor-fold>

                        case 19: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor salario">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getSalario() - o2.getSalario());
                                break;
//</editor-fold>

                        case 20: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor rendimiento">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o2.getRendimiento(), o1.getRendimiento()));
                                break;
//</editor-fold>

                        case 21: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor rendimiento">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o1.getRendimiento(), o2.getRendimiento()));
                                break;
//</editor-fold>

                        case 22: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor potencial">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o2.getPotencial(), o1.getPotencial()));
                                break;
//</editor-fold>

                        case 23: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor potencial">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o1.getPotencial(), o2.getPotencial()));
                                break;
//</editor-fold>

                        case 24: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor edad media">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o2.getEdadMedia(), o1.getEdadMedia()));
                                break;
//</editor-fold>

                        case 25: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor edad media">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o1.getEdadMedia(), o2.getEdadMedia()));
                                break;
//</editor-fold>

                        case 26: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor elo">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o2.getElo(), o1.getElo()));
                                break;
//</editor-fold>

                        case 27: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor elo">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o1.getElo(), o2.getElo()));
                                break;
//</editor-fold>

                        case 28: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor estadistica">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.compareStats(o1, stat));
                                break;
//</editor-fold>

                        case 29: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor estadistica">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.compareStats(o2, stat));
                                break;
//</editor-fold>

                        case 30: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor calidad actual">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o2.getCalidadActual(), o1.getCalidadActual()));
                                break;
//</editor-fold>

                        case 31: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor calidad actual">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o1.getCalidadActual(), o2.getCalidadActual()));
                                break;
//</editor-fold>

                        default: //<editor-fold defaultstate="collapsed" desc="Orden por defecto, equipos A-Z (nombre)">
                                aux = new TreeSet<Roster>();
                                break;
//</editor-fold>
                }
                Iterator it = equipos.iterator();
                while (it.hasNext()) {
                        Roster r = (Roster) it.next();
                        aux.add(r);
                }
                equipos = aux;
        }

        public Roster buscarEquipo(String abrev) {
                Iterator it = equipos.iterator();
                boolean encontrado = false;
                Roster buscado = null;
                while (it.hasNext() && !encontrado) {
                        Roster aux = (Roster) it.next();
                        if (aux.getAbreviatura().toLowerCase().equals(abrev.toLowerCase())) {
                                encontrado = true;
                                buscado = aux;
                        }
                }
                return buscado;
        }

        public Roster borrarEquipo(String abrev) {
                Roster equipoBorrado = buscarEquipo(abrev);
                equipos.remove(equipoBorrado);
                return equipoBorrado;
        }

        public void actualizarEquipo(Roster equipo) {
                Roster antiguoRoster = borrarEquipo(equipo.getAbreviatura());
                anadirEquipo(equipo);
        }

        public void guardarEquipos() {
                for (Roster r : equipos) {
                        try {
                                r.guardarEquipo();
                        } catch (IOException ex) {
                                System.err.println(ex.getMessage());
                        }
                }
        }

        public String escribirSalariosMayMenor() {
                for (Roster r : equipos) {
                        r.calcularSalario();
                }
                this.ordenarRosters(18, -1);
                String resultado = "";
                DecimalFormat df = new DecimalFormat("###,###.##");
                String cabecera = "SALARIOS TOTALES (" + defEquiposContenidos.toLowerCase() + ")\n\nNUM    NOMBRE (CLUB)                    SALARIO\n----------------------------------------------------\n\n";
                resultado = resultado + cabecera;
                int i = 1;
                for (Roster r : equipos) {
                        String equipo = i + ". " + escribirEspaciosCifras(i) + "(" + r.getAbreviatura().toLowerCase() + ")";
                        equipo = equipo + escribirEspacios(40 - equipo.length());
                        equipo = equipo + df.format(r.getSalario()) + EURO + "\n";
                        resultado = resultado + equipo;
                        i++;
                }
                return resultado;
        }

        public String escribirSalariosAbrev() {
                for (Roster r : equipos) {
                        r.calcularSalario();
                }
                this.ordenarRosters(2, -1);
                String resultado = "";
                DecimalFormat df = new DecimalFormat("###,###.##");
                String cabecera = "SALARIOS TOTALES (" + defEquiposContenidos.toLowerCase() + ")\n\nNUM    NOMBRE (CLUB)                    SALARIO\n----------------------------------------------------\n\n";
                resultado = resultado + cabecera;
                int i = 1;
                for (Roster r : equipos) {
                        String equipo = i + ". " + escribirEspaciosCifras(i) + "(" + r.getAbreviatura().toLowerCase() + ")";
                        equipo = equipo + escribirEspacios(40 - equipo.length());
                        equipo = equipo + df.format(r.getSalario()) + EURO + "\n";
                        resultado = resultado + equipo;
                        i++;
                }
                return resultado;
        }

        public String escribirPotencialesMayMenor() {
                for (Roster r : equipos) {
                        r.calcularPotencial();
                }
                this.ordenarRosters(22, -1);
                String resultado = "";
                DecimalFormat df = new DecimalFormat("###.##");
                String cabecera = "POTENCIALES (" + defEquiposContenidos.toLowerCase() + ")\n\nNUM    NOMBRE (CLUB)                    POTENCIAL\n----------------------------------------------------\n\n";
                resultado = resultado + cabecera;
                int i = 1;
                for (Roster r : equipos) {
                        String equipo = i + ". " + escribirEspaciosCifras(i) + "(" + r.getAbreviatura().toLowerCase() + ")";
                        equipo = equipo + escribirEspacios(40 - equipo.length());
                        equipo = equipo + df.format(r.getPotencial()) + " pts" + "\n";
                        resultado = resultado + equipo;
                        i++;
                }
                return resultado;
        }

        public String escribirCActualMayMenor() {
                for (Roster r : equipos) {
                        r.calcularCalidadActual();
                }
                this.ordenarRosters(30, -1);
                String resultado = "";
                DecimalFormat df = new DecimalFormat("###.##");
                String cabecera = "CALIDAD ACTUAL (" + defEquiposContenidos.toLowerCase() + ")\n\nNUM    NOMBRE (CLUB)                    CALIDAD ACTUAL\n----------------------------------------------------\n\n";
                resultado = resultado + cabecera;
                int i = 1;
                for (Roster r : equipos) {
                        String equipo = i + ". " + escribirEspaciosCifras(i) + "(" + r.getAbreviatura().toLowerCase() + ")";
                        equipo = equipo + escribirEspacios(40 - equipo.length());
                        equipo = equipo + df.format(r.getCalidadActual()) + " pts" + "\n";
                        resultado = resultado + equipo;
                        i++;
                }
                return resultado;
        }

        private String escribirEspaciosCifras(int num) {
                String espacio = " ";
                String result = "";
                for (int i = 0; i < (5 - (obtenerNumCifras(num))); i++) {
                        result += espacio;
                }
                return result;
        }

        private String escribirEspacios(int numero) {
                String espacio = " ";
                String result = "";
                for (int i = 0; i < numero; i++) {
                        result += espacio;
                }
                return result;
        }

        private int obtenerNumCifras(int numero) {
                int contador = 0;
                while (numero != 0) {
                        contador++;
                        numero = numero / 10;
                }
                return contador;
        }
}
