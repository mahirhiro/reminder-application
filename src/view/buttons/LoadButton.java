package view.buttons;

import controller.LoadAction;
import view.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class LoadButton extends JMenuItem {

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        setToolTipText("Save");
        setIconTextGap(-10);
        setPreferredSize(new Dimension(100, 20));
    }

    public LoadButton(AppPanel panel) {
        super(new LoadAction(panel));
        setButtonProperties();

    }
}
