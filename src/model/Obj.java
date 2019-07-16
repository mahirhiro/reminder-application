package model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class Obj {

    private ArrayList<App> arr = new ArrayList<App>();

    public Obj() {

    }


    public void addTodo(App to) {
        arr.add(to);
        //sortObjects();
    }

    public void sortObjects() {
        // Collections.sort(Objects);
    }

    public int getSize() {
        return arr.size();
    }

    public App getObject(int i) {
        return arr.get(i);
    }

    private DefaultTableModel model;

    public Obj(JTable table) {
        model = (DefaultTableModel) table.getModel();
    }


}
