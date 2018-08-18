/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author analpa1997
 */
public class JugadorEnAlineacion {

        private Jugador jugador;
        private String posicion;

        public JugadorEnAlineacion(Jugador jugador, String posicion) {
                this.jugador = jugador;
                this.posicion = posicion;
        }

        public JugadorEnAlineacion() {
        }

        public Jugador getJugador() {
                return jugador;
        }

        public void setJugador(Jugador jugador) {
                this.jugador = jugador;
        }

        public String getPosicion() {
                return posicion;
        }

        public void setPosicion(String posicion) {
                this.posicion = posicion;
        }

        public String toString() {
                if (jugador == null) {
                        return posicion.toUpperCase() + " ";
                }
                return posicion.toUpperCase() + " " + jugador.getNombre();
        }

}
