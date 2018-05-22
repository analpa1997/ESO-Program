/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccionesBotones;

import VPrincipal.ESO_Management_v2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JPanel;
import program.model.Liga.Liga;

/**
 *
 * @author Antonio
 */
public abstract class Acciones implements ActionListener {

        protected ESO_Management_v2 pantallaPrincipal;
        protected Stack<JPanel> pantallas;
        protected Liga liga;

        public Acciones() {
                pantallas = new Stack<>();
                liga = new Liga();
        }

        public Acciones(ESO_Management_v2 vPrincipal) {
                this();
                pantallaPrincipal = vPrincipal;
                pantallas = pantallaPrincipal.getPantallas();
                liga = pantallaPrincipal.getLiga();
        }

        public abstract void actionPerformed(ActionEvent e);

        public void salir() {
                pantallaPrincipal.remove(pantallas.lastElement());
                pantallas.pop();
                pantallaPrincipal.add(pantallas.lastElement());
                pantallas.lastElement().updateUI();
                pantallas.lastElement().repaint();
                pantallaPrincipal.repaint();
        }
}
