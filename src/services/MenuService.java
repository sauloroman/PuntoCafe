package services;

import entities.Menu;
import entities.MenuDetail;
import models.MenuDetailModel;
import models.MenuModel;

public class MenuService {
    
    private final MenuModel menuModel;
    private final MenuDetailModel menuDetailModel;

    public MenuService(MenuModel menuModel, MenuDetailModel menuDetailModel) {
        this.menuModel = menuModel;
        this.menuDetailModel = menuDetailModel;
    }
    
    public Menu saveMenu(Menu menu) {
        return menuModel.saveMenu(menu);
    }
    
    public boolean saveMenuDetail(MenuDetail menuDetail) {
        return menuDetailModel.saveMenuDetail(menuDetail);
    }
    
}
