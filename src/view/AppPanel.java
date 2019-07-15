package view;

import model.App;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class AppPanel extends JPanel implements Observer {

    private App application;

    public AppPanel(App application) {
        this.application = application;
        setOpaque(true);
        setFocusable(true);
        application.addObserver(this);
        setVisible(true);
        //setBackground(Color.BLACK);

    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    public void askAddTask() {

    }

    public void editATask() {

    }

    public void deleteATask() {
    }
}
