package controllers.menu.helpers;

import java.util.List;
import java.util.function.Consumer;
import entities.Menu;
import views.components.Card;
import views.warehouse.WarehouseMenus;

public class MenuGrid {
    
    private final WarehouseMenus view;
    private Consumer<Menu> onEditClickButton;
    private Consumer<Menu> onSeeMoreInformation;
    private final Card card;
    
    public MenuGrid(
            WarehouseMenus view, 
            Card card
    ) {
        this.view = view;
        this.card = card;
    }
    
    public void setOnEditClickButton(Consumer<Menu> listener) {
        this.onEditClickButton = listener;
    }
    
    public void setOnSeeMoreInformation(Consumer<Menu> listener) {
        this.onSeeMoreInformation = listener;
    }
    
    public void showMenus(List<Menu> menus) {
        clearGrid();
        for( Menu menu: menus ) {
            addMenuToGrid(menu);
        }
    }
    
    private void addMenuToGrid( Menu menu ) {
        view.menuGrid.add(card.createMenuCard(
                menu, 
                onSeeMoreInformation, 
                onEditClickButton
        ));
    }
    
    private void clearGrid() {
        view.menuGrid.removeAll();
        view.menuGrid.revalidate();
        view.menuGrid.repaint();
    }
    
}
