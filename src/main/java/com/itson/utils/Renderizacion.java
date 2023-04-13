package com.itson.utils;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author
 */
public class Renderizacion extends DefaultTableCellRenderer {

    public Renderizacion() {
    }

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
