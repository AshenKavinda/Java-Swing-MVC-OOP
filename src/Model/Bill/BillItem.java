package Model.Bill;

public class BillItem {
    private int stockID;
    private String itemCode;
    private String itemName;
    private String unit;
    private float sellPrice;
    private float quantity;

    public BillItem() {
    }

    public BillItem(int stockID, String itemCode, String itemName, String unit, float sellPrice, float quantity) {
        this.stockID = stockID;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unit = unit;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BillItem{" +
                "stockID=" + stockID +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", unit='" + unit + '\'' +
                ", sellPrice=" + sellPrice +
                ", quantity=" + quantity +
                '}';
    }
}
