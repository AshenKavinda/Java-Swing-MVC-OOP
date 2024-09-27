package View.FormCashier.component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ControlHintPanelCashier extends JPanel {
    public ControlHintPanelCashier() {
        JButton btn1 =  new JButton("F1");
        btn1.setToolTipText("Focus to item code");
        JButton btn2 =  new JButton("F2");
        btn2.setToolTipText("Focus to item list");
        JButton btn3 =  new JButton("F4");
        btn3.setToolTipText("Create new Bill");
        JButton btn4 =  new JButton("F5");
        btn4.setToolTipText("Previous Bill");
        JButton btn5 =  new JButton("F6");
        btn5.setToolTipText("Next Bill");
        JButton btn6 =  new JButton("F12");
        btn6.setToolTipText("Complete billing");

        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        ArrayList<JButton> list = new ArrayList<>();
        list.add(btn1);
        list.add(btn2);
        list.add(btn3);
        list.add(btn4);
        list.add(btn5);
        list.add(btn6);
        for(JButton item : list) {
            item.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.emptySet());
            item.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, Collections.emptySet());
            this.add(item);
        }
    }
}
