package model;

import java.util.ArrayList;

public class Obj {

    private ArrayList<App> Objects = new ArrayList<App>();

    public Obj() {
    }

    public void addTodo(App to) {
        Objects.add(to);
        //sortObjects();
    }
    public void sortObjects() {
       // Collections.sort(Objects);
    }
    public int getSize(){
        return Objects.size();
    }
    public App getObject(int i){
        return Objects.get(i);
    }
}
