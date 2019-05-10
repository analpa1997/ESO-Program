/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtual.league.management.entities.Utils;

import com.virtual.league.management.entities.Jugador.*;
import com.virtual.league.management.entities.Jugador.Posiciones.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author analpa1997
 */
public class Utils {

        public static boolean estaEntre(int numero, int limiteInf, int limiteSup) {
                return mayorIgualQue(numero, limiteInf) && !mayorIgualQue(numero, limiteSup);
        }

        public static boolean mayorIgualQue(int numero, int limite) {
                return numero >= limite;
        }

        public static boolean mayorQue(int numero, int limite) {
                return numero > limite;
        }

        public static boolean menorIgualQue(int numero, int limite) {
                return !mayorIgualQue(numero, limite);
        }

        public static boolean menorQue(int numero, int limite) {
                return !mayorQue(numero, limite);
        }

        public static boolean iguales(int n1, int n2) {
                return n1 == n2;
        }

        public static boolean distintos(int n1, int n2) {
                return !iguales(n1, n2);
        }

        public static Integer [] ordenarArrayEnteros(Integer [] array){
                List<Integer> aux = Arrays.asList(array);
                aux.sort(((o1, o2) -> o2 - o1));
                Integer[] result = new Integer[aux.size()];
                aux.toArray(result);
                return result;
        }

        public static Jugador crearJugador (String lineaFichero, String nombreFichero){
                Jugador jugador;
                String[] cortado = lineaFichero.split("\\s+");
                int mediaPortero = Integer.parseInt(cortado[3]);
                int mediaDefensa = Integer.parseInt(cortado[4]);
                int mediaMedio = Integer.parseInt(cortado[5]);
                int mediaDelantero = Integer.parseInt(cortado[6]);
                int expPortero = Integer.parseInt(cortado[8]);
                int expDefensa = Integer.parseInt(cortado[9]);
                int expMedio = Integer.parseInt(cortado[10]);
                int expDelantero = Integer.parseInt(cortado[11]);
                int maximaExp;
                Integer [] medias = ordenarArrayEnteros(new Integer[] {mediaPortero,mediaDefensa,mediaMedio,mediaDelantero});
                if (medias [0] == mediaPortero){
                        jugador = new Portero (lineaFichero, nombreFichero);
                }else if (medias[0] == mediaDefensa){
                        if (medias[0] == mediaMedio){
                                if (medias[0] == mediaDelantero){
                                        maximaExp = Math.max(expDefensa, Math.max(expMedio, expDelantero));
                                        if (maximaExp == expDefensa){
                                                jugador = new Defensa(lineaFichero, nombreFichero);
                                        }else if (maximaExp == expMedio){
                                                jugador = new Medio(lineaFichero, nombreFichero);
                                        }else{
                                                jugador = new Delantero(lineaFichero, nombreFichero);
                                        }
                                }else{
                                        maximaExp = Math.max(expDefensa, expMedio);
                                        if (maximaExp == expDefensa){
                                                jugador = new Defensa(lineaFichero, nombreFichero);
                                        }else{
                                                jugador = new MedioDefensa(lineaFichero, nombreFichero);
                                        }
                                }
                        }else {
                                if (medias[0] == mediaDelantero){
                                        maximaExp = Math.max(expDefensa, expDelantero);
                                        if (maximaExp == expDefensa){
                                                jugador = new Defensa(lineaFichero, nombreFichero);
                                        }else{
                                                jugador = new Delantero(lineaFichero, nombreFichero);
                                        }
                                }else{
                                        jugador = new Defensa(lineaFichero,nombreFichero);
                                }
                        }

                }else if (medias[0] == mediaMedio){
                        if (medias[0] == mediaDelantero){
                                maximaExp = Math.max(expMedio, expDelantero);
                                if (maximaExp == expMedio){
                                        jugador = new MedioAtaque(lineaFichero, nombreFichero);
                                }else{
                                        jugador = new Delantero(lineaFichero, nombreFichero);
                                }
                        }else{
                                if ((mediaDelantero - mediaDefensa <= -4) && (mediaMedio - mediaDefensa <= 5)){
                                        jugador = new MedioDefensa(lineaFichero, nombreFichero);
                                }else if ((mediaDelantero - mediaDefensa >= 4) && (mediaMedio - mediaDelantero <= 5)){
                                        jugador = new MedioAtaque(lineaFichero, nombreFichero);
                                }else{
                                        jugador = new Medio(lineaFichero, nombreFichero);
                                }
                        }
                }else{
                        jugador = new Delantero(lineaFichero, nombreFichero);
                }
                return jugador;
        }
}
