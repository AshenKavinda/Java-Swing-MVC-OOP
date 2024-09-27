package View.FormUser.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Table extends JPanel {

    private final JTable tblUser;
    public Table(){
        this.tblUser = new JTable();
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(20,20,20,20));
        tblUser.setRowHeight(30);
        JScrollPane jScrollPane = new JScrollPane(tblUser);
        this.add(jScrollPane,BorderLayout.CENTER);
    }

    public JTable getTblUser() {
        return tblUser;
    }
}
