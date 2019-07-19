package controller;

import model.App;
import view.AppPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class EditTaskAction extends AbstractAction implements Observer {

    private App application;
    private AppPanel panel;

    public EditTaskAction(App application, AppPanel panel) {
        super("Edit a Task");
        this.application = application;
        this.panel = panel;
        application.addObserver(this);
    }

    //TODO Check if the selected item in the list exits or not
    private void fixEnabled(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Editing a Task");

        DefaultTableModel model = (DefaultTableModel) panel.getTable().getModel();
        model.setValueAt(panel.askForEvent(), panel.getTable().getSelectedRow(), 0);
        model.setValueAt(panel.askPriorityNumber(), panel.getTable().getSelectedRow(), 1);
        model.setValueAt(panel.askForDate(), panel.getTable().getSelectedRow(), 2);
        fixEnabled();
    }

    @Override
    public void update(Observable o, Object arg) {
        fixEnabled();
    }
}

