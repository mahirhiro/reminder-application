package controller;

import view.AppPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddTaskAction extends AbstractAction{

    private final AppPanel panel;
    private int counter = 0;

    public AddTaskAction(AppPanel panel) {
        super("Add Task");
        this.panel = panel;
        fixEnabled();
    }

    /* This method allows us to disable the add button after a certain number of events have been added */
    private void fixEnabled(){
        if ( counter > 14) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        System.out.println("Adding new Task");
        String event = panel.askForEventName();
        int priority = panel.askForPriorityNumber();
        String date = panel.askForDate();
        panel.addData(priority,date,event);
        fixEnabled();
    }
}
