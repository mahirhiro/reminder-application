package main.view.buttons;

import main.controller.AddTaskAction;
import main.view.AppPanel;

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
        setPreferredSize(new Dimension(100, 20));
        setIconTextGap(-10);
    }

    public AddTaskButton(AppPanel panel) {
        super(new AddTaskAction(panel));
        setButtonProperties();
    }
}
