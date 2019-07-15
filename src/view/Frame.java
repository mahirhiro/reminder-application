package view;

import model.App;
import view.buttons.ExitButton;
import view.buttons.LoadButton;
import view.buttons.SaveButton;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

import static java.util.Calendar.*;

public class Frame extends JFrame {

    private App application;

    public Frame(App application) {
        this.application = application;
        this.setTitle("ToDo List");

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,800));

        this.setResizable(false);

        AppPanel panel = new AppPanel(application);

        JMenuBar jmb = new JMenuBar();
        JMenu file = new JMenu("File");

        /* adding the buttons for the 'file' menu */
        file.add(new SaveButton(application, panel));
        file.addSeparator();
        file.add(new LoadButton(application, panel));
        file.addSeparator();
        file.add(new ExitButton(application));

        jmb.add(file);






        this.setJMenuBar(jmb);
        this.getContentPane().add(panel);

        this.pack();
        this.setLocationRelativeTo (null); // Center on screen.
        this.setVisible(true);
    }
}
