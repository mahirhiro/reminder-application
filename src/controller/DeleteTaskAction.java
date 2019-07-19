package controller;

import model.App;
import view.AppPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class DeleteTaskAction extends AbstractAction implements Observer {
    private App application;
    private AppPanel panel;

    public DeleteTaskAction(App application, AppPanel panel) {
        super("Delete a Task");
        this.application = application;
        this.panel = panel;
        application.addObserver(this);
    }

    //TODO Check if the selected item in the list exits or not
    private void fixEnabled(){

    }

    JRootPane rootPane = new JRootPane();
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Deleting a Task");
        DefaultTableModel model = (DefaultTableModel) panel.getTable().getModel();
        if (panel.getTable().getSelectedRow() == -1) {
            if (panel.getTable().getRowCount() == 0) {
                JOptionPane.showMessageDialog(rootPane, "No data to be deleted.!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please select and item to delete!");
            }
        } else {
            model.removeRow(panel.getTable().getSelectedRow());
        }

        application.refresh();
        fixEnabled();
    }

    @Override
    public void update(Observable o, Object arg) {
        fixEnabled();
    }
}
