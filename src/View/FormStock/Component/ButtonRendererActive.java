package View.FormStock.Component;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ButtonRendererActive extends JPanel implements TableCellRenderer {

    public ButtonRendererActive() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Clear previous buttons (if any)
        removeAll();

        // Create buttons
        JButton btnEdit = new JButton("E");
        JButton btnOut = new JButton("D");

        // Add buttons to the panel
        add(btnEdit);
        add(btnOut);

        // Repaint to ensure it is rendered correctly
        revalidate();
        repaint();

        return this;
    }
}
