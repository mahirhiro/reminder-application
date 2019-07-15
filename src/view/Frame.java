package view;

import model.App;
import view.buttons.*;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        panel.setLayout(new BorderLayout());

        JMenuBar jmb = new JMenuBar();
        JMenu file = new JMenu("File");

        /* adding the buttons for the 'file' menu */
        file.add(new SaveButton(application, panel));
        file.addSeparator();
        file.add(new LoadButton(application, panel));
        file.addSeparator();
        file.add(new ExitButton(application));

        jmb.add(file);
        jmb.add(Box.createHorizontalGlue());
        

        JToolBar jtb = new JToolBar();
        jtb.setFloatable(false);
        jtb.setRollover(true);
        jtb.add(new AddTaskButton(application,panel));
        jtb.addSeparator();
        jtb.add(new EditTaskButton(application,panel));
        jtb.addSeparator();
        jtb.add(new DeleteTaskButton(application,panel));

        this.add(jtb, BorderLayout.PAGE_START);


        //String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        JLabel label = new JLabel(date,SwingConstants.RIGHT);
        jmb.add(label,BorderLayout.NORTH);




        this.setJMenuBar(jmb);
        this.getContentPane().add(panel);

        this.pack();
        this.setLocationRelativeTo (null); // Center on screen.
        this.setVisible(true);
    }
}
