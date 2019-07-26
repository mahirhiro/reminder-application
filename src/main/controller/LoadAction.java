package main.controller;

import main.view.AppPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoadAction extends AbstractAction {

    private final AppPanel panel;

    public LoadAction(AppPanel panel) {
        super("Load");
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Loading");
        panel.loadTable();
    }
}
