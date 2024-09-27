package View.FormSupplier;
import View.FormStock.FormStock;
import View.FormSupplier.Component.InputControllerPanel;
import View.FormSupplier.Component.SearchPanel;
import View.FormSupplier.Component.Table;
import View.FormSupplier.Component.SupplierTextFieldPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class FormSupplierDesigner extends JFrame {
    private final SearchPanel searchPanel;
    private final Table supplierTable;
    private final SupplierTextFieldPanel textFieldPanel;
    private final InputControllerPanel inputControllerPanel;
    public FormSupplierDesigner() {
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                try {
                    new FormStock();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //component
        searchPanel = new SearchPanel();
        supplierTable = new Table();
        textFieldPanel = new SupplierTextFieldPanel();
        inputControllerPanel = new InputControllerPanel();
        initializeComponent();
    }

    public void initializeComponent() {


        //layout
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        //panel
        JPanel mainPanel = new JPanel(gbl);

        JPanel searchPanel1 = new JPanel(new BorderLayout());

        JPanel tablePanel = new JPanel(new BorderLayout());

        JPanel inputHeaderPanel = new JPanel(new BorderLayout());

        JPanel inputFieldPanel =  new JPanel(new BorderLayout());

        JPanel inputFieldControl = new JPanel(new BorderLayout());

        mainPanel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.9;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        searchPanel1.add(searchPanel,BorderLayout.CENTER);
        //searchPanel.setBackground(Color.BLACK);
        mainPanel.add(searchPanel1,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.weighty = 0.9;
        gbc.fill = GridBagConstraints.BOTH;
        tablePanel.setBackground(Color.BLUE);
        tablePanel.add(supplierTable,BorderLayout.CENTER);
        mainPanel.add(tablePanel,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1 ;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        JLabel header = new JLabel("INPUT");
        header.setFont(new Font("arial",Font.BOLD,20));
        inputHeaderPanel.add(header,BorderLayout.CENTER);
        mainPanel.add(inputHeaderPanel,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        inputFieldPanel.add(textFieldPanel,BorderLayout.CENTER);
        mainPanel.add(inputFieldPanel,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        inputFieldControl.add(inputControllerPanel,BorderLayout.CENTER);
        mainPanel.add(inputFieldControl,gbc);


        this.add(mainPanel,BorderLayout.CENTER);
        this.setVisible(true);
    }

    public SearchPanel getSearchPanel() {
        return searchPanel;
    }

    public Table getSupplierTable() {
        return supplierTable;
    }

    public SupplierTextFieldPanel getTextFieldPanel() {
        return textFieldPanel;
    }

    public InputControllerPanel getInputControllerPanel() {
        return inputControllerPanel;
    }
}
