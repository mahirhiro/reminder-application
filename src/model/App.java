package model;

import java.util.Observable;
import java.util.Observer;

public class App extends Observable implements Observer {

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    private int priority;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public App(String title,String description,int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public App() {

    }

    @Override
    public String toString() {
        String object = title + "," + description + "," + priority;
        return object;
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
