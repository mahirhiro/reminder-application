package model;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class SimpleModel extends AbstractTableModel {

    public Vector getTextData() {
        return textData;
    }

    public void setTextData(Vector textData) {
        this.textData = textData;
    }

    private Vector textData = new Vector();

    @Override
    public int getRowCount() {
        return textData.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return textData.elementAt(row);
    }

    public void addText(String text) {
        textData.addElement(text);
        fireTableDataChanged();
    }
}
