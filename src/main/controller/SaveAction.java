package main.controller;

import main.view.AppPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveAction extends AbstractAction {

    private final AppPanel panel;

    public SaveAction(AppPanel panel) {
        super("Save");
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Saving");
        panel.saveTable();
    }

}
