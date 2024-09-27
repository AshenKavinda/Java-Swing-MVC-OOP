package Model.Bill;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bill {
    private int billID;
    private float total;
    private float cash;
    private int cashierID;
    private LocalDateTime dateTime;
    private final ArrayList<BillItem> itemList;

    public Bill() {
        this.itemList = new ArrayList<>();
        this.total = 0;
    }

    public void addItem(BillItem billItem) {
        itemList.add(billItem);
        this.total += (billItem.getSellPrice()*billItem.getQuantity());
    }

    public void deleteItem(int index) {
        BillItem item = getItemList().get(index);
        float price = item.getSellPrice()*item.getQuantity();
        this.total -= price;
        getItemList().remove(index);
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public float getTotal() {
        return total;
    }

    public float getCash() {
        return cash;
    }

    public void setCash(float cash) {
        this.cash = cash;
    }

    public int getCashierID() {
        return cashierID;
    }

    public void setCashierID(int cashierID) {
        this.cashierID = cashierID;
    }

    public ArrayList<BillItem> getItemList() {
        return itemList;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void display() {
        System.out.println("********************************");
        String basic = "Bill{" +
                ", billID=" + billID +
                ", total=" + total +
                ", cashierID=" + cashierID +
                ", DateTime=" + dateTime +
                '}';
        System.out.println(basic);
        System.out.println("-------------------------------");
        for(BillItem item : itemList) {
            System.out.println(item.toString());
        }
        System.out.println("*********************************");
    }

    public void printTxt() {
        String directoryPath = "C:\\Users\\HP\\Desktop\\bill\\"; //***fill path***


        String fileName = directoryPath + "Bill_" + billID + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Bill ID: " + billID + "\n");
            writer.write("Cashier ID: " + cashierID + "\n");
            writer.write("Date: " + dateTime + "\n");
            writer.write("------------------------------------\n");
            writer.write(String.format("%-10s %-15s %-5s %-6s %-6s %6s%n",
                    "Item Code",
                    "Name",
                    "Unit",
                    "Price",
                    "Quantity",
                    "subtotal"));
            writer.write("----------------------------------------------\n");

            for (BillItem item : itemList) {
                float subtotal = item.getSellPrice() * item.getQuantity();
                writer.write(String.format("%-10s %-15s %-5s %-7.2f %-9.2f %.2f%n",
                        item.getItemCode(),
                        item.getItemName(),
                        item.getUnit(),
                        item.getSellPrice(),
                        item.getQuantity(),
                        subtotal));
            }

            writer.write("------------------------------------\n");
            writer.write(String.format("Total: %.2f%n", total));
            writer.write(String.format("Cash: %.2f%n", cash));
            writer.write(String.format("Balance: %.2f%n", cash - total));
            writer.write("====================================\n");

            System.out.println("Bill printed to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while printing the bill.");
            e.printStackTrace();
        }
    }
}
