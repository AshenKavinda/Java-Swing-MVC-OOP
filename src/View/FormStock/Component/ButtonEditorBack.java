package View.FormStock.Component;

import javax.swing.*;
import java.awt.*;

public class ButtonEditorBack extends DefaultCellEditor {
    private final JButton btnBack;
    private final JPanel panel;
    public ButtonEditorBack(JCheckBox checkBox) {
        super(checkBox);
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,2,2));
        btnBack = new JButton("Back");
        btnBack.setActionCommand("back");
        panel.add(btnBack);
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    public JButton getBtnBack() {
        return btnBack;
    }
}
