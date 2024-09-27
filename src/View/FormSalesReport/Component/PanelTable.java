package View.FormSalesReport.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelTable extends JPanel {

    private final JTable table;
    public PanelTable(){
        this.table = new JTable();
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(20,20,20,20));
        table.setRowHeight(30);
        JScrollPane jScrollPane = new JScrollPane(table);
        this.add(jScrollPane,BorderLayout.CENTER);
    }

    public JTable getTable() {
        return table;
    }
}
