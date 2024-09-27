package View.FormStock.Component;

import javax.swing.*;
import java.awt.*;

public class ButtonEditorActive extends DefaultCellEditor {
    private final JButton btnEdit;
    private final JButton btnOut;
    private final JPanel panel;

    public ButtonEditorActive(JCheckBox checkBox) {
        super(checkBox);
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
        btnEdit = new JButton("E");
        btnEdit.setActionCommand("rowEdit");
        btnOut = new JButton("D");
        btnOut.setActionCommand("rowOut");

        panel.add(btnEdit);
        panel.add(btnOut);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnOut() {
        return btnOut;
    }
}


