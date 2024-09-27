package View.FormStock;
import View.FormStock.Component.InputControllerPanel;
import View.FormStock.Component.SearchPanel;
import View.FormStock.Component.Table;
import View.FormStock.Component.TextFieldPanel;
import View.LogIn.FormLogIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class FormStockDesigner extends JFrame {
    private final SearchPanel searchPanel;
    private final Table stockTable;
    private final TextFieldPanel textFieldPanel;
    private final InputControllerPanel inputControllerPanel;
    private final JButton btnSupplier;
    public FormStockDesigner() {
        this.setSize(900,600);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                try {
                    new FormLogIn();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //component
        searchPanel = new SearchPanel();
        stockTable = new Table();
        textFieldPanel = new TextFieldPanel();
        inputControllerPanel = new InputControllerPanel();

        btnSupplier = new JButton("SUPPLIER");
        btnSupplier.setActionCommand("supplier");
        btnSupplier.setFocusPainted(false);

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
        tablePanel.add(stockTable,BorderLayout.CENTER);
        mainPanel.add(tablePanel,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1 ;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel header = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));
        JLabel lblHeader = new JLabel(">>>");
        JLabel lblInput = new JLabel("INPUT");
        lblHeader.setFont(new Font("arial",Font.BOLD,20));
        lblInput.setFont(new Font("arial",Font.BOLD,20));
        header.add(lblHeader);
        header.add(btnSupplier);
        inputHeaderPanel.add(header,BorderLayout.EAST);
        inputHeaderPanel.add(lblInput,BorderLayout.WEST);
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

    public Table getStockTable() {
        return stockTable;
    }

    public TextFieldPanel getTextFieldPanel() {
        return textFieldPanel;
    }

    public InputControllerPanel getInputControllerPanel() {
        return inputControllerPanel;
    }

    public JButton getBtnSupplier() {
        return btnSupplier;
    }
}
