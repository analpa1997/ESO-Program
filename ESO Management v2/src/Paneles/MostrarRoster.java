/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import AccionesBotones.AccionesMostrarRoster;
import program.model.Utils.Cadena;
import java.awt.Component;
import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import program.model.Equipo.Roster;
import program.model.Tabla.ModeloTabla;

/**
 *
 * @author Antonio
 */
public class MostrarRoster extends AbstractPanel {

        private Roster equipo;
        private final String EURO = "\u20ac";
        private ModeloTabla modelo;

        /**
         * Creates new form MostrarRoster
         */
        public MostrarRoster() {
                initComponents();
        }

        public MostrarRoster(Roster equipo) {
                this();
                this.equipo = equipo;
                modelo = new ModeloTabla(equipo.rosterEnteroTabulado(), equipo.getCabeceraTablaRosterEnteroTabulado());

                tablaDatos.setModel(modelo);
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(tablaDatos.getModel());
                tablaDatos.setRowSorter(sorter);
                dimensionarColumnas(tablaDatos);

                // tablaDatos.setModel(modelo);
                // tablaDatos.setTableHeader(new JTableHeader());
                // refrescarPlantilla(equipo.toString());
        }

        /*   public void refrescarPlantilla(String texto) {
                plantillaLabel.setText(equipo.anyadirCabeceraHTML(equipo.escribirHTML(texto, true)));
                plantillaLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        }

        public String organizarPorNacionalidades() {
                String texto = "";
                String nacActual = "";
                String grupoJugadores = "";
                String cabecera = "";
                String lineaSeparadora = "----------------------------------------------------\n\n";
                for (Jugador j : equipo.getJugadores()) {
                        if (nacActual.equals("")) {
                                cabecera = "Jugadores de " + j.getNacionalidad() + ": ";
                                nacActual = j.getNacionalidad();
                        }
                        if (!nacActual.equals(j.getNacionalidad())) {
                                int jugadores = grupoJugadores.split("\n").length;
                                if (jugadores == 1) {
                                        cabecera += jugadores + " jugador\n";
                                } else {
                                        cabecera += jugadores + " jugadores\n";
                                }
                                cabecera += lineaSeparadora;
                                texto += cabecera;
                                texto = texto + grupoJugadores + "\n";
                                grupoJugadores = "";
                                cabecera = "Jugadores de " + j.getNacionalidad() + ": ";
                                nacActual = j.getNacionalidad();
                        }
                        grupoJugadores = grupoJugadores + j.toString() + "\n";
                }
                int jugadores = grupoJugadores.split("\n").length;
                if (jugadores == 1) {
                        cabecera += jugadores + " jugador\n";
                } else {
                        cabecera += jugadores + " jugadores\n";
                }
                cabecera += lineaSeparadora;
                texto += cabecera;
                texto = texto + grupoJugadores + "\n";
                texto = "<pre>" + texto + "</pre>";
                return texto;
        }

        public String escribirRendimiento() {
                String texto = "";
                String lineaSeparadora = "----------------------------------------------------\n\n";
                DecimalFormat df = new DecimalFormat("0.000");
                equipo.calcularRendimiento();
                for (int i = 1; i < 7; i++) {
                        String grupoJugadores = "";
                        String cabecera = "";
                        double rendTotal = 0;
                        double rendMedio = 0;
                        cabecera = "Rendimiento de los " + devolverPosicion(i);
                        int j = 1;
                        for (Jugador jugador : equipo.getJugadores()) {
                                String infoJugador = "";
                                if (jugador.getPosInt() == i) {
                                        infoJugador = j + ". " + escribirEspaciosCifras(j) + jugador.toStringReducido();
                                        infoJugador += escribirEspacios(39 - infoJugador.length());
                                        if (jugador.getRendimiento() >= 0) {
                                                infoJugador += escribirEspacios(1);
                                        }
                                        infoJugador += df.format(jugador.getRendimiento()) + " pts";
                                        rendTotal += jugador.getRendimiento();
                                        grupoJugadores += infoJugador + "\n";
                                        j++;
                                }
                        }
                        int numJugadores = grupoJugadores.split("\n").length;
                        rendMedio = rendTotal / numJugadores;
                        cabecera += " (" + numJugadores + " jugador";
                        if (numJugadores > 1) {
                                cabecera += "es";
                        }
                        cabecera += ")\n" + lineaSeparadora;
                        texto += cabecera;
                        texto += grupoJugadores;
                        texto += "\nRendimiento medio de los " + devolverPosicion(i) + ": " + df.format(rendMedio) + " pts\n\n";
                }
                texto += "Rendimiento total de (" + equipo.getAbreviatura().toLowerCase() + "): " + df.format(equipo.getRendimiento()) + " pts\n";
                texto += "Rendimiento medio de (" + equipo.getAbreviatura().toLowerCase() + "): " + df.format(equipo.getRendimiento() / equipo.getJugadores().size()) + " pts";
                return texto;
        }

        private String devolverPosicion(int posInt) {
                switch (posInt) {
                        case 1:
                                return "GK";
                        case 2:
                                return "DF";
                        case 3:
                                return "DM";
                        case 4:
                                return "MF";
                        case 5:
                                return "AM";
                        default:
                                return "FW";
                }
        }

        private int obtenerNumCifras(int numero) {
                int contador = 0;
                while (numero != 0) {
                        contador++;
                        numero = numero / 10;
                }
                return contador;
        }

        private String escribirEspaciosCifras(int num) {
                String espacio = " ";
                String result = "";
                for (int i = 0; i < (5 - (obtenerNumCifras(num))); i++) {
                        result += espacio;
                }
                return result;
        }

        private String escribirEspacios(int numero) {
                String espacio = " ";
                String result = "";
                for (int i = 0; i < numero; i++) {
                        result += espacio;
                }
                return result;
        }

        public String escribirSalarios() {
                String texto = "";
                DecimalFormat df = new DecimalFormat("###,###.##");
                equipo.calcularSalario();
                String cabecera = "SALARIOS (" + equipo.getAbreviatura().toLowerCase() + ")\n\nNUM    NOMBRE (CLUB)                    SALARIO\n----------------------------------------------------\n\n";
                texto = texto + cabecera;
                int i = 1;
                for (Jugador j : equipo.getJugadores()) {
                        String jugador = i + ". " + escribirEspaciosCifras(i) + j.toStringReducido();
                        jugador = jugador + escribirEspacios(40 - jugador.length());
                        jugador = jugador + df.format(j.getSalario()) + EURO + "\n";
                        texto = texto + jugador;
                        i++;
                }
                texto = texto + "\nSalario total del equipo: " + df.format(equipo.getSalario()) + EURO + "\nSalario medio del equipo: " + df.format(equipo.getSalario() / equipo.getJugadores().size()) + EURO;
                return texto;
        } */
        public void inicializarBotones() {
                AccionesMostrarRoster listener = (AccionesMostrarRoster) this.getListeners().get("Mostrar Roster");
                listener.setLlamada(this);
                listener.inicializarBooleans();
                tituloRoster.setHorizontalAlignment(JLabel.LEFT);
                tituloRoster.setText("Plantilla de " + equipo.getAbreviatura());
                tituloRoster.setIcon(equipo.getImagen());
                tituloRoster.setVerticalTextPosition(JLabel.BOTTOM);
                tituloRoster.setHorizontalTextPosition(JLabel.CENTER);
                posicionesRoster.setHorizontalAlignment(JLabel.RIGHT);
                posicionesRoster.setHorizontalTextPosition(JLabel.CENTER);
                posicionesRoster.setText(equipo.anyadirCabeceraHTML(equipo.escribirHTML("Posiciones\n" + equipo.escribirPosiciones(), false)));
                botonSalir.setActionCommand("salir");
                orderNombre.setActionCommand("ordenarNombre");
                orderEdad.setActionCommand("ordenarEdad");
                orderMedia.setActionCommand("ordenarMedia");
                orderRendimiento.setActionCommand("ordenarRendimiento");
                orderPais.setActionCommand("ordenarNacionalidad");
                orderSalario.setActionCommand("ordenarSalario");
                saveInformacion.setActionCommand("gInformacion");
                botonSalir.addActionListener(listener);
                orderNombre.addActionListener(listener);
                orderEdad.addActionListener(listener);
                orderMedia.addActionListener(listener);
                orderRendimiento.addActionListener(listener);
                orderPais.addActionListener(listener);
                orderSalario.addActionListener(listener);
                saveInformacion.addActionListener(listener);
        }

        public void guardarTexto(String titulo) {
                /*  Cadena texto = new Cadena(plantillaLabel.getText());
                texto.aString();*/

                String fileName = JOptionPane.showInputDialog("Introduce el nombre del archivo (sin extensión) donde quieres guardar la información (se guarda en .txt)", titulo);
                try {
                        PrintWriter pW = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName + ".txt"), StandardCharsets.UTF_8));
                        Cadena linea = new Cadena("");
                        for (int i = 0; i < modelo.getColumnCount(); i++) {
                                linea.setCadena(linea.toString() + modelo.getColumnName(i) + " ");
                        }
                        pW.println(linea.toString());
                        int longitud = linea.getLongitud();
                        linea = new Cadena("");
                        for (int i = 0; i < longitud; i++) {
                                linea.setCadena(linea.toString() + "-");
                        }
                        pW.println(linea.toString());
                        linea = new Cadena("");
                        for (int i = 0; i < modelo.getRowCount(); i++) {
                                for (int j = 0; j < modelo.getColumnCount(); j++) {
                                        linea.setCadena(linea.toString() + modelo.getValueAt(i, j).toString() + " ");
                                }
                                pW.println(linea.toString());
                                linea = new Cadena("");
                        }
                        pW.close();
                } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                }

        }

        public Roster getEquipo() {
                return equipo;
        }

        public void setEquipo(Roster equipo) {
                this.equipo = equipo;
        }

        public void dimensionarColumnas(JTable tablaDatos) {
                for (int i = 0; i < tablaDatos.getColumnCount(); i++) {
                        DefaultTableColumnModel colModel = (DefaultTableColumnModel) tablaDatos.getColumnModel();
                        TableColumn col = colModel.getColumn(i);
                        int width = 0;

                        TableCellRenderer renderer = col.getHeaderRenderer();
                        for (int r = 0; r < tablaDatos.getRowCount(); r++) {
                                renderer = tablaDatos.getCellRenderer(r, i);
                                Component comp = renderer.getTableCellRendererComponent(tablaDatos, tablaDatos.getValueAt(r, i),
                                        false, false, r, i);
                                width = Math.max(width, comp.getPreferredSize().width);
                        }
                        col.setPreferredWidth(width + 2);
                }
        }

        public void actualizarModelo(ModeloTabla modelo) {
                tablaDatos.setModel(modelo);
                this.modelo = modelo;
        }

        public void actualizarOrdenacion(TableRowSorter<TableModel> ordenacion) {
                tablaDatos.setRowSorter(ordenacion);
        }

        public TableModel getModeloTabla() {
                return tablaDatos.getModel();
        }

        /**
         * This method is called from within the constructor to
         * initialize the form. WARNING: Do NOT modify this code. The
         * content of this method is always regenerated by the Form
         * Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                java.awt.GridBagConstraints gridBagConstraints;

                contenedorPlantilla = new javax.swing.JScrollPane();
                jPanel1 = new javax.swing.JPanel();
                plantillaLabel = new javax.swing.JLabel();
                contenedorTabla = new javax.swing.JScrollPane();
                tablaDatos = new javax.swing.JTable();
                orderMedia = new javax.swing.JButton();
                orderNombre = new javax.swing.JButton();
                orderRendimiento = new javax.swing.JButton();
                orderEdad = new javax.swing.JButton();
                botonSalir = new javax.swing.JButton();
                saveInformacion = new javax.swing.JButton();
                orderPais = new javax.swing.JButton();
                orderSalario = new javax.swing.JButton();
                orderStats = new javax.swing.JButton();
                tituloRoster = new javax.swing.JLabel();
                posicionesRoster = new javax.swing.JLabel();

                setLayout(new java.awt.GridBagLayout());

                jPanel1.setLayout(new java.awt.GridBagLayout());

                plantillaLabel.setText("jLabel1");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                jPanel1.add(plantillaLabel, gridBagConstraints);

                tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null}
                        },
                        new String [] {
                                "Title 1", "Title 2", "Title 3", "Title 4"
                        }
                ));
                contenedorTabla.setViewportView(tablaDatos);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                jPanel1.add(contenedorTabla, gridBagConstraints);

                contenedorPlantilla.setViewportView(jPanel1);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.gridheight = 17;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.4;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 6);
                add(contenedorPlantilla, gridBagConstraints);

                orderMedia.setText("Ordenar por Media");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 2, 6);
                add(orderMedia, gridBagConstraints);

                orderNombre.setText("Ordenar Por Nombre");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 2, 6);
                add(orderNombre, gridBagConstraints);

                orderRendimiento.setText("Ordenar por Rendimiento");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 5;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 2, 6);
                add(orderRendimiento, gridBagConstraints);

                orderEdad.setText("Ordenar por Edad");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 2, 6);
                add(orderEdad, gridBagConstraints);

                botonSalir.setText("Salir");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 17;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 6, 6);
                add(botonSalir, gridBagConstraints);

                saveInformacion.setText("Guardar Información");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 16;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 2, 6);
                add(saveInformacion, gridBagConstraints);

                orderPais.setText("Ordenar por Nacionalidad");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 2, 6);
                add(orderPais, gridBagConstraints);

                orderSalario.setText("Ordenar por Salario");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 6;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.1;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 2, 6);
                add(orderSalario, gridBagConstraints);

                orderStats.setText("Ordenar por Estadisticas");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 7;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weighty = 0.1;
                gridBagConstraints.insets = new java.awt.Insets(5, 6, 2, 6);
                add(orderStats, gridBagConstraints);

                tituloRoster.setText("jLabel1");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.insets = new java.awt.Insets(5, 13, 2, 8);
                add(tituloRoster, gridBagConstraints);

                posicionesRoster.setText("jLabel1");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 2, 6);
                add(posicionesRoster, gridBagConstraints);
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton botonSalir;
        private javax.swing.JScrollPane contenedorPlantilla;
        private javax.swing.JScrollPane contenedorTabla;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JButton orderEdad;
        private javax.swing.JButton orderMedia;
        private javax.swing.JButton orderNombre;
        private javax.swing.JButton orderPais;
        private javax.swing.JButton orderRendimiento;
        private javax.swing.JButton orderSalario;
        private javax.swing.JButton orderStats;
        private javax.swing.JLabel plantillaLabel;
        private javax.swing.JLabel posicionesRoster;
        private javax.swing.JButton saveInformacion;
        private javax.swing.JTable tablaDatos;
        private javax.swing.JLabel tituloRoster;
        // End of variables declaration//GEN-END:variables
}
