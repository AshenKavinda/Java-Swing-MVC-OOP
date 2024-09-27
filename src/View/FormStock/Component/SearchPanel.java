package View.FormStock.Component;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {

    private final JTextField txtSearch;
    private final JButton btnSearch;
    private final JComboBox<String> comboSearchBy;
    private final JComboBox<String> comboFilter;

    public SearchPanel() {
        ComboBoxModel<String> filerType = new DefaultComboBoxModel<>(new String[]{"Active","Stock Out","HasReturn","Low Stock"});
        ComboBoxModel<String> searchType = new DefaultComboBoxModel<>(new String[]{"SearchBy", "ByName","ByCode"});
        this.txtSearch = new JTextField(15);
        this.btnSearch = new JButton("Search");
        btnSearch.setFocusPainted(false);
        this.comboSearchBy = new JComboBox<>(searchType);
        this.comboFilter = new JComboBox<>(filerType);

        txtSearch.setColumns(15);

        comboSearchBy.setModel(searchType);

        comboFilter.setModel(filerType);

        btnSearch.setText("Search");
        btnSearch.setActionCommand("search");


        JPanel searchSection = new JPanel();
        searchSection.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        searchSection.add(comboSearchBy);
        searchSection.add(txtSearch);
        searchSection.add(btnSearch);


        JPanel filterSection = new JPanel();
        filterSection.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
        filterSection.add(comboFilter);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gbl);

        gbc.gridx = 0;
        gbc.weightx = 0.7;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(searchSection,gbc);

        gbc.gridx = 1 ;
        gbc.weightx = 0.3 ;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(filterSection,gbc);
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JComboBox<String> getComboSearchBy() {
        return comboSearchBy;
    }

    public JComboBox<String> getComboFilter() {
        return comboFilter;
    }
}
