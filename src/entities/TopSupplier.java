package entities;

public class TopSupplier {
    
    private String supplierName;
    private String supplierLastname;
    private double totalInversion;

    public TopSupplier(String supplierName, String supplierLastname, double totalInversion) {
        this.supplierName = supplierName;
        this.supplierLastname = supplierLastname;
        this.totalInversion = totalInversion;
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

    public double getTotalInversion() {
        return totalInversion;
    }

    public void setTotalInversion(double totalInversion) {
        this.totalInversion = totalInversion;
    }
    
}
