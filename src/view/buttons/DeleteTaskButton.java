package view.buttons;

import controller.DeleteTaskAction;
import view.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class DeleteTaskButton extends JMenuItem {
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setToolTipText("Delete a Task");
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        setPreferredSize(new Dimension(140, 20));
        setIconTextGap(-10);
    }

    public DeleteTaskButton(AppPanel panel) {
        super(new DeleteTaskAction(panel));
        setButtonProperties();
    }
}
