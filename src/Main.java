import model.App;
import view.Frame;

public class Main  {
    public static void main(String[] args) {
        String inputFile = null;
        /* if an extra argument is given to the terminal, we use it as a file name */

        App application = new App("hi","uo");

        new Frame(application);
    }

}

