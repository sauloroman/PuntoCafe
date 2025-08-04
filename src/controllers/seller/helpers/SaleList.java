package controllers.seller.helpers;

import entities.ProductItem;
import interfaces.SaleItem;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import views.components.Card;
import views.sales.CreateSale;

public class SaleList {
    
    private final CreateSale view;
    private final List<SaleItem> items = new ArrayList<>();
    private Consumer<SaleItem> onDelete;

    public SaleList(CreateSale view) {
        this.view = view;
    }
    
    public void setOnDelete(Consumer<SaleItem> listener) {
        this.onDelete = listener;
    }
    
    public List<SaleItem> getItems() {
        return this.items;
    }
    
    public void addItem(SaleItem item) {
        
        SaleItem existing = findItemById(item);
        
        if ( existing != null ) {
            existing.setQuantity(item.getQuantity());
            existing.setDiscount(item.getDiscount());
        } else {
            items.add(item);
        }
        
        render();
    }
    
    public void removeItem( int id, Class<?> type) {
        items.removeIf(i -> i.getId() == id && i.getClass().equals(type));
        render();
    }
    
    public SaleItem findItemById( SaleItem item ) {
        for( SaleItem i: items ) {
            if ( i.getId() == item.getId() && i.getClass().equals(item.getClass())) {
                return i;
            }
        }
        return null;
    }
    
    public void clearList() {
        items.clear();
    }
    
    private void render() {
        view.saleList.removeAll();
        
        Card card = new Card();
        for( SaleItem item: items ) {
            String label = (item instanceof ProductItem) ? "Producto" : "Platillo";
            view.saleList.add(card.createSaleItemCard(
                    item, 
                    item.getQuantity(), 
                    item.getDiscount(), 
                    label, 
                    onDelete
            ));
        }
        
        view.saleList.revalidate();
        view.saleList.repaint();
    }
    
}
