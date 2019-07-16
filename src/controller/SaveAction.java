package controller;

import model.App;
import model.Obj;
import view.AppPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class SaveAction extends AbstractAction implements Observer {

    private App application;
    private AppPanel panel;
    private Obj obj;

    public SaveAction(App application, AppPanel panel, Obj obj) {
        super("Save");
        this.application = application;
        this.panel = panel;
        this.obj = obj;
        application.addObserver(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Saving");
        panel.saveFileName();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
