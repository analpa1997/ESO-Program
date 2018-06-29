/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.escribirAlineaciones;

import Data.*;

/**
 *
 * @author analp
 */
public class SJugador {

        private Jugador jPlantilla;
        private Jugador.Posicion pos;
        private int puntuacion;

        public SJugador() {

        }

        public SJugador(SJugador j) {
                jPlantilla = new Jugador(j.getjPlantilla());
                this.pos = j.pos;
                this.puntuacion = j.puntuacion;
        }

        public SJugador(Jugador j, String posicion, int puntos) {
                jPlantilla = new Jugador(j);
                switch (posicion) {
                        case "GK":
                                pos = Jugador.Posicion.gk;
                                break;
                        case "DF":
                                pos = Jugador.Posicion.df;
                                break;
                        case "DM":
                                pos = Jugador.Posicion.dm;
                                break;
                        case "MF":
                                pos = Jugador.Posicion.mf;
                                break;
                        case "AM":
                                pos = Jugador.Posicion.am;
                                break;
                        case "FW":
                                pos = Jugador.Posicion.fw;
                                break;
                }
                this.puntuacion = puntos;
        }

        public Jugador getjPlantilla() {
                return jPlantilla;
        }

        public void setjPlantilla(Jugador jPlantilla) {
                this.jPlantilla = jPlantilla;
        }

        public Jugador.Posicion getPos() {
                return pos;
        }

        public void setPos(Jugador.Posicion pos) {
                this.pos = pos;
        }

        public Jugador.Posicion getPosicion() {
                return pos;
        }

        public int getPuntuacion() {
                return puntuacion;
        }

        public void setPuntuacion(int puntuacion) {
                this.puntuacion = puntuacion;
        }

        public int compararPuntuaciones(SJugador other) {
                return this.puntuacion - other.puntuacion;
        }

        public String toString() {
                String s = "";
                s = pos.toString() + ": " + jPlantilla.getNombre();
                return s;
        }
}
