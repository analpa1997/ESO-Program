/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import AccionesBotones.*;
import java.awt.Container;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Antonio
 */
public class AbstractPanel extends JPanel {

        private Container padre;
        private HashMap<String, Acciones> listeners;

        public AbstractPanel() {

        }

        public AbstractPanel(Container parent) {
                padre = parent;
        }

        public AbstractPanel(Container parent, HashMap<String, Acciones> manejadores) {
                padre = parent;
                listeners = manejadores;
        }

        public Container getPadre() {
                return padre;
        }

        public void setPadre(Container padre) {
                this.padre = padre;
        }

        public HashMap<String, Acciones> getListeners() {
                return listeners;
        }

        public void setListeners(HashMap<String, Acciones> listeners) {
                this.listeners = listeners;
        }

}
