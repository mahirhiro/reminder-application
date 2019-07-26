package main.view.buttons;

import main.controller.ExitAction;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ExitButton extends JMenuItem {

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        setToolTipText("Exit application");
        setIconTextGap(-10);
    }

    public ExitButton() {
        super(new ExitAction());
        setButtonProperties();
    }
}
