/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtual.league.management.entities.Liga;

import com.virtual.league.management.entities.Equipo.*;
import com.virtual.league.management.entities.Jugador.*;

/**
 *
 * @author analpa1997
 */
public class Entrenamiento {

        private Roster equipo;
        private int[] entrenamiento = new int[4];

        public Entrenamiento(Roster equipo) {
                this.equipo = equipo;
        }

        public Entrenamiento() {
        }

        public Roster getEquipo() {
                return equipo;
        }

        public void setEquipo(Roster equipo) {
                this.equipo = equipo;
        }

        public int[] getEntrenamiento() {
                return entrenamiento;
        }

        public void setEntrenamiento(int[] entrenamiento) {
                this.entrenamiento = entrenamiento;
        }

        public void setEntrenamiento(int ent1, int ent2, int ent3, int ent4) {
                entrenamiento[0] = ent1;
                entrenamiento[1] = ent2;
                entrenamiento[2] = ent3;
                entrenamiento[3] = ent4;
        }

        public void setEntrenamiento(String ent1, String ent2, String ent3, String ent4) throws ClassCastException {
                entrenamiento[0] = Integer.parseInt(ent1);
                entrenamiento[1] = Integer.parseInt(ent2);
                entrenamiento[2] = Integer.parseInt(ent3);
                entrenamiento[3] = Integer.parseInt(ent4);
        }

        public String sumarEntrenamiento(int nSemanas) {
                String salida = "";
                for (Jugador j : equipo.getJugadores()) {
                        Habilidad[] h = {new Habilidad(j.getPortero()), new Habilidad(j.getDefensa()), new Habilidad(j.getMedio()), new Habilidad(j.getDelantero())};
                        if (j.getPos() == Jugador.Posicion.gk) {
                                j.getPortero().setExperiencia(j.getPortero().getExperiencia() + nSemanas * entrenamiento[0]);
                                if (j.getPortero().getMedia() < h[0].getMedia()) {
                                        salida += j.getNombre() + " (" + j.getEquipo().toLowerCase() + ") ha bajado su media de portero de " + h[0].getMedia() + " a " + j.getPortero().getMedia() + "\n";
                                } else if (j.getPortero().getMedia() > h[0].getMedia()) {
                                        salida += j.getNombre() + " (" + j.getEquipo().toLowerCase() + ") ha subido su media de portero de " + h[0].getMedia() + " a " + j.getPortero().getMedia() + "\n";
                                }
                        } else {
                                j.getDefensa().setExperiencia(j.getDefensa().getExperiencia() + nSemanas * entrenamiento[1]);
                                if (j.getDefensa().getMedia() < h[1].getMedia()) {
                                        salida += j.getNombre() + " (" + j.getEquipo().toLowerCase() + ") ha bajado su media de defensa de " + h[1].getMedia() + " a " + j.getDefensa().getMedia() + "\n";
                                } else if (j.getDefensa().getMedia() > h[1].getMedia()) {
                                        salida += j.getNombre() + " (" + j.getEquipo().toLowerCase() + ") ha subido su media de defensa de " + h[1].getMedia() + " a " + j.getDefensa().getMedia() + "\n";
                                }
                                j.getMedio().setExperiencia(j.getMedio().getExperiencia() + nSemanas * entrenamiento[2]);
                                if (j.getMedio().getMedia() < h[2].getMedia()) {
                                        salida += j.getNombre() + " (" + j.getEquipo().toLowerCase() + ") ha bajado su media de medio de " + h[2].getMedia() + " a " + j.getMedio().getMedia() + "\n";
                                } else if (j.getMedio().getMedia() > h[2].getMedia()) {
                                        salida += j.getNombre() + " (" + j.getEquipo().toLowerCase() + ") ha subido su media de medio de " + h[2].getMedia() + " a " + j.getMedio().getMedia() + "\n";
                                }
                                j.getDelantero().setExperiencia(j.getDelantero().getExperiencia() + nSemanas * entrenamiento[3]);
                                if (j.getDelantero().getMedia() < h[3].getMedia()) {
                                        salida += j.getNombre() + " (" + j.getEquipo().toLowerCase() + ") ha bajado su media de delantero de " + h[3].getMedia() + " a " + j.getDelantero().getMedia() + "\n";
                                } else if (j.getDelantero().getMedia() > h[3].getMedia()) {
                                        salida += j.getNombre() + " (" + j.getEquipo().toLowerCase() + ") ha subido su media de delantero de " + h[3].getMedia() + " a " + j.getDelantero().getMedia() + "\n";
                                }
                        }
                        j.definirPosicion();
                        j.definirPosInt();
                        j.definirMedias();
                        j.definirSalario();
                }
                return salida;

        }

        @Override
        public String toString() {
                return "Entrenamiento de (" + equipo.getAbreviatura().toLowerCase() + "): " + entrenamiento[0] + " St, " + entrenamiento[1] + " Tk, " + entrenamiento[2] + " Ps, " + entrenamiento[3] + " Sh.";
        }

}
