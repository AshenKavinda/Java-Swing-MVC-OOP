package View.FormSupplier.Component;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class SearchPanel extends JPanel {

    private final JTextField txtSearch;
    private final JButton btnSearch;
    private final JComboBox<String> comboSearchBy;

    public SearchPanel() {
        ComboBoxModel<String> searchType = new DefaultComboBoxModel<>(new String[]{"SearchBy", "ByName","ByNIC"});
        this.txtSearch = new JTextField(15);
        this.btnSearch = new JButton("Search");
        this.comboSearchBy = new JComboBox<>(searchType);

        this.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        //style
        txtSearch.setColumns(15);

        comboSearchBy.setModel(searchType);

        btnSearch.setText("Search");
        btnSearch.setActionCommand("search");

        this.add(comboSearchBy);
        this.add(txtSearch);
        this.add(btnSearch);
    }

    public JComboBox<String> getComboSearchBy() {
        return comboSearchBy;
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }
}
