/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.awt.Container;
import javax.swing.*;

/**
 *
 * @author Antonio
 */
public class AbstractPanel extends JPanel {

        private Container padre;

        public AbstractPanel() {

        }

        public AbstractPanel(Container parent) {
                padre = parent;
        }

        public Container getPadre() {
                return padre;
        }

        public void setPadre(Container padre) {
                this.padre = padre;
        }

}
