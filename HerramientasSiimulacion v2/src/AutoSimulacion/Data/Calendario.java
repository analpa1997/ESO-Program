/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoSimulacion.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 *
 * @author Antonio
 */
public class Calendario {

        private String nombre;
        private ArrayList<ArrayList<String[]>> partidos;

        public Calendario() {
                partidos = new ArrayList<ArrayList<String[]>>();
        }

        public ArrayList<String[]> getJornada(int j) {
                return partidos.get(j);
        }

        public ArrayList<ArrayList<String[]>> getCalendario() {
                return partidos;
        }

        public String[] getPartido(int j, int partido) {
                return partidos.get(j).get(partido);
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String name) {
                nombre = name;
        }

        public void anadirPartido(int j, String[] partido) {
                partidos.get(j).add(partido);
        }

        public void anadirJornada(ArrayList<String[]> jornada) {
                partidos.add(jornada);
        }

        public String toString() {
                String res = new String();
                int i = 0;
                for (ArrayList<String[]> j : partidos) {
                        res = res + "" + ++i + "\n";
                        for (String[] p : j) {
                                res = res + p[0] + " - " + p[1] + "\n";
                        }
                }
                return res;
        }

        public void cargarCalendario(File fichero) throws Exception {
                this.setNombre(fichero.getName().replaceAll(".txt", ""));
                FileReader fR = new FileReader(fichero);
                BufferedReader bR = new BufferedReader(fR);
                String s1;
                ArrayList<String[]> semana = new ArrayList();
                while ((s1 = bR.readLine()) != null) {
                        if (!s1.matches("\\s+")) {
                                if (!s1.matches("[0-9]+") && !s1.equals("")) {
                                        String[] cadena = s1.split("\\s+");
                                        String[] partido = new String[2];
                                        partido[0] = cadena[0];
                                        partido[1] = cadena[2];
                                        semana.add(partido);
                                } else {
                                        if (!semana.isEmpty()) {
                                                this.getCalendario().add(semana);
                                                semana = new ArrayList();
                                        }
                                }
                        }
                }
                this.getCalendario().add(semana);
        }

}
