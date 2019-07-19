package view;

import model.App;
import view.buttons.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.awt.Color.DARK_GRAY;

public class Frame extends JFrame {


    public Frame(App application) {
        this.setTitle("ToDo List");

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(550,400));

        this.setResizable(false);

        AppPanel mainPanel = new AppPanel(application, DARK_GRAY);
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        JScrollPane scrollPane = new JScrollPane();
        JPanel recentEventPanel = new JPanel();
        recentEventPanel.setBackground(Color.DARK_GRAY);
        recentEventPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Recent Events", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
        recentEventPanel.setBounds(10, 24, 540, 285);
        mainPanel.add(recentEventPanel);

        JPanel panel2 = new JPanel();
        panel2.setBackground(DARK_GRAY);

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
        mainPanel.getTable().setFont(new Font("Tahoma", Font.BOLD, 12));
        mainPanel.getTable().setFillsViewportHeight(true);
        //mainPanel.getTable().setModel(new DefaultTableModel(new Object[][]{}, new String[]{"PRIORITY", "EVENT", "DATE"}));
        panel2.setLayout(null);
        mainPanel.add(panel2);

        JMenuBar jmb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu clear = new JMenu("Clear");
        setJMenuBar(jmb);


        /* adding the buttons for the 'file' menu */
        file.add(new SaveButton(application, mainPanel));
        file.addSeparator();
        file.add(new LoadButton(application, mainPanel));
        file.addSeparator();
        file.add(new ExitButton());

        edit.add(new AddTaskButton(mainPanel));
        edit.addSeparator();
        edit.add(new EditTaskButton(application,mainPanel));
        edit.addSeparator();
        edit.add(new DeleteTaskButton(application,mainPanel));

        jmb.add(file);
        jmb.add(edit);
        edit.add(new ClearButton(mainPanel));
        jmb.add(Box.createHorizontalGlue());

//        JToolBar jtb = new JToolBar();
//        jtb.setFloatable(false);
//        jtb.setRollover(true);
//        jtb.add(new AddTaskButton(application,mainPanel));
//        jtb.addSeparator();
//        jtb.add(new EditTaskButton(application,mainPanel));
//        jtb.addSeparator();
        //jtb.add(new DeleteTaskButton(application,mainPanel));

        //this.add(jtb, BorderLayout.PAGE_START);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        mainPanel.getTable().setDefaultRenderer(Integer.class, centerRenderer);

        mainPanel.getDateChooser().setDateFormatString("MM/dd/yyyy");

        String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        JLabel label = new JLabel(date,SwingConstants.LEFT);
        jmb.add(label,BorderLayout.NORTH);

        //mainPanel.getModel().addRow(new Object[]{ 3, "Gym", date});
        mainPanel.getTable().setModel(mainPanel.getModel());

        JTableUtilities.setCellsAlignment(mainPanel.getTable(), SwingConstants.CENTER);
        this.setJMenuBar(jmb);
        this.pack();
        this.setLocationRelativeTo (null); // Center on screen.
        this.setVisible(true);
    }

}
