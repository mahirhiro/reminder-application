package view.buttons;

import controller.SaveAction;
import view.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SaveButton extends JMenuItem {

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        setToolTipText("Save");
        setIconTextGap(-10);
        setPreferredSize(new Dimension(100, 20));
    }

    public SaveButton(AppPanel panel) {
        super(new SaveAction(panel));
        setButtonProperties();

    }
}

