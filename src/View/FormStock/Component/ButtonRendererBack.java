package View.FormStock.Component;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ButtonRendererBack extends JPanel implements TableCellRenderer {

    public ButtonRendererBack() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        removeAll();

        JButton btnBack = new JButton("Back");
        this.add(btnBack);

        revalidate();
        repaint();
        return this;
    }
}
