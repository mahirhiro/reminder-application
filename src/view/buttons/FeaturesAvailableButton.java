package view.buttons;

import controller.FeaturesAvailableAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class FeaturesAvailableButton extends JMenuItem {

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
        setToolTipText("Features available to use");
        setPreferredSize(new Dimension(120, 20));
        setIconTextGap(-10);
    }

    public FeaturesAvailableButton() {
        super(new FeaturesAvailableAction());
        setButtonProperties();
    }
}
