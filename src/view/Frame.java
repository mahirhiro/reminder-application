package view;

import model.App;
import model.Obj;
import model.SimpleModel;
import view.buttons.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import static java.awt.Color.DARK_GRAY;
import static java.awt.Color.white;
import static javax.swing.Box.createRigidArea;
import static javax.swing.BoxLayout.X_AXIS;

public class Frame extends JFrame {

    private App application;
    private  Obj obj;
    private SimpleModel sm;

    public Frame(App application) {
        this.application = application;
        this.setTitle("ToDo List");

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(400,600));

        this.setResizable(true);

        AppPanel mainPanel = new AppPanel(application, DARK_GRAY);
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        JScrollPane scrollPane = new JScrollPane();
        JPanel recentEventPanel = new JPanel();
        recentEventPanel.setBackground(Color.DARK_GRAY);
        recentEventPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Recent Events", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
        recentEventPanel.setBounds(5, 24, 390, 295);
        mainPanel.add(recentEventPanel);

        JPanel panel2 = new JPanel();
        panel2.setBackground(DARK_GRAY);

        GroupLayout gl_recentEventPanel = new GroupLayout(recentEventPanel);
        gl_recentEventPanel.setHorizontalGroup(
                gl_recentEventPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, gl_recentEventPanel.createSequentialGroup()
                                .addGroup(gl_recentEventPanel.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(panel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
                                .addContainerGap())
        );
        gl_recentEventPanel.setVerticalGroup(
                gl_recentEventPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_recentEventPanel.createSequentialGroup()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

//        mainPanel.getTable().getColumnModel().getColumn(0).setPreferredWidth(119);
//        mainPanel.getTable().getColumnModel().getColumn(1).setPreferredWidth(76);
        scrollPane.setViewportView(mainPanel.getTable());
        mainPanel.getTable().setFont(new Font("Tahoma", Font.BOLD, 12));
        mainPanel.getTable().setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "            PRIORITY", "EVENT", "DATE"
                }
        ));
        panel2.setLayout(null);
        mainPanel.add(panel2);


        JMenuBar jmb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        setJMenuBar(jmb);


        /* adding the buttons for the 'file' menu */
        file.add(new SaveButton(application, mainPanel,obj));
        file.addSeparator();
        file.add(new LoadButton(application, mainPanel));
        file.addSeparator();
        file.add(new ExitButton(application));

        edit.add(new AddTaskButton(application,mainPanel));
        edit.addSeparator();
        edit.add(new EditTaskButton(application,mainPanel));
        edit.addSeparator();
        edit.add(new DeleteTaskButton(application,mainPanel));

        jmb.add(file);
        jmb.add(edit);
        jmb.add(Box.createHorizontalGlue());



        JToolBar jtb = new JToolBar();
        jtb.setFloatable(false);
        jtb.setRollover(true);
        jtb.add(new AddTaskButton(application,mainPanel));
        jtb.addSeparator();
        jtb.add(new EditTaskButton(application,mainPanel));
        jtb.addSeparator();
        jtb.add(new DeleteTaskButton(application,mainPanel));

        //this.add(jtb, BorderLayout.PAGE_START);


        //String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        JLabel label = new JLabel(date,SwingConstants.LEFT);
        jmb.add(label,BorderLayout.NORTH);

        DefaultTableModel model = (DefaultTableModel) mainPanel.getTable().getModel();


        mainPanel.getModel().addRow(new Object[]{         "              hk", 34, 3});
        mainPanel.getTable().setModel(mainPanel.getModel());

        this.setJMenuBar(jmb);
        this.pack();
        this.setLocationRelativeTo (null); // Center on screen.
        this.setVisible(true);
    }

}
