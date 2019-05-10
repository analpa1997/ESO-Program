/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model.Utils;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author analpa1997
 */
public class Constantes {

        public static final File DIRECTORIO_ACTUAL = new File(".");

        public static final int POSINT_GK = 1;
        public static final int POSINT_DF = 2;
        public static final int POSINT_DM = 3;
        public static final int POSINT_MF = 4;
        public static final int POSINT_AM = 5;
        public static final int POSINT_FW = 6;

        Properties properties = null;

        private Constantes() {
                this.properties = new Properties();
                try {
                        properties.load(new FileReader("variables.eso"));
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.toString());
                        ex.printStackTrace();
                }
        }//Configuration

        /**
         * Implementando Singleton
         *
         * @return
         */
        public static Constantes getInstance() {
                return ConstantesHolder.INSTANCE;
        }

        private static class ConstantesHolder {

                private static final Constantes INSTANCE = new Constantes();
        }

        /**
         * Retorna la propiedad de configuración solicitada
         *
         * @param key
         * @return
         */
        public String getConstante(String key) {
                return this.properties.getProperty(key);
        }//getProperty

        public int getConstanteInt(String key) {
                String s = this.properties.getProperty(key).replaceAll("\\.", "");
                System.out.println(s);
                return Integer.parseInt(s);
        }//getProperty

}
