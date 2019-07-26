package main.controller;

import main.view.AppPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ClearButtonAction extends AbstractAction {

    private final AppPanel panel;

    public ClearButtonAction(AppPanel panel) {
        super("Clear all Task");
        this.panel = panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        panel.clearTable();
    }

}
