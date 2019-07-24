package view;


import model.JTableUtilities;
import view.buttons.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.awt.Color.DARK_GRAY;

public class Frame extends JFrame {


    public Frame() {

        AppPanel mainPanel = new AppPanel(DARK_GRAY);
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        JScrollPane scrollPane = new JScrollPane();
        JPanel recentEventPanel = new JPanel();
        recentEventPanel.setBackground(Color.DARK_GRAY);
        recentEventPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "TODO List", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
        recentEventPanel.setBounds(10, 24, 540, 285);
        mainPanel.add(recentEventPanel);

        JPanel panel2 = new JPanel();
        panel2.setBackground(DARK_GRAY);

        /* This sets the layout of the JTable on the panel */
        GroupLayout gl_recentEventPanel = new GroupLayout(recentEventPanel);
        gl_recentEventPanel.setHorizontalGroup(
                gl_recentEventPanel.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(GroupLayout.Alignment.TRAILING, gl_recentEventPanel.createSequentialGroup()
                                .addGroup(gl_recentEventPanel.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(panel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
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

        scrollPane.setViewportView(mainPanel.getTable());
        mainPanel.getTable().setFont(new Font("Tahoma", Font.PLAIN, 12));
        mainPanel.getTable().setFillsViewportHeight(true);
        panel2.setLayout(null);
        mainPanel.add(panel2);

        /* Adding the menuBar to the top of the frame */
        JMenuBar jmb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenuItem help = new JMenu("Help");
        setJMenuBar(jmb);

        /* Adding the buttons for the 'file' menu */
        file.add(new SaveButton(mainPanel));
        file.addSeparator();
        file.add(new LoadButton(mainPanel));
        file.addSeparator();
        file.add(new ExitButton());

        /* adding the buttons for the 'exit' menu */
        edit.add(new AddTaskButton(mainPanel));
        edit.addSeparator();
        edit.add(new EditTaskButton(mainPanel));
        edit.addSeparator();
        edit.add(new DeleteTaskButton(mainPanel));
        edit.addSeparator();
        edit.add(new ClearButton(mainPanel));

        /* adding the buttons for the 'help' menu */
        help.add(new FeaturesAvailableButton());

        jmb.add(file);
        jmb.add(edit);
        jmb.add(help);
        jmb.add(Box.createHorizontalGlue());


        /* This is just some extra feature to see the date on the top right corner of the screen */
        String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        JLabel label = new JLabel(date,SwingConstants.LEFT);
        jmb.add(label,BorderLayout.NORTH);

        /* This adds the model which holds the table of the panel onto the mainPanel */
        mainPanel.getTable().setModel(mainPanel.getModel());

        /* This part center's the information on the screen */
        JTableUtilities.setCellsAlignment(mainPanel.getTable(), SwingConstants.CENTER);

        /* This part sets the layout for the dimensions and other necessary features */
        this.setTitle("ToDo List");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(550, 400));
        this.setResizable(false);
        this.setJMenuBar(jmb);
        this.pack();
        this.setLocationRelativeTo (null); // Center on screen.
        this.setVisible(true);

    }

}
