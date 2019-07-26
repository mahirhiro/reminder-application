package view;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

//import model.App;

public class AppPanel extends JPanel {

    private final DefaultTableModel model;

    private final JDateChooser dateChooser = new JDateChooser();

    private final JTable table_1 = new JTable(getModel());

    private final JFileChooser myJFileChooser = new JFileChooser(new File("."));

    public AppPanel(Color color) {
        setOpaque(true);
        setFocusable(true);
        setVisible(true);
        setBackground(color);
        model = new DefaultTableModel(new Object[][]{}, new String[]{"EVENT", "PRIORITY", "DATE"}) {
            /* This avoids the user from being able to edit cells without the button */
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        /*  This lets the user only select the entire row as a whole */
        table_1.setCellSelectionEnabled(true);
        table_1.setColumnSelectionAllowed(false);

        /* This allows the user to sort the data on the table */
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table_1.setRowSorter(sorter);
    }

    public DefaultTableModel getModel() {
        return model;
    }

    /* This method allows to receive a user input for the preferred date */
    public String askForDate() {
        String message = "Please select a date:\n";
        Object[] params = {message, dateChooser};
        String s;
        JOptionPane.showConfirmDialog(null, params, "Event date input", JOptionPane.DEFAULT_OPTION);
        while (dateChooser.getDate() == null) {
            JOptionPane.showConfirmDialog(null, params, "Please enter the event date again!", JOptionPane.DEFAULT_OPTION);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        s = sdf.format(((JDateChooser) params[1]).getDate());
        return s;
    }

    /* This method takes the required information from the user to be able to populate the table with more information*/
    public void addData(int priority, String date, String eventName) {
        model.addRow(new Object[]{eventName, priority, date});
        model.fireTableDataChanged();
        table_1.setModel(model);
    }

    /* This method allows to receive a user input for the preferred priority number */
    public int askForPriorityNumber() {
        int priority = 0;
        Integer[] priorityArrayOptions = {1, 2, 3, 4, 5};
        while (priority == 0) {
            try {
                priority = (int) JOptionPane.showInputDialog(null, "Please choose the priority of the event",
                        "Priority Number Input", JOptionPane.QUESTION_MESSAGE, null, // Use
                        // default
                        // icon
                        priorityArrayOptions, // Array of choices
                        priorityArrayOptions[0]);
            } catch (NullPointerException e) {
                System.out.println("Null pointer error");
            }
        }
        return priority;
    }

    /* This method allows to receive a user input for the preferred event name */
    public String askForEventName() {
        String eventName;
        eventName = JOptionPane.showInputDialog(null, "Please enter a name for the event:", "Event Name Input", JOptionPane.INFORMATION_MESSAGE);
        while (eventName == null || eventName.isEmpty()) {
            try {
                eventName = JOptionPane.showInputDialog(null, "Please enter a name for the event:", "Event Name Input", JOptionPane.INFORMATION_MESSAGE);
            } catch (NullPointerException e) {
                System.out.println("Null pointer exception!");
                eventName = null;
            }
        }
        return eventName;
    }

    /* This method allows the user to edit information which already exists on the table */
    public void editTableValues() {
        String[] options = {"Edit Event Date", "Edit Event Priority", "Edit Event Name"};
        int x = JOptionPane.showOptionDialog(null,
                "Please select the option you would like to edit",
                "Edit Option Panel", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
        if (x == JOptionPane.YES_OPTION) {
            model.setValueAt(askForDate(), table_1.getSelectedRow(), 2);
        } else if (x == JOptionPane.CANCEL_OPTION) {
            model.setValueAt(askForEventName(), table_1.getSelectedRow(), 0);

        } else if (x == JOptionPane.NO_OPTION) {
            model.setValueAt(askForPriorityNumber(), table_1.getSelectedRow(), 1);
        }

    }

    public JTable getTable() {
        return table_1;
    }

    /* These methods help save and load files */
    public void saveTable() {
        if (myJFileChooser.showSaveDialog(this) ==
                JFileChooser.APPROVE_OPTION) {
            saveTable(myJFileChooser.getSelectedFile());
        }
    }

    private void saveTable(File file) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(file));
            out.writeObject(model.getDataVector());
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadTable() {
        clearTable();
        if (myJFileChooser.showOpenDialog(this) ==
                JFileChooser.APPROVE_OPTION)
            loadTable(myJFileChooser.getSelectedFile());
    }

    private void loadTable(File file) {
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(file));
            Vector rowData = (Vector) in.readObject();
            for (Object rowDatum : rowData) {
                model.addRow((Vector) rowDatum);
            }
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* This method allows us to clear the entire table with the click of a button */
    public void clearTable() {
        model.setRowCount(0);
    }

}