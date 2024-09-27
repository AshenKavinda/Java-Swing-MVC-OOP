package Model.Supplier;

public class Supplier {
    private int supplierID ;
    private String name;
    private String nic;
    private String phone1;
    private String phone2;
    private String email;
    private int isActive;

    public Supplier() {
        this.supplierID = -1;
    }

    public Supplier(int supplierID, String name, String nic, String phone1, String phone2, String email, int isActive) {
        this.supplierID = supplierID;
        this.name = name;
        this.nic = nic;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.isActive = isActive;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
