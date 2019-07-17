package controller;

import view.AppPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddTaskAction extends AbstractAction{

    private AppPanel panel;
    private int counter = 0;

    public AddTaskAction(AppPanel panel) {
        super("Add Task");
        this.panel = panel;
        fixEnabled();
    }

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
        int priority = panel.askPriorityNumber();
        String date = panel.askForDate();
        String event = panel.askForEvent();
        panel.addData(priority,date,event);
        fixEnabled();
    }

}
