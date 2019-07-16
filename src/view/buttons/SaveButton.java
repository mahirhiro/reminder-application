package view.buttons;

import controller.SaveAction;
import model.App;
import model.Obj;
import view.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SaveButton extends JMenuItem {

    private void setButtonProperties(){
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        setToolTipText("Save");
        setIconTextGap (-10);
        setPreferredSize(new Dimension(100,20));
    }

    public SaveButton(App application, AppPanel panel, Obj obj) {
        super(new SaveAction(application,panel,obj));
        setButtonProperties();

    }
}

