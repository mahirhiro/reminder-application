package view.buttons;

import controller.ExitAction;
import model.App;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ExitButton extends JMenuItem {

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        setToolTipText("Exit and save");
        setIconTextGap (-10);
    }

    public ExitButton(App application){
        super(new ExitAction(application));
        setButtonProperties();
    }
}
