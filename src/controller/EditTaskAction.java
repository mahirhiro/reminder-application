package controller;

import view.AppPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class EditTaskAction extends AbstractAction {

    private final AppPanel panel;
    private final JRootPane rootPane = new JRootPane();

    public EditTaskAction(AppPanel panel) {
        super("Edit a Task");
        this.panel = panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Editing a Task");
        if (panel.getTable().getSelectedRow() == -1) {
            if (panel.getTable().getRowCount() == 0) {
                JOptionPane.showMessageDialog(rootPane, "No data to be edited!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please select and item to edit!");
            }
        } else {
            panel.editTableValues();
        }
    }
}

