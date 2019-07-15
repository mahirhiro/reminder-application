package view.buttons;

import controller.AddTaskAction;
import model.App;
import view.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AddTaskButton extends JMenuItem {
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setToolTipText("Add a Task");
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        setPreferredSize(new Dimension(100,20));
    }

    public AddTaskButton(App application, AppPanel panel){
        super(new AddTaskAction(application, panel));
        setButtonProperties();
    }
}
