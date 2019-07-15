package model;

import java.util.Observable;
import java.util.Observer;

public class App extends Observable implements Observer {

    public App(String title,String description) {
    }

    public void refresh(){
        setChanged();
        notifyObservers();
    }

    @Override
    public void update(Observable o, Object arg) {
        refresh();
    }
}
