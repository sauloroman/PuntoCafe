package interfaces;

public interface SaleItem<T> {
    T getItem();
    void setItem(T item);
    int getQuantity();
    void setQuantity( int quantity );
    double getDiscount();
    void setDiscount( double discount );  
    String getImage();
    String getName();
    Double getSellingPrice();
    int getId();
    boolean getIsActive();
}
