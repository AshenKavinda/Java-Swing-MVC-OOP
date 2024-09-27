package View.FormSupplier.Component;

import javax.swing.*;
import java.awt.*;

public class ButtonEditorActive extends DefaultCellEditor {
    private final JButton btnEdit;
    private final JButton btnDelete;
    private final JPanel panel;

    public ButtonEditorActive(JCheckBox checkBox) {
        super(checkBox);
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
        btnEdit = new JButton("E");
        btnEdit.setActionCommand("edit");
        btnDelete = new JButton("D");
        btnDelete.setActionCommand("delete");

        panel.add(btnEdit);
        panel.add(btnDelete);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }
}


