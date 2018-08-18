
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author analpa1997
 */
public class Equipo {

        private ArrayList<Jugador> jugadores;
        private String abreviatura;

        public Equipo() {
                abreviatura = "";
                jugadores = new ArrayList();
        }

        public Equipo(String abreviatura) {
                this();
                this.abreviatura = abreviatura;
        }

        public Equipo(ArrayList<Jugador> jugadores) {
                this();
                this.jugadores = jugadores;
        }

        public Equipo(ArrayList<Jugador> jugadores, String abreviatura) {
                this();
                this.jugadores = jugadores;
                this.abreviatura = abreviatura;
        }

        public String getAbreviatura() {
                return abreviatura;
        }

        public void setAbreviatura(String abreviatura) {
                this.abreviatura = abreviatura;
        }

        public void anadirJugador(Jugador j) {
                jugadores.add(j);
        }

        public ArrayList<Jugador> getJugadores() {
                return jugadores;
        }

        public void setJugadores(ArrayList<Jugador> jugadores) {
                this.jugadores = jugadores;
        }

}
