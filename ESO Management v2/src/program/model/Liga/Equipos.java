/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model.Liga;

import java.io.IOException;
import java.util.*;
import program.model.Equipo.*;

/**
 *
 * @author Antonio
 */
public class Equipos {

        private TreeSet<Roster> equipos;

        public Equipos() {
                equipos = new TreeSet<>((o1, o2) -> o1.getAbreviatura().compareTo(o2.getAbreviatura()));
        }

        public TreeSet<Roster> getEquipos() {
                return equipos;
        }

        public void setEquipos(TreeSet<Roster> equipos) {
                this.equipos = equipos;
        }

        public void añadirEquipo(Roster roster) {
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

                        case 4: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor tamaño plantilla a menor tamaño plantilla">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getJugadores().size() - o1.getJugadores().size());
                                break;
//</editor-fold>

                        case 5: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor tamaño plantilla a mayor tamaño plantilla">
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
                        if (aux.getAbreviatura().equalsIgnoreCase(abrev)) {
                                encontrado = true;
                                buscado = aux;
                        }
                }
                return buscado;
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
}
