package controller;

import model.App;
import view.AppPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class ClearButtonAction extends AbstractAction {

    private App application;
    private AppPanel panel;

    public ClearButtonAction(App application, AppPanel panel) {
        super("Clear all Task");
        this.application = application;
        this.panel = panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        panel.clearTable();
    }

}
