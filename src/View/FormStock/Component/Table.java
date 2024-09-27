package View.FormStock.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Table extends JPanel {

    private final JTable tblStock = new JTable();
    public Table(){
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(20,20,20,20));
        if (tblStock != null){
            tblStock.setRowHeight(30);

        }
        JScrollPane jScrollPane = new JScrollPane(tblStock);
        this.add(jScrollPane,BorderLayout.CENTER);
    }

    public JTable getTblStock() {
        return tblStock;
    }
}
