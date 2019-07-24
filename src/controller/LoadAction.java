package controller;

import model.App;
import view.AppPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class LoadAction extends AbstractAction implements Observer {

    private App application;
    private AppPanel panel;

    public LoadAction(App application, AppPanel panel) {
        super("Load");
        this.application = application;
        this.panel = panel;
        application.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Loading");
        panel.loadTable();
    }
}
