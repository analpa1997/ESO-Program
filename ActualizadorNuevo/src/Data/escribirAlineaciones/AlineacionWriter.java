/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.escribirAlineaciones;

import Data.*;
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

        public static void escribirFormacion(SEquipo equipo) throws IOException {
                final int espaciosCenter = 0;
                final int maxEspacios = 84;
                ArrayList<SJugador> titulares = equipo.getTitulares();
                FileWriter alineacion = new FileWriter(equipo.getNombre() + ".txt");
                BufferedWriter bW = new BufferedWriter(alineacion);
                PrintWriter pW = new PrintWriter(bW);
                ArrayList<SJugador> jugadoresXPosicion;
                String lineaInf = "";
                lineaInf = centrarString(lineaInf, equipo.getNombre(), (maxEspacios - equipo.getNombre().length()) / 2);
                pW.println(lineaInf);
                String abrev = equipo.getTactica();
                lineaInf = centrarString("", abrev, (maxEspacios - abrev.length()) / 2);
                pW.println(lineaInf);
                pW.println();
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
                                        linea += j.getjPlantilla().getNombre() + " (" + j.getjPlantilla().getEquipo() + ") ";
                                }
                        }
                        jugadores = centrarString(jugadores, linea, (maxEspacios - linea.length()) / 2);
                        jugadores = escribirEspacios(jugadores, 85 - jugadores.length());
                        pW.println(jugadores);
                        pW.println();
                }
                pW.close();
        }
}
