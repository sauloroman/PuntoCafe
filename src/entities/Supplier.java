package entities;

import java.util.Date;

public class Supplier {

    private int supplierId;
    private String supplierName;
    private String supplierLastname;
    private String supplierCompany;
    private String supplierPhone;
    private String supplierEmail;
    private String supplierAddress;
    private boolean supplierIsActive;
    private Date supplierCreatedAt;
    private Date supplierUpdatedAt;

    public Supplier() {}

    public Supplier(
            String supplierName, 
            String supplierLastname, 
            String supplierCompany, 
            String supplierPhone, 
            String supplierEmail, 
            String supplierAddress
    ) {
        this.supplierName = supplierName;
        this.supplierLastname = supplierLastname;
        this.supplierCompany = supplierCompany;
        this.supplierPhone = supplierPhone;
        this.supplierEmail = supplierEmail;
        this.supplierAddress = supplierAddress;
    }
    
    public Supplier(
        int supplierId,
        String supplierName,
        String supplierLastname,
        String supplierCompany,
        String supplierPhone,
        String supplierEmail,
        String supplierAddress,
        boolean supplierIsActive,
        Date supplierCreatedAt,
        Date supplierUpdatedAt
    ) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierLastname = supplierLastname;
        this.supplierCompany = supplierCompany;
        this.supplierPhone = supplierPhone;
        this.supplierEmail = supplierEmail;
        this.supplierAddress = supplierAddress;
        this.supplierIsActive = supplierIsActive;
        this.supplierCreatedAt = supplierCreatedAt;
        this.supplierUpdatedAt = supplierUpdatedAt;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierLastname() {
        return supplierLastname;
    }

    public void setSupplierLastname(String supplierLastname) {
        this.supplierLastname = supplierLastname;
    }

    public String getSupplierCompany() {
        return supplierCompany;
    }

    public void setSupplierCompany(String supplierCompany) {
        this.supplierCompany = supplierCompany;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public boolean getSupplierIsActive() {
        return supplierIsActive;
    }

    public void setSupplierIsActive(boolean supplierIsActive) {
        this.supplierIsActive = supplierIsActive;
    }

    public Date getSupplierCreatedAt() {
        return supplierCreatedAt;
    }

    public void setSupplierCreatedAt(Date supplierCreatedAt) {
        this.supplierCreatedAt = supplierCreatedAt;
    }

    public Date getSupplierUpdatedAt() {
        return supplierUpdatedAt;
    }

    public void setSupplierUpdatedAt(Date supplierUpdatedAt) {
        this.supplierUpdatedAt = supplierUpdatedAt;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", supplierLastname='" + supplierLastname + '\'' +
                ", supplierCompany='" + supplierCompany + '\'' +
                ", supplierPhone='" + supplierPhone + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", supplierIsActive=" + supplierIsActive +
                ", supplierCreatedAt=" + supplierCreatedAt +
                ", supplierUpdatedAt=" + supplierUpdatedAt +
                '}';
    }
}
