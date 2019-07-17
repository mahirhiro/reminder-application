package view.buttons;

import controller.EditTaskAction;
import model.App;
import view.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class EditTaskButton extends JMenuItem{
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setToolTipText("Edit a Task");
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        setPreferredSize(new Dimension(100,20));
        setIconTextGap (-10);
    }

    public EditTaskButton(App application, AppPanel panel){
        super(new EditTaskAction(application, panel));
        setButtonProperties();
    }
}

