package controller;

import model.App;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExitAction extends AbstractAction {

    private App application;
    public ExitAction(App application) {
        super("Exit");
        this.application = application;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Exiting");
        System.exit(0);
    }
}
