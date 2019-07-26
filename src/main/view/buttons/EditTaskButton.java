package main.view.buttons;

import main.controller.EditTaskAction;
import main.view.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class EditTaskButton extends JMenuItem {
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setToolTipText("Edit a Task");
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        setPreferredSize(new Dimension(100, 20));
        setIconTextGap(-10);
    }

    public EditTaskButton(AppPanel panel) {
        super(new EditTaskAction(panel));
        setButtonProperties();
    }
}

