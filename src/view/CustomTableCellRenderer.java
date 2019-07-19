package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (table.isCellSelected(row, column)) {
            setForeground(Color.red);
        } else if (table.isRowSelected(row)) {
            setForeground(Color.green);
        } else if (table.isColumnSelected(column)) {
            setForeground(Color.blue);
        } else {
            setForeground(Color.black);
        }
        return c;
    }
}