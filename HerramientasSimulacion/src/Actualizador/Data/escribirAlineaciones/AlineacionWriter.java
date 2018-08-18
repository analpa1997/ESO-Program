/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actualizador.Data.escribirAlineaciones;

import Actualizador.Data.Jugador;
import java.io.*;
import java.util.*;

/**
 *
 * @author analp
 */
public class AlineacionWriter {

        enum Posiciones {
                gk, df, dm, mf, am, fw;
        }

        public AlineacionWriter() {

        }

        public static String escribirEspacios(String s, int espacios) {
                for (int i = 0; i < espacios; i++) {
                        s += " ";
                }
                return s;
        }

        public static String centrarString(String s, String sCenter, int parametro) {
                s = escribirEspacios(s, parametro);
                s += sCenter;
                s = escribirEspacios(s, parametro);
                return s;
        }

        public String escribirFormacion(SEquipo equipo) throws IOException {
                final int espaciosCenter = 0;
                final int maxEspacios = 84;
                String result = "";
                ArrayList<SJugador> titulares = equipo.getTitulares();
                ArrayList<SJugador> jugadoresXPosicion;
                String lineaInf = "";
                lineaInf = centrarString(result, equipo.getNombre(), (maxEspacios - equipo.getNombre().length()) / 2);
                result = result + lineaInf + "\n \n";
                String abrev = equipo.getTactica();
                lineaInf = centrarString("", abrev, (maxEspacios - abrev.length()) / 2);
                result = result + lineaInf + "\n \n";
                int k = 0;
                for (Jugador.Posicion p : Jugador.Posicion.values()) {
                        jugadoresXPosicion = new ArrayList();
                        for (SJugador j : titulares) {
                                if (j.getPosicion() == p) {
                                        jugadoresXPosicion.add(j);
                                }
                        }
                        String jugadores = "";
                        jugadores = escribirEspacios(jugadores, espaciosCenter);
                        String linea = "";
                        if (jugadoresXPosicion.isEmpty()) {
                                linea = " ";
                        } else {
                                for (SJugador j : jugadoresXPosicion) {
                                        linea += j.getjPlantilla().getNombre() + " (" + j.getjPlantilla().getEquipo().toLowerCase() + ") ";
                                }
                        }
                        jugadores = centrarString(jugadores, linea, (maxEspacios - linea.length()) / 2);
                        jugadores = escribirEspacios(jugadores, 85 - jugadores.length());
                        result = result + jugadores + "\n";
                }
                return result;
        }
}
