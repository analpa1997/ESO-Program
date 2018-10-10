/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model.Tabla;

import javax.swing.event.*;
import javax.swing.table.*;

/**
 *
 * @author analpa1997
 */
public class ModeloTabla extends AbstractTableModel {

        Object datos[][];
        String columnNames[];

        // Esta clase imprime los datos en la consola cada vez
        // que se produce un cambio en cualquiera de las
        // casillas de la tabla
        class TablaListener implements TableModelListener {

                @Override
                public void tableChanged(TableModelEvent evt) {
                        for (int i = 0; i < datos.length; i++) {
                                for (int j = 0; j < datos[0].length; j++) {
                                        System.out.print(datos[i][j] + " ");
                                }
                                System.out.println();
                        }
                        fireTableDataChanged();
                }
        }
        // Constructor

        public ModeloTabla() {
                addTableModelListener(new TablaListener());
        }

        public ModeloTabla(Object[][] lista) {
                datos = lista;
                addTableModelListener(new TablaListener());
        }

        public ModeloTabla(Object[][] lista, String[] columnNames) {
                datos = lista;
                this.columnNames = columnNames;
                addTableModelListener(new TablaListener());
        }
        // Devuelve el número de columnas de la tabla

        public int getColumnCount() {
                return (datos[0].length);
        }
        // Devuelve el número de filas de la tabla

        public int getRowCount() {
                return (datos.length);
        }
        // Devuelve el valor de una determinada casilla de la tabla
        // identificada mediante fila y columna

        public Object getValueAt(int fila, int col) {
                return (datos[fila][col]);
        }
        // Cambia el valor que contiene una determinada casilla de
        // la tabla

        public void setValueAt(Object valor, int fila, int col) {
                datos[fila][col] = valor;
                // Indica que se ha cambiado
                //fireTableDataChanged();
        }
        // Indica si la casilla identificada por fila y columna es
        // editable

        public boolean isCellEditable(int fila, int col) {
                return (true);
        }

        public String getColumnName(int col) {
                return columnNames[col].toString();
        }

        public Class<?> getColumnClass(int columnIndex) {
                return getValueAt(0, columnIndex).getClass();
        }
}
