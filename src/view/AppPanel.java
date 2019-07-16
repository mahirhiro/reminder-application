package view;

import model.App;
import model.Obj;
import model.SimpleModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class AppPanel extends JPanel implements Observer {

    private App application;
    private Obj obj;
    private SimpleModel sm;

    private DefaultTableModel model;


    public AppPanel(App application,Color color) {
        this.application = application;
        setOpaque(true);
        setFocusable(true);
        application.addObserver(this);
        setVisible(true);
        setBackground(color);
        model = new DefaultTableModel(new Object[][]{}, new String[]{"            PRIORITY", "EVENT", "DATE"});}

    public DefaultTableModel getModel() {
        return model;
    }


    public void addData(int priority) {
        model.addRow(new Object[]{ priority, 35, 3});
        model.fireTableDataChanged();
        table_1.setModel(model);
        System.out.println(model.getRowCount());//returns 1
        System.out.println(model.getColumnCount());
    }
    public void setModel() {
        model.addRow(new Object[]{         "              hkdkdvk", 35, 3});
        repaint();
    }


    public int askPriorityNumber(){
        int priority = 0;
        Integer[] nums  = { 1,2,3,4,5 };
        while (priority == 0){
            try{
                priority = (int) JOptionPane.showInputDialog(null, "Choose now...",
                        "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
                        // default
                        // icon
                        nums, // Array of choices
                        nums[0]);
            } catch (NullPointerException e){
                priority = 0;
            }
        }
        System.out.println(" yo " + priority);
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

