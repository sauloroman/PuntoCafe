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
    
}
