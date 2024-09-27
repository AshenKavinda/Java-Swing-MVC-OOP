package View.FormSalesReport.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelBottom extends JPanel {

    private final JLabel lblCostValue;
    private final JLabel lblIncomeValue;
    private final JLabel lblProfitValue;
    public PanelBottom() {

        Font font1 = new Font("Arial",Font.BOLD,20);
        Font font2 = new Font("Arial",Font.PLAIN,18);

        JPanel panel = new JPanel(new GridLayout(2,3));
        panel.setBorder(new EmptyBorder(10,30,10,30));
        JLabel lblCost = new JLabel("Total Cost");
        lblCost.setFont(font1);
        lblCostValue = new JLabel("........");
        lblCostValue.setFont(font2);
        JLabel lblIncome = new JLabel("Total Income");
        lblIncome.setFont(font1);
        lblIncomeValue = new JLabel("........");
        lblIncomeValue.setFont(font2);
        JLabel lblProfit = new JLabel("Total Profit");
        lblProfit.setFont(font1);
        lblProfitValue = new JLabel("........");
        lblProfitValue.setFont(font2);

        panel.add(lblCost);
        panel.add(lblIncome);
        panel.add(lblProfit);
        panel.add(lblCostValue);
        panel.add(lblIncomeValue);
        panel.add(lblProfitValue);
        this.setLayout(new BorderLayout());
        this.add(panel);

    }

    public JLabel getLblCostValue() {
        return lblCostValue;
    }

    public JLabel getLblIncomeValue() {
        return lblIncomeValue;
    }

    public JLabel getLblProfitValue() {
        return lblProfitValue;
    }
}
