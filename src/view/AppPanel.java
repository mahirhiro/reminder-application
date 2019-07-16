package view;

import model.App;
import model.Obj;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class AppPanel extends JPanel implements Observer {

    private App application;
    private Obj obj;


    public AppPanel(App application,Color color) {
        this.application = application;
        setOpaque(true);
        setFocusable(true);
        application.addObserver(this);
        setVisible(true);
        setBackground(color);

    }
    public AppPanel(Color color) {
        setOpaque(true);
        setFocusable(true);
        application.addObserver(this);
        setVisible(true);
        setBackground(color);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    public void askAddTask() {

    }

        public void editATask () {

        }

        public void deleteATask () {
        }


        public void saveFileName () {

        }
        private void writeAll () throws IOException {


        }


    }

