package controller;

import model.App;
import view.AppPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class SaveAction extends AbstractAction implements Observer {

    private App application;
    private AppPanel panel;


    public SaveAction(App application, AppPanel panel) {
        super("Save");
        this.application = application;
        this.panel = panel;
        application.addObserver(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Saving");
        panel.saveTable();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
