package controller;

import model.App;
import view.AppPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class AddTaskAction extends AbstractAction implements Observer {

    private App application;
    private AppPanel panel;
    private int counter = 0;

    public AddTaskAction(App application, AppPanel panel) {
        super("Add Task");
        this.application = application;
        this.panel = panel;
        application.addObserver(this);
        counter++;

    }

    private void fixEnabled(){
        if ( counter > 5) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Adding new Task");
        panel.askAddTask();
        application.refresh();
        fixEnabled();
    }

    @Override
    public void update(Observable o, Object arg) {
        fixEnabled();
    }
}
