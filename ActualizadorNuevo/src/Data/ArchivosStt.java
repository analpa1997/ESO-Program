/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.*;
import java.util.*;

/**
 *
 * @author Antonio
 */
public class ArchivosStt {

        public Equipo local, visitante;
        public int golLocal, golVisitante;
        public ArrayList<JugadorStt> jLocal = new ArrayList(), jVisitante = new ArrayList();
        public Lesiones listaLesiones = new Lesiones();

        public ArchivosStt() {

        }

        public ArchivosStt(BufferedReader bR, Contenedor liga) throws IOException {
                String s;
                String[] cadena;
                s = bR.readLine();
                cadena = s.split("\\s+");
                local = liga.buscarEquipo(cadena[0]);
                golLocal = Integer.parseInt(cadena[1]);
                for (int i = 0; i < 16; i++) {
                        s = bR.readLine();
                        cadena = s.split("\\s+");
                        jLocal.add(new JugadorStt(cadena));
                }
                bR.readLine();
                s = bR.readLine();
                cadena = s.split("\\s+");
                visitante = liga.buscarEquipo(cadena[0]);
                golVisitante = Integer.parseInt(cadena[1]);
                for (int i = 0; i < 16; i++) {
                        s = bR.readLine();
                        cadena = s.split("\\s+");
                        jVisitante.add(new JugadorStt(cadena));
                }
        }

        public String escribirSkillsch(ArrayList<JugadorStt> roster, Equipo team) {
                String s = "";
                for (JugadorStt j : roster) {
                        Jugador jPlantilla = team.buscarJugador(j.nombre);
                        int[] mediasAnt = {jPlantilla.getGkSkills().getMedia(), jPlantilla.getDfSkills().getMedia(), jPlantilla.getMfSkills().getMedia(), jPlantilla.getFwSkills().getMedia()};
                        jPlantilla.getGkSkills().setExp(jPlantilla.getGkSkills().getExp() + j.expGK);
                        jPlantilla.getDfSkills().setExp(jPlantilla.getDfSkills().getExp() + j.expDF);
                        jPlantilla.getMfSkills().setExp(jPlantilla.getMfSkills().getExp() + j.expMF);
                        jPlantilla.getFwSkills().setExp(jPlantilla.getFwSkills().getExp() + j.expFW);
                        if (jPlantilla.getGkSkills().getMedia() > mediasAnt[0]) {
                                s += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") sube su media de GK de " + mediasAnt[0] + " a " + jPlantilla.getGkSkills().getMedia();
                                s += "\n";
                        } else if (jPlantilla.getGkSkills().getMedia() < mediasAnt[0]) {
                                s += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") baja su media de GK de " + mediasAnt[0] + " a " + jPlantilla.getGkSkills().getMedia();
                                s += "\n";
                        }
                        if (jPlantilla.getDfSkills().getMedia() > mediasAnt[1]) {
                                s += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") sube su media de DF de " + mediasAnt[1] + " a " + jPlantilla.getDfSkills().getMedia();
                                s += "\n";
                        } else if (jPlantilla.getDfSkills().getMedia() < mediasAnt[1]) {
                                s += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") baja su media de DF de " + mediasAnt[1] + " a " + jPlantilla.getDfSkills().getMedia();
                                s += "\n";
                        }
                        if (jPlantilla.getMfSkills().getMedia() > mediasAnt[2]) {
                                s += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") sube su media de MF de " + mediasAnt[2] + " a " + jPlantilla.getMfSkills().getMedia();
                                s += "\n";
                        } else if (jPlantilla.getMfSkills().getMedia() < mediasAnt[2]) {
                                s += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") baja su media de MF de " + mediasAnt[2] + " a " + jPlantilla.getMfSkills().getMedia();
                                s += "\n";
                        }
                        if (jPlantilla.getFwSkills().getMedia() > mediasAnt[3]) {
                                s += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") sube su media de FW de " + mediasAnt[3] + " a " + jPlantilla.getFwSkills().getMedia();
                                s += "\n";
                        } else if (jPlantilla.getFwSkills().getMedia() < mediasAnt[3]) {
                                s += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") baja su media de FW de " + mediasAnt[3] + " a " + jPlantilla.getFwSkills().getMedia();
                                s += "\n";
                        }
                        jPlantilla.getGkSkills().setExp(jPlantilla.getGkSkills().getExp() - j.expGK);
                        jPlantilla.getDfSkills().setExp(jPlantilla.getDfSkills().getExp() - j.expDF);
                        jPlantilla.getMfSkills().setExp(jPlantilla.getMfSkills().getExp() - j.expMF);
                        jPlantilla.getFwSkills().setExp(jPlantilla.getFwSkills().getExp() - j.expFW);
                }
                return s;
        }

        private boolean haJugado(ArrayList<JugadorStt> roster, Jugador player) {
                for (JugadorStt j : roster) {
                        if (j.nombre.equals(player.getNombre()) && (j.minutos != 0)) {
                                return true;
                        }
                }
                return false;
        }

        public void actualizarBase(int fitFactor, Contenedor liga, Equipo team, ArrayList<JugadorStt> roster) throws IOException {
                Random r = new Random();
                for (Jugador j : team.getRoster()) {
                        j.getStats().setLesion(j.getStats().getLesion() - 1);
                        j.getStats().setSancion(j.getStats().getSancion() - 1);
                        if (!haJugado(roster, j)) {
                                j.getStats().setFit(j.getStats().getFit() + 12);
                        }
                }
                for (JugadorStt j : roster) {
                        Jugador jPlantilla = team.buscarJugador(j.nombre);
                        jPlantilla.getStats().setPJugados(jPlantilla.getStats().getJugados() + j.jugados);
                        jPlantilla.getStats().setPSuplente(jPlantilla.getStats().getSuplente() + j.suplente);
                        jPlantilla.getStats().setMinutos(jPlantilla.getStats().getMinutos() + j.minutos);
                        jPlantilla.getStats().setMom(jPlantilla.getStats().getMom() + j.mom);
                        jPlantilla.getStats().setParadas(jPlantilla.getStats().getParadas() + j.paradas);
                        jPlantilla.getStats().setEncajados(jPlantilla.getStats().getEncajados() + j.encajados);
                        jPlantilla.getStats().setTackles(jPlantilla.getStats().getTackles() + j.tackles);
                        jPlantilla.getStats().setPases(jPlantilla.getStats().getPases() + j.pases);
                        jPlantilla.getStats().setTiros(jPlantilla.getStats().getTiros() + j.tiros);
                        jPlantilla.getStats().setGoles(jPlantilla.getStats().getGoles() + j.goles);
                        jPlantilla.getStats().setAsistencias(jPlantilla.getStats().getAsistencias() + j.assists);
                        jPlantilla.getStats().setDP(jPlantilla.getStats().getDP() + j.dp);
                        if (((jPlantilla.getStats().getDP() % 5 == 0) && (j.dp != 0)) || j.dp == 5) {
                                jPlantilla.getStats().setSancion(1);
                        }
                        if (j.lesion == 1) {
                                jPlantilla.getStats().setLesion(Math.abs((int) Math.round(r.nextGaussian() * 1.5 + 2)));
                        }
                        sumarFit(j, jPlantilla);
                        jPlantilla.getGkSkills().setExp(jPlantilla.getGkSkills().getExp() + j.expGK);
                        jPlantilla.getDfSkills().setExp(jPlantilla.getDfSkills().getExp() + j.expDF);
                        jPlantilla.getMfSkills().setExp(jPlantilla.getMfSkills().getExp() + j.expMF);
                        jPlantilla.getFwSkills().setExp(jPlantilla.getFwSkills().getExp() + j.expFW);
                        jPlantilla.definirMedias();
                        jPlantilla.definirPosicion();
                        jPlantilla.definirPosInt();
                }
                team.ordenarRoster();
        }

        public String[] escribirLesiones(Equipo team, ArrayList<JugadorStt> roster, String[] sancionesYLesiones) {
                for (Jugador jPlantilla : team.getRoster()) {
                        if (jPlantilla.getLesionado() && jPlantilla.getStats().getLesion() == 0) {
                                jPlantilla.setLesionado(false);
                                if (!haJugado(roster, jPlantilla)) {
                                        sancionesYLesiones[0] += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") vuelve de su lesión esta jornada.";
                                        sancionesYLesiones[0] += "\n";
                                }
                                if (jPlantilla.getPosInt() != 0) {
                                        jPlantilla.getStats().setFit(jPlantilla.getStats().getFit() - 15);
                                }
                        } else if (!jPlantilla.getLesionado() && jPlantilla.getStats().getLesion() > 0) {
                                jPlantilla.setLesionado(true);
                        }
                }
                String lesion = "";
                for (JugadorStt j : roster) {
                        Jugador jPlantilla = team.buscarJugador(j.nombre);
                        if (j.lesion == 1) {
                                listaLesiones.lesionRandom();
                                switch (jPlantilla.getStats().getLesion()) {
                                        case 0:
                                                lesion = listaLesiones.cero.get(0);
                                                break;
                                        case 1:
                                                lesion = listaLesiones.uno.get(0);
                                                break;
                                        case 2:
                                                lesion = listaLesiones.dos.get(0);
                                                break;
                                        case 3:
                                                lesion = listaLesiones.tres.get(0);
                                                break;
                                        case 4:
                                                lesion = listaLesiones.cuatro.get(0);
                                                break;
                                        case 5:
                                                lesion = listaLesiones.cinco.get(0);
                                                break;
                                        default:
                                                lesion = listaLesiones.seis.get(0);
                                                break;
                                }
                                if (jPlantilla.getStats().getLesion() == 0) {
                                        sancionesYLesiones[1] += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") ha sufrido " + lesion + ", pero estará disponible para el próximo partido.";
                                } else if (jPlantilla.getStats().getLesion() == 1) {
                                        sancionesYLesiones[1] += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") se ha lesionado durante " + jPlantilla.getStats().getLesion() + " semana debido a " + lesion + ".";
                                } else {
                                        sancionesYLesiones[1] += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") se ha lesionado durante " + jPlantilla.getStats().getLesion() + " semanas debido a " + lesion + ".";
                                }
                                sancionesYLesiones[1] += "\n";
                        }
                }
                return sancionesYLesiones;
        }

        public String[] escribirSanciones(Equipo team, ArrayList<JugadorStt> roster, String[] sancionesYLesiones) {
                for (Jugador jPlantilla : team.getRoster()) {
                        if (jPlantilla.getSancionado() && jPlantilla.getStats().getSancion() == 0) {
                                sancionesYLesiones[0] += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") vuelve de su sanción esta jornada.";
                                sancionesYLesiones[0] += "\n";
                                jPlantilla.setSancionado(false);
                                jPlantilla.getStats().setFit(100);
                        }
                }
                for (JugadorStt j : roster) {
                        Jugador jPlantilla = team.buscarJugador(j.nombre);
                        if (jPlantilla.getStats().getSancion() == 1) {
                                sancionesYLesiones[1] += jPlantilla.getNombre() + " (" + team.getAbrev().toLowerCase() + ") ha sido sancionado para el siguiente partido.";
                                sancionesYLesiones[1] += "\n";
                        }
                }
                return sancionesYLesiones;
        }

        private void sumarFit(JugadorStt player, Jugador jPlantilla) {
                /*0 a 10 +12.
                11 a 21 +8.
                22 a 32 +6.
                33 a 43 +4.
                44 a 45 0.
                46 a 56 -4.
                57 a 67 -6.
                68 a 78 -8.
                79 a 89 -10.
                90 a 99 -12.
                100 a 110 -14
                111 a 121 -16
                122 a 132 -18
                 */
                int min = player.minutos;
                int value = 0;
                if (!jPlantilla.getPosicion().equals(Jugador.Posicion.gk)) {
                        if (isBetween(min, 0, 10)) {
                                value = -12;
                        } else if (isBetween(min, 11, 21)) {
                                value = -8;
                        } else if (isBetween(min, 22, 32)) {
                                value = -6;
                        } else if (isBetween(min, 33, 43)) {
                                value = -4;
                        } else if (isBetween(min, 44, 45)) {
                                value = 0;
                        } else if (isBetween(min, 46, 56)) {
                                value = 4;
                        } else if (isBetween(min, 57, 67)) {
                                value = 6;
                        } else if (isBetween(min, 68, 78)) {
                                value = 8;
                        } else if (isBetween(min, 79, 89)) {
                                value = 10;
                        } else if (isBetween(min, 90, 99)) {
                                value = 12;
                        } else if (isBetween(min, 100, 110)) {
                                value = 14;
                        } else if (isBetween(min, 111, 121)) {
                                value = 16;
                        } else if (isBetween(min, 122, 132)) {
                                value = 18;
                        }
                        jPlantilla.getStats().setFit(jPlantilla.getStats().getFit() - value);
                } else {
                        jPlantilla.getStats().setFit(100);
                }
        }

        private static boolean isBetween(int x, int lower, int upper) {
                return lower <= x && x <= upper;
        }
}
