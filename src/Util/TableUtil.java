package Util;

import javax.swing.table.DefaultTableModel;

public class TableUtil {


    public void printTableModel(DefaultTableModel tableModel) {
        int rowCount = tableModel.getRowCount();
        int columnCount = tableModel.getColumnCount();

        // Print column names
        for (int col = 0; col < columnCount; col++) {
            System.out.print(tableModel.getColumnName(col) + "\t");
        }
        System.out.println();

        // Print rows
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                System.out.print(tableModel.getValueAt(row, col) + "\n");
            }
            System.out.println();
        }
    }

}
