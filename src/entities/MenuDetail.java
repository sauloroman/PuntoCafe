package entities;

public class MenuDetail {
    
    private int menuDetailId;
    private int dishId;
    private int menuId;

    public MenuDetail() {}

    public MenuDetail(
            int dishId, 
            int menuId
    ) {
        this.dishId = dishId;
        this.menuId = menuId;
    }

    public MenuDetail(
            int menuDetailId, 
            int dishId, 
            int menuId
    ) {
        this.menuDetailId = menuDetailId;
        this.dishId = dishId;
        this.menuId = menuId;
    }

    public int getMenuDetailId() {
        return menuDetailId;
    }

    public void setMenuDetailId(int menuDetailId) {
        this.menuDetailId = menuDetailId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }
}
