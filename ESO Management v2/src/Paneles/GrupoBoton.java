/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;

/**
 *
 * @author analp
 */
public class GrupoBoton extends ButtonGroup {

        private ArrayList<JToggleButton> todosBotones;

        public GrupoBoton() {
                this(new ArrayList());
        }

        public GrupoBoton(ArrayList<JToggleButton> botones) {
                todosBotones = botones;
        }

        public void activarBotones() {
                for (JToggleButton b : todosBotones) {
                        b.setEnabled(true);
                }
        }

        public void actualizarPanel(GrupoBoton otroGrupo, JToggleButton boton) {
                int indice = this.obtenerIndice(boton);
                otroGrupo.activarBotones();
                otroGrupo.getTodosBotones().get(indice).setEnabled(false);
        }

        public boolean esBotonEsteGrupo(JToggleButton button) {
                for (JToggleButton b : todosBotones) {
                        if (button == b) {
                                return true;
                        }
                }
                return false;
        }

        public int obtenerIndice(JToggleButton boton) {
                for (int i = 0; i < todosBotones.size(); i++) {
                        if (todosBotones.get(i) == boton) {
                                return i;
                        }
                }
                return -1;
        }

        public JToggleButton obtenerMismoBoton(String nombreBoton) {
                for (JToggleButton b : todosBotones) {
                        if (nombreBoton.equals(b.getText())) {
                                return b;
                        }
                }
                return null;
        }

        public ArrayList<JToggleButton> getTodosBotones() {
                return todosBotones;
        }

        public void setTodosBotones(ArrayList<JToggleButton> todosBotones) {
                this.todosBotones = todosBotones;
        }

}
