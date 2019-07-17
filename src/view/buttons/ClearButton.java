package view.buttons;

import controller.ClearButtonAction;
import controller.DeleteTaskAction;
import model.App;
import view.AppPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ClearButton extends JMenuItem {
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setToolTipText("Delete a Task");
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        setPreferredSize(new Dimension(140,20));
        setIconTextGap (-10);
    }

    public ClearButton(App application, AppPanel panel){
        super(new ClearButtonAction(application, panel));
        setButtonProperties();
    }
}
