package view;

import com.toedter.calendar.JDateChooser;
import model.App;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.Observer;

public class AppPanel extends JPanel implements Observer {

    private App application;

    private DefaultTableModel model;

    private com.toedter.calendar.JDateChooser dateChooser = new com.toedter.calendar.JDateChooser();

    private JTable table_1 = new JTable(getModel());


    public JDateChooser getDateChooser() {
        return dateChooser;
    }

    public AppPanel(App application,Color color) {
        this.application = application;
        setOpaque(true);
        setFocusable(true);
        application.addObserver(this);
        setVisible(true);
        setBackground(color);
        model = new DefaultTableModel(new Object[][]{}, new String[]{"EVENT", "PRIORITY", "DATE"}) {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };
        table_1.setCellSelectionEnabled(true);
        model.addRow(new Object[]{"Gym", 1, "07/06/2019"});
        table_1.setColumnSelectionAllowed(false);
    }


    public DefaultTableModel getModel() {
        return model;
    }


    public String askForDate(){
        String message ="Choose start date:\n";
        Object[] params = {message,dateChooser};
        String s = "";
        JOptionPane.showConfirmDialog(null, params, "Enter the event date", JOptionPane.DEFAULT_OPTION);
        while (dateChooser.getDate() == null) {
                JOptionPane.showConfirmDialog(null, params, "Please enter the event date again!", JOptionPane.DEFAULT_OPTION);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        s = sdf.format(((JDateChooser) params[1]).getDate());
        return s;
    }


    public void addData(int priority,String date,String eventName) {
        model.addRow(new Object[]{eventName, priority, date});
        model.fireTableDataChanged();
        table_1.setModel(model);
    }


    public int askPriorityNumber(){
        int priority = 0;
        Integer[] priorityArrayOptions  = {1,2,3,4,5};
        while (priority == 0){
            try{
                priority = (int) JOptionPane.showInputDialog(null, "Choose now...",
                        "Choose the priority of the event", JOptionPane.QUESTION_MESSAGE, null, // Use
                        // default
                        // icon
                        priorityArrayOptions, // Array of choices
                        priorityArrayOptions[0]);
            } catch (NullPointerException e){
                System.out.println("Null pointer error");
            }
        }
        return priority;
    }


    public String askForEvent() {
        String eventName;
        eventName = JOptionPane.showInputDialog(null,"Enter a name for the event:", "Event Name Input", JOptionPane.INFORMATION_MESSAGE);
        assert eventName != null;
        while (eventName.isEmpty()){
            try{
                eventName = JOptionPane.showInputDialog(null,"Enter a name for the event:", "Event Name Input", JOptionPane.INFORMATION_MESSAGE);
            } catch (NullPointerException e){
                eventName = null;
                System.out.println("Null pointer exception!");

            }
        }
        return eventName;
    }

    public JTable getTable(){
        return table_1;
    }


    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }


    public void editATask () {

    }

    public void deleteATask () {

    }


    public void saveFileName () {

    }


    public void clearTable() {
        model.setRowCount(0);
    }

    public void getNUM() {
        System.out.println("row: " +table_1.getRowCount() + "\n");
        System.out.println("column: " +table_1.getColumnCount() + "\n");
    }

}
