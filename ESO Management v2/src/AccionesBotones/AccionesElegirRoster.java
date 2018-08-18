/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccionesBotones;

import Paneles.*;
import VPrincipal.ESO_Management_v2;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import program.model.Equipo.Roster;
import program.model.Liga.Equipos;

/**
 *
 * @author Antonio
 */
public class AccionesElegirRoster extends Acciones {

        private Equipos equipos;

        public AccionesElegirRoster() {
                super();
        }

        public AccionesElegirRoster(ESO_Management_v2 contenedorPpal) {
                super(contenedorPpal);
        }

        public AccionesElegirRoster(ESO_Management_v2 contenedorPpal, Equipos teams) {
                super(contenedorPpal);
                setEquipos(teams);
        }

        public Equipos getEquipos() {
                return equipos;
        }

        public void setEquipos(Equipos equipos) {
                this.equipos = equipos;
        }

        public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                        case "salir":
                                salir();
                                break;
                        case "gEquipos":
                                try {
                                        liga.guardarEquipos();
                                        liga.guardarTodosJugadores();
                                } catch (IOException ex) {
                                        System.err.println("Las plantillas no se pudieron guardar");
                                }
                                break;
                        case "gSelecciones":
                                try {
                                        liga.guardarSeleccionesLiga();
                                } catch (IOException ex) {
                                        System.err.println("Las plantillas no se pudieron guardar");
                                }
                                break;
                        case "gTodasSelecciones":
                                try {
                                        liga.guardarTodasSelecciones();
                                } catch (IOException ex) {
                                        System.err.println("Las plantillas no se pudieron guardar");
                                }
                                break;
                        case "gSalariosAZ":
                                try {
                                        PrintWriter pW = new PrintWriter(new OutputStreamWriter(new FileOutputStream(JOptionPane.showInputDialog("Escribe el nombre del fichero en el que quieres guardar los salarios por abreviatura (sin .txt)") + ".txt"), StandardCharsets.UTF_8));
                                        String[] contenido = equipos.escribirSalariosAbrev().split("\n");
                                        for (String s : contenido) {
                                                pW.println(s);
                                                ;
                                        }
                                        pW.close();
                                } catch (IOException ex) {
                                        JOptionPane.showMessageDialog(panelLlamado, ex.getMessage());
                                }
                                break;
                        case "gSalariosMayMenor":
                                try {
                                        PrintWriter pW = new PrintWriter(new OutputStreamWriter(new FileOutputStream(JOptionPane.showInputDialog("Escribe el nombre del fichero en el que quieres guardar los salarios de mayor a menor (sin .txt)") + ".txt"), StandardCharsets.UTF_8));
                                        String[] contenido = equipos.escribirSalariosMayMenor().split("\n");
                                        for (String s : contenido) {
                                                pW.println(s);
                                                ;
                                        }
                                        pW.close();
                                } catch (IOException ex) {
                                        JOptionPane.showMessageDialog(panelLlamado, ex.getMessage());
                                }
                                break;
                        case "mPlantilla":
                                JButton source = (JButton) e.getSource();
                                String abrev = source.getText().toLowerCase();
                                Roster equipo = null;
                                equipo = liga.getEquiposLiga().buscarEquipo(abrev);
                                if (equipo == null) {
                                        equipo = liga.getSeleccionesLiga().buscarEquipo(abrev);
                                }
                                if (equipo == null) {
                                        equipo = liga.getTodasSelecciones().buscarEquipo(abrev);
                                }
                                if (equipo == null) {
                                        equipo = liga.getJugadores();
                                }
                                MostrarRoster mRoster = new MostrarRoster(equipo);
                                mRoster.setPadre(pantallas.lastElement());
                                ElegirRoster eRoster = (ElegirRoster) pantallas.lastElement();
                                mRoster.setListeners(eRoster.getListeners());
                                mRoster.inicializarBotones();
                                pantallaPrincipal.remove(pantallas.lastElement());
                                pantallas.push(mRoster);
                                pantallaPrincipal.add(mRoster);
                                mRoster.updateUI();
                                mRoster.repaint();
                                pantallaPrincipal.repaint();
                                break;
                }
        }

}
