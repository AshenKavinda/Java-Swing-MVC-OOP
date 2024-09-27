package View.FormCashier;

import View.FormCashier.component.*;
import View.LogIn.FormLogIn;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class FormCashierDesigner extends JFrame {
    private InputPanelCashier inputPanel;
    private TablePanelCashier tablePanelCashier;
    private DescriptionPanelCashier descriptionPanelCashier;
    private ControlHintPanelCashier controlHintPanel;
    private PanelUserDetails panelUserDetails;
    public FormCashierDesigner() throws HeadlessException, SQLException {
        super("Cashier");
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

        setSize(800,600);
        setLocationRelativeTo(null);
    }

    private void closeOperation() throws SQLException {
        this.dispose();
        new FormLogIn();
    }

    public void initializeComponent() {

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.9;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel inputSection = new JPanel(new BorderLayout());
        inputSection.setBorder(new EmptyBorder(10,10,10,10));
        inputPanel = new InputPanelCashier();
        inputSection.add(inputPanel,BorderLayout.CENTER);
        this.add(inputSection,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel tablePanelSection = new JPanel(new BorderLayout());
        tablePanelCashier = new TablePanelCashier();
        tablePanelSection.add(tablePanelCashier,BorderLayout.CENTER);
        tablePanelSection.setBackground(Color.YELLOW);
        this.add(tablePanelSection,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel controlHintSection = new JPanel(new BorderLayout());
        controlHintSection.setBackground(Color.red);
        controlHintPanel = new ControlHintPanelCashier();
        controlHintSection.add(controlHintPanel,BorderLayout.CENTER);
        this.add(controlHintSection,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.panelUserDetails = new PanelUserDetails();
        JPanel panelUserDetails = new JPanel(new BorderLayout());
        panelUserDetails.add(this.panelUserDetails,BorderLayout.WEST);
        this.add(panelUserDetails,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 2 ;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel descriptionPanelSection = new JPanel(new BorderLayout());
        descriptionPanelSection.setBackground(Color.orange);
        descriptionPanelCashier = new DescriptionPanelCashier();
        descriptionPanelSection.add(descriptionPanelCashier,BorderLayout.CENTER);
        this.add(descriptionPanelSection,gbc);

        this.setVisible(true);
    }

    public InputPanelCashier getInputPanel() {
        return inputPanel;
    }

    public TablePanelCashier getTablePanelCashier() {
        return tablePanelCashier;
    }

    public DescriptionPanelCashier getDescriptionPanelCashier() {
        return descriptionPanelCashier;
    }

    public ControlHintPanelCashier getControlHintPanel() {
        return controlHintPanel;
    }

    public PanelUserDetails getPanelUserDetails() {
        return panelUserDetails;
    }
}
