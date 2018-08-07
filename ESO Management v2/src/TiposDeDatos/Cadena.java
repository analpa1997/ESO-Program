/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiposDeDatos;

/**
 *
 * @author analpa1997
 */
public class Cadena {

        private String cadena;
        private int longitud;

        public Cadena() {
                cadena = "";
        }

        public Cadena(String texto) {
                cadena = texto;
                actLongitud();
        }

        public int getLongitud() {
                return longitud;
        }

        public void actLongitud() {
                longitud = cadena.length();
        }

        public void aString() {
                cadena = cadena.replaceAll("<br>", "\n");
                cadena = cadena.replaceAll("<pre>", "");
                cadena = cadena.replaceAll("</pre>", "");
                cadena = cadena.replaceAll("<html>", "");
                cadena = cadena.replaceAll("</html>", "");
                actLongitud();
        }

        public void aHTML(boolean preformateado) {
                cadena = cadena.replaceAll("\n", "<br>");
                if (preformateado) {
                        cadena = "<pre>" + cadena + "</pre>";
                }
                cadena = "<html>" + cadena + "</html>";
                actLongitud();
        }

        public String toString() {
                return cadena;
        }
}
