package services;

import entities.Menu;
import entities.MenuDetail;
import java.util.List;
import models.MenuDetailModel;
import models.MenuModel;

public class MenuService {
    
    private final MenuModel menuModel;
    private final MenuDetailModel menuDetailModel;

    public MenuService(MenuModel menuModel, MenuDetailModel menuDetailModel) {
        this.menuModel = menuModel;
        this.menuDetailModel = menuDetailModel;
    }
    
    public int getQuantityMenus() {
        return menuModel.getQuantityMenus();
    }
    
    public List<Menu> getAllMenus(int page, int quantity) {
        return menuModel.getMenus(page, quantity);
    }
    
    public Menu saveMenu(Menu menu) {
        return menuModel.saveMenu(menu);
    }
    
    public boolean saveMenuDetail(MenuDetail menuDetail) {
        return menuDetailModel.saveMenuDetail(menuDetail);
    }
    
    public List<MenuDetail> getMenuDetail(int menuId) {
        return menuDetailModel.getMenuDetail(menuId);
    }
    
    public List<Menu> getMenusByName(String name) {
        return menuModel.getMenusByName(name);
    }
    
    public Menu getMenuByName(String name) {
        return menuModel.getByName(name);
    }
    
    public List<Menu> getMenusByStatus(String statusSelected) {
        boolean status = statusSelected.equals("Activo");
        return menuModel.getMenusByStatus(status);
    }
    
    public boolean activateMenu(int menuId) {
        return menuModel.changeStatus(menuId, true);
    }
    
    public boolean deactivateMenu(int menuId) {
        return menuModel.changeStatus(menuId, false);
    }
    
    public boolean updateMenu( int menuId, Menu menu ) {
        return menuModel.updateMenu(menuId, menu);
    }
    
    public boolean deleteDishesFromMenu( int menuId ) {
        return menuDetailModel.deleteDishesFromMenu(menuId);
    }
    
}
