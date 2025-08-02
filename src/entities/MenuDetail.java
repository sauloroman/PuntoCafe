package entities;

public class MenuDetail {
    
    private int menuDetailId;
    private String menuDetailDate;
    private int dishId;
    private int menuId;

    public MenuDetail() {}

    public MenuDetail(
            String menuDetailDate, 
            int dishId, 
            int menuId
    ) {
        this.menuDetailDate = menuDetailDate;
        this.dishId = dishId;
        this.menuId = menuId;
    }

    public MenuDetail(
            int menuDetailId, 
            String menuDetailDate,
            int dishId, 
            int menuId
    ) {
        this.menuDetailId = menuDetailId;
        this.menuDetailDate = menuDetailDate;
        this.dishId = dishId;
        this.menuId = menuId;
    }

    public int getMenuDetailId() {
        return menuDetailId;
    }

    public void setMenuDetailId(int menuDetailId) {
        this.menuDetailId = menuDetailId;
    }

    public String getMenuDetailDate() {
        return menuDetailDate;
    }

    public void setMenuDetailDate(String menuDetailDate) {
        this.menuDetailDate = menuDetailDate;
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
