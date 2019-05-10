/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model.Utils;

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
}
