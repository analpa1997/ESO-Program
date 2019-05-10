/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtual.league.management.entities.Liga;

import com.virtual.league.management.entities.Equipo.Roster;
import com.virtual.league.management.entities.Jugador.Jugador;

/**
 *
 * @author analpa1997
 */
public class Fit {

        private Roster equipo;
        private int fitASumar;

        public Fit(Roster equipo, int fitASumar) {
                this.equipo = equipo;
                this.fitASumar = fitASumar;
        }

        public Fit(Roster equipo) {
                this.equipo = equipo;
        }

        public Fit(int fitASumar) {
                this();
                this.fitASumar = fitASumar;
        }

        public Fit() {
                this.equipo = new Roster();
        }

        public void sumarFit() {
                for (Jugador j : equipo.getJugadores()) {
                        j.getStats().setFit(j.getStats().getFit() + fitASumar);
                }
        }

        public Roster getEquipo() {
                return equipo;
        }

        public void setEquipo(Roster equipo) {
                this.equipo = equipo;
        }

        public int getFitASumar() {
                return fitASumar;
        }

        public void setFitASumar(int fitASumar) {
                this.fitASumar = fitASumar;
        }

}
