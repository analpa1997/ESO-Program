/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccionesBotones;

import Paneles.*;
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
        protected AbstractPanel panelLlamado;
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

        public ESO_Management_v2 getPantallaPrincipal() {
                return pantallaPrincipal;
        }

        public void setPantallaPrincipal(ESO_Management_v2 pantallaPrincipal) {
                this.pantallaPrincipal = pantallaPrincipal;
        }

        public AbstractPanel getPanelLlamado() {
                return panelLlamado;
        }

        public void setPanelLlamado(AbstractPanel panelLlamado) {
                this.panelLlamado = panelLlamado;
        }

        public Stack<JPanel> getPantallas() {
                return pantallas;
        }

        public void setPantallas(Stack<JPanel> pantallas) {
                this.pantallas = pantallas;
        }

        public Liga getLiga() {
                return liga;
        }

        public void setLiga(Liga liga) {
                this.liga = liga;
        }

}
