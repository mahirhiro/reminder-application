package main.view.buttons;

import main.controller.ClearButtonAction;
import main.view.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ClearButton extends JMenuItem {
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setToolTipText("Clear the screen");
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        setPreferredSize(new Dimension(140, 20));
        setIconTextGap(-10);
    }

    public ClearButton(AppPanel panel) {
        super(new ClearButtonAction(panel));
        setButtonProperties();
    }
}
