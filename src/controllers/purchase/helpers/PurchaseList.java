package controllers.purchase.helpers;

import entities.PurchaseItem;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import views.components.Card;
import views.purchases.PurchasesCreateBuy;

public class PurchaseList {
    
    private final PurchasesCreateBuy view;
    private final List<PurchaseItem> items = new ArrayList<>();
    private Consumer<PurchaseItem> onDelete;
    
    public PurchaseList(PurchasesCreateBuy view) {
        this.view = view;
    }
    
    public void setOnDelete(Consumer<PurchaseItem> listener) {
        this.onDelete = listener;
    }
    
    public List<PurchaseItem> getItems() {
        return this.items;
    }
    
    public void addItem(PurchaseItem item) {
        
        PurchaseItem existing = findItemById(item);
        
        if ( existing != null ) {
            existing.setQuantity(item.getQuantity());
            existing.setPrice(item.getPrice());
        } else {
            items.add(item);
        }
        
        render();
    }
    
    public void removeItem( int id) {
        items.removeIf(i -> i.getProduct().getProductId() == id);
        render();
    }
    
    public PurchaseItem findItemById( PurchaseItem item ) {
        for( PurchaseItem i: items ) {
            if ( i.getProduct().getProductId() == item.getProduct().getProductId() && i.getClass().equals(item.getClass())) {
                return i;
            }
        }
        return null;
    }
    
    public void clearList() {
        items.clear();
    }
    
    private void render() {
        view.productsInPurchase.removeAll();
        
        Card card = new Card();
        
        for( PurchaseItem item: items ) {
            view.productsInPurchase.add(
                    card.createMinimalSaleItemCard(item, onDelete)
            );
        }
        
        view.productsInPurchase.revalidate();
        view.productsInPurchase.repaint();
    }
}
