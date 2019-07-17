package view;

import com.toedter.calendar.JDateChooser;
import model.App;
import model.Obj;
import model.SimpleModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class AppPanel extends JPanel implements Observer {

    private App application;
    private Obj obj;
    private SimpleModel sm;

    private DefaultTableModel model;


    public void setDateChooser(JDateChooser dateChooser) {
        this.dateChooser = dateChooser;
    }

    public JDateChooser getDateChooser() {
        return dateChooser;
    }

    private com.toedter.calendar.JDateChooser dateChooser = new com.toedter.calendar.JDateChooser();



    public String askForDate(){
        String message ="Choose start date:\n";
        Object[] params = {message,dateChooser};
        JOptionPane.showConfirmDialog(null,params,"Start date", JOptionPane.DEFAULT_OPTION);

        String s="";
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        s=sdf.format(((JDateChooser)params[1]).getDate());
        return s;
    }

    public AppPanel(App application,Color color) {
        this.application = application;
        setOpaque(true);
        setFocusable(true);
        application.addObserver(this);
        setVisible(true);
        setBackground(color);
        model = new DefaultTableModel(new Object[][]{}, new String[]{"PRIORITY", "EVENT", "DATE"});}

    public DefaultTableModel getModel() {
        return model;
    }


    public void addData(int priority,String s) {
        model.addRow(new Object[]{ priority, 3, s});
        model.fireTableDataChanged();
        table_1.setModel(model);
        System.out.println(model.getRowCount());//returns 1
        System.out.println(model.getColumnCount());
    }


    public int askPriorityNumber(){
        int priority = 0;
        Integer[] nums  = {1,2,3,4,5};
        while (priority == 0){
            try{
                priority = (int) JOptionPane.showInputDialog(null, "Choose now...",
                        "Choose the priority of the event", JOptionPane.QUESTION_MESSAGE, null, // Use
                        // default
                        // icon
                        nums, // Array of choices
                        nums[0]);
            } catch (NullPointerException e){
                priority = 0;
            }
        }
        return priority;
    }





    private JTable table_1 = new JTable(getModel());





    public JTable getTable(){
        return table_1;
    }


    public AppPanel(Color color) {
        setOpaque(true);
        setFocusable(true);
        application.addObserver(this);
        setVisible(true);
        setBackground(color);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    public void askAddTask() {

    }

        public void editATask () {

        }

        public void deleteATask () {

        }


        public void saveFileName () {

        }
        private void writeAll () throws IOException {


        }


    }

