package View.FormSalesReport;

import View.FormSalesReport.Component.PanelBottom;
import View.FormSalesReport.Component.PanelTable;
import View.FormSalesReport.Component.PanelTopBar;
import View.LogIn.FormLogIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class FormSalesReportDesigner extends JFrame {

    private final PanelTopBar panelTopBar;
    private final PanelTable panelTable;
    private final PanelBottom panelSummery;
    public FormSalesReportDesigner() throws HeadlessException {
        this.setSize(800,700);

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

        this.setLocationRelativeTo(null);

        this.panelTopBar = new PanelTopBar();
        this.panelTable = new PanelTable();
        this.panelSummery = new PanelBottom();

        initializeComponent();
    }

    public void initializeComponent() {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gbl);

        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(panelTopBar,gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.6;
        gbc.fill = GridBagConstraints.BOTH;
        panelTable.setBackground(Color.black);
        this.add(panelTable,gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.3;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(panelSummery,gbc);

        this.setVisible(true);
    }

    public PanelTopBar getPanelTopBar() {
        return panelTopBar;
    }

    public PanelTable getPanelTable() {
        return panelTable;
    }

    public PanelBottom getPanelSummery() {
        return panelSummery;
    }
}
