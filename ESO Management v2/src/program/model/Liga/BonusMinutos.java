/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model.Liga;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import program.model.Utils.*;

/**
 *
 * @author Antonio
 */
public class BonusMinutos {

        private Map<Integer, Map<Integer, Map<Integer, Integer>>> bonus;
        private Constantes ctes;

        public BonusMinutos() {
                ctes = Constantes.getInstance();
                bonus = new HashMap();
        }

        public void cargarBonusMinutos(BufferedReader b, int numeroRangosMedias, int numeroRangosEdad, int numeroRangosMinutos) {

                try {
                        ArrayList<String> archivo = new ArrayList<>();
                        String cadena = new String();
                        while ((cadena = b.readLine()) != null) {
                                if (!cadena.equals("") && !cadena.matches("\\s+")) {
                                        archivo.add(cadena);
                                }
                        }
                        b.close();
                        if (archivo.size() % numeroRangosMedias != 0) {
                                throw new Exception("El bonus no recoge " + numeroRangosMedias + " medias." + archivo.size());
                        }
                        if (archivo.size() != numeroRangosEdad * numeroRangosMedias) {
                                throw new Exception("El bonus deberia recoger " + numeroRangosEdad * numeroRangosMedias + " lineas");
                        }
                        int indice = 1;
                        for (String linea : archivo) {
                                String[] numeros = linea.split("\\s+");
                                if (numeros.length != numeroRangosMinutos) {
                                        throw new Exception("El bonus deberia recoger " + numeroRangosMinutos + " medias y recoge " + archivo.size() / numeroRangosMinutos + " medias (linea " + indice + ").");
                                }
                                indice++;
                        }
                        int media = ctes.getConstanteInt("mediaMinima"), edad = 1, minutos = 1;
                        Map<Integer, Map<Integer, Integer>> rangoMediaMapa = new HashMap();
                        for (indice = 0; indice < archivo.size(); indice++) {
                                Map<Integer, Integer> rangoEdadMapa = new HashMap();
                                String lineaBonus = archivo.get(indice);
                                String[] lineaTroceada = lineaBonus.split("\\s+");
                                for (String s : lineaTroceada) {
                                        rangoEdadMapa.put(minutos, Integer.parseInt(s));
                                        minutos++;
                                }
                                rangoMediaMapa.put(edad, rangoEdadMapa);
                                minutos = 1;
                                edad++;
                                if (edad >= numeroRangosEdad) {
                                        bonus.put(media, rangoMediaMapa);
                                        rangoMediaMapa = new HashMap();
                                        media++;
                                        edad = 1;
                                }
                        }
                        //System.err.println(this.toString());
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.toString());
                        ex.printStackTrace();
                }
        }

        public Map<Integer, Map<Integer, Map<Integer, Integer>>> getBonus() {
                return bonus;
        }

        public Map<Integer, Map<Integer, Integer>> getBonusPorMedia(int media) {
                return bonus.get(media);
        }

        public Map<Integer, Integer> getBonusPorEdad(int media, int edad) {
                return getBonusPorMedia(media).get(edad);
        }

        public int getBonusExperiencia(int media, int edad, int minutos) {
                return getBonusPorEdad(media, edad).get(minutos);
        }

        public void setBonus(Map<Integer, Map<Integer, Map<Integer, Integer>>> bonus) {
                this.bonus = bonus;
        }

        public String toString() {
                String s = "";
                for (int media = ctes.getConstanteInt("mediaMinima"); media < ctes.getConstanteInt("mediaMaxima"); media++) {
                        s += "MEDIA " + media + "\n";
                        for (int edad = 1; edad <= ctes.getConstanteInt("edadesBonus"); edad++) {
                                for (int minutos = 1; minutos <= ctes.getConstanteInt("minutosBonus"); minutos++) {
                                        s += this.getBonusExperiencia(media, edad, minutos) + " ";
                                }
                                s += "\n";
                        }
                        s += "\n";
                }
                return s;
        }
}
