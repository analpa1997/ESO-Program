/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actualizador.Data.escribirAlineaciones;

import Actualizador.Data.Jugador;
import Actualizador.Data.Contenedor;
import java.io.*;
import java.util.*;

/**
 *
 * @author analp
 */
public class SEquipo {

        private ArrayList<TreeSet<SJugador>> todosJugadoresJornada = new ArrayList<>();

        private String nombre, tactica;
        private ArrayList<SJugador> titulares = new ArrayList();

        public SEquipo() {

        }

        public SEquipo(Contenedor liga, BufferedReader leerRatings, String nombreEquipo) throws IOException {
                for (int i = 0; i < 6; i++) {
                        TreeSet<SJugador> s = new TreeSet<>((o1, o2) -> o2.compararPuntuaciones(o1));
                        todosJugadoresJornada.add(s);
                }
                nombre = nombreEquipo;
                String jugador = "";
                String s = "";
                while ((jugador = leerRatings.readLine()) != null) {
                        String[] cadenaSinEspacios = jugador.split("\\s+");
                        Jugador j = liga.buscarEquipo(cadenaSinEspacios[2]).buscarJugador(cadenaSinEspacios[0]);
                        SJugador player = new SJugador(j, cadenaSinEspacios[1], Integer.parseInt(cadenaSinEspacios[3]));
                        todosJugadoresJornada.get(j.getPosInt() - 1).add(player);
                }
        }

        public void elegirAlineacion(int[] formacion) {
                tactica = "";
                titulares.add(todosJugadoresJornada.get(0).first());
                todosJugadoresJornada.get(0).remove(todosJugadoresJornada.get(0).first());
                // Elegir titulares
                for (int i = 0; i < 5; i++) {
                        tactica += formacion[i];
                        for (int j = 0; j < formacion[i]; j++) {
                                titulares.add(todosJugadoresJornada.get(i + 1).first());
                                todosJugadoresJornada.get(i + 1).remove(todosJugadoresJornada.get(i + 1).first());
                        }
                        if (i != 4) {
                                tactica += "-";
                        }
                }
        }

        public String toString() {
                String s = "";
                s += "TACTICA: " + tactica + "\n\n";
                s += "JUGADORES:\n";
                for (SJugador j : titulares) {
                        s += j.toString() + "\n";
                }
                return s;
        }

        public ArrayList<SJugador> getTitulares() {
                return titulares;
        }

        public String getNombre() {
                return nombre;
        }

        public String getTactica() {
                return tactica;
        }

}
