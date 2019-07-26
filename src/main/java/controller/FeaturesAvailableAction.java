package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FeaturesAvailableAction extends AbstractAction {

    public FeaturesAvailableAction() {
        super("Features");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Information");
        String tips = ("1.Click 'Add a Task' or 'Ctrl-A' to add an event \n\n" +
                "2.Click 'Edit a Task' or 'Ctrl-E' when a row is selected to edit a column of an event \n\n" +
                "3.Click 'Delete a Task' or 'Ctrl-D' when a row is selected to delete a row \n\n" +
                "4.If you would like to save your current TODO list, please click 'Save' or 'Ctrl-S' to save the file \n\n" +
                "5.If you would like to load a previous TODO list, please click 'Load' or 'Ctrl-L' to load the file \n\n" +
                "6.Click on any column header if you would like to sort your TODO list \n\n" + "7. Click 'Clear all Tasks' or 'Ctrl-C' to clear our the entire table \n\n" +
                "8.Click 'Exit' or 'Ctrl-Q' to Exit the application \n\n");
        JOptionPane.showMessageDialog(null, tips, "Features available", JOptionPane.INFORMATION_MESSAGE);

    }
}
