package View.FormSalesReport.Component;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class PanelTopBar extends JPanel {

    private JButton btnGo;
    private JButton btnPrint;
    private JDatePickerImpl datePickerStart;
    private JDatePickerImpl datePickerEnd;
    public PanelTopBar() {

        JLabel lblStartDate = new JLabel("Start Date");
        lblStartDate.setFont(new Font("Arial",Font.BOLD,15));
        JLabel lblEndDate = new JLabel("End Date");
        lblEndDate.setFont(new Font("Arial",Font.BOLD,15));
        this.btnGo = new JButton("GO");
        this.btnGo.setActionCommand("go");
        this.btnPrint = new JButton("Print");
        this.btnPrint.setActionCommand("print");

        // Create UtilDateModel
        UtilDateModel modelStart = new UtilDateModel();
        UtilDateModel modelEnd = new UtilDateModel();

        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");

        // Create DatePanel and DatePicker
        JDatePanelImpl datePanelStart = new JDatePanelImpl(modelStart, properties);
        this.datePickerStart = new JDatePickerImpl(datePanelStart, new DateLabelFormatter());

        JDatePanelImpl datePanelEnd = new JDatePanelImpl(modelEnd, properties);
        this.datePickerEnd = new JDatePickerImpl(datePanelEnd, new DateLabelFormatter());


        JPanel panelSearch = new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));
        panelSearch.add(lblStartDate);
        panelSearch.add(datePickerStart);
        panelSearch.add(lblEndDate);
        panelSearch.add(datePickerEnd);
        panelSearch.add(btnGo);


        JPanel panelPrint = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,5));
        panelPrint.add(btnPrint);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gbl);

        gbc.gridx = 0;
        gbc.weightx = 0.9;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(panelSearch,gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(panelPrint,gbc);
    }

    // Formatter class for the DatePicker
    static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private final String datePattern = "yyyy-MM-dd";
        private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }
            return "";
        }
    }

    public JButton getBtnGo() {
        return btnGo;
    }

    public JButton getBtnPrint() {
        return btnPrint;
    }

    public JDatePickerImpl getDatePickerStart() {
        return datePickerStart;
    }

    public JDatePickerImpl getDatePickerEnd() {
        return datePickerEnd;
    }
}
