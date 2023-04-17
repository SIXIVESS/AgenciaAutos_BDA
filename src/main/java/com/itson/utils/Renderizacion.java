package com.itson.utils;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public class Renderizacion extends DefaultTableCellRenderer {

    /**
     * Constructor por defecto
     */
    public Renderizacion() {
    }

    /**
     *  Método que se encarga de crear un botón dentro de la tabla
     * @param tabla Tabla de los trámites
     * @param valor 
     * @param isSelected
     * @param hasFocus
     * @param row Fila
     * @param column Columna
     * @return 
     */
    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean isSelected,
            boolean hasFocus, int row, int column) {
        if (valor instanceof JButton) {
            JButton boton = (JButton) valor;
            return boton;
        }
        return super.getTableCellRendererComponent(tabla, valor, isSelected, hasFocus, row, column);
    }

}
