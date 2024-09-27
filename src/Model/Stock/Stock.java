package Model.Stock;

public class Stock {
    private int stockID;
    private String itemCode;
    private String itemName;
    private String unit;
    private float quantity;
    private float costPrice;
    private float sellPrice;
    private int outOfStockLimit;
    private String category;
    private float returnCount;
    private int stockStatus;
    private int supplierID;

    public Stock() {

    }

    public Stock(String itemCode, String itemName, String unit, int quantity, float costPrice, float sellPrice, int outOfStockLimit, String category, int supplierID) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unit = unit;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
        this.outOfStockLimit = outOfStockLimit;
        this.category = category;
        this.supplierID = supplierID;
    }

    public Stock(int recordID, String itemCode, String itemName, String unit, int quantity, float costPrice, float sellPrice, int outOfStockLimit, String category, float returnCount, int supplierID) {
        this.stockID = recordID;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unit = unit;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
        this.outOfStockLimit = outOfStockLimit;
        this.category = category;
        this.returnCount = returnCount;
        this.supplierID = supplierID;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getOutOfStockLimit() {
        return outOfStockLimit;
    }

    public void setOutOfStockLimit(int outOfStockLimit) {
        this.outOfStockLimit = outOfStockLimit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getReturnCount() {
        return returnCount;
    }

    public void setReturnCount(float returnCount) {
        this.returnCount = returnCount;
    }

    public int getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(int stockStatus) {
        this.stockStatus = stockStatus;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockID=" + stockID +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", unit='" + unit + '\'' +
                ", quantity=" + quantity +
                ", costPrice=" + costPrice +
                ", sellPrice=" + sellPrice +
                ", outOfStockLimit=" + outOfStockLimit +
                ", category='" + category + '\'' +
                ", returnCount=" + returnCount +
                ", stockStatus=" + stockStatus +
                '}';
    }
}
