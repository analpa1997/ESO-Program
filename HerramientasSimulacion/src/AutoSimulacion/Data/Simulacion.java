/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoSimulacion.Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author analpa1997
 */
public class Simulacion {

        private Calendario calendario;

        public Simulacion() {
        }

        public Simulacion(Calendario calendario) {
                this.calendario = calendario;
        }

        public Calendario getCalendario() {
                return calendario;
        }

        public void setCalendario(Calendario calendario) {
                this.calendario = calendario;
        }

        public void simular(int jornada) throws Exception {
                for (String[] encuentro : calendario.getJornada(jornada)) {
                        File dir = new File("Simulador.exe");
                        if (dir.exists()) {
                                ProcessBuilder pB = new ProcessBuilder("Reiniciar árbitros.exe");
                                pB.redirectErrorStream(true);
                                Process p = pB.start();
                                p.waitFor(1, TimeUnit.MILLISECONDS);

                                pB = new ProcessBuilder(dir + "");
                                pB.redirectErrorStream(true);
                                p = pB.start();
                                p.waitFor(1, TimeUnit.MILLISECONDS);

                                OutputStream os = p.getOutputStream();
                                BufferedWriter bW = new BufferedWriter(new OutputStreamWriter(os));
                                String input = encuentro[0];
                                input += "\n";
                                bW.write(input);
                                bW.flush();
                                input = encuentro[1];
                                input += "\n";
                                bW.write(input);
                                bW.flush();
                                input = "\n";
                                bW.write(input);
                                bW.flush();
                                // Se obtiene el stream de salida del programa
                                InputStream is = p.getInputStream();

                                /* Se prepara un bufferedReader para poder leer la salida más comodamente. */
                                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                                // Se lee la primera linea
                                String aux = "";
                                String salida = "";
                                FileWriter logSim = new FileWriter("logSimulacion.txt", true);
                                BufferedWriter bW2 = new BufferedWriter(logSim);
                                PrintWriter pW = new PrintWriter(bW2);
                                pW.println(encuentro[0] + " - " + encuentro[1]);
                                pW.println();
                                // Mientras se haya leido alguna linea
                                while ((aux = br.readLine()) != null) {
                                        salida = salida + aux + "\n";
                                }
                                String[] salidaCortada = salida.split("\n");
                                pW.println(salidaCortada[5]);
                                pW.println();
                                pW.close();
                                br.close();
                                is.close();
                        } else {
                                throw new Exception("No se encuentra el simulador en la carpeta");
                        }
                }
        }
}
