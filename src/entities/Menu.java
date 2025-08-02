package entities;

public class Menu {
    
    private int menuId;
    private String menuName;
    private String menuDescription;
    private String menuStartDate;
    private String menuEndDate;
    private String menuCreatedAt;
    private String menuUpdatedAt;
    private boolean isActive;

    public Menu() {}

    public Menu(
            String menuName, 
            String menuDescription, 
            String menuStartDate, 
            String menuEndDate
    ) {
        this.menuName = menuName;
        this.menuDescription = menuDescription;
        this.menuStartDate = menuStartDate;
        this.menuEndDate = menuEndDate;
    }
    
    public Menu(
            int menuId,
            String menuName, 
            String menuDescription, 
            String menuStartDate, 
            String menuEndDate
    ) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuDescription = menuDescription;
        this.menuStartDate = menuStartDate;
        this.menuEndDate = menuEndDate;
    }

    public Menu(
            int menuId, 
            String menuName, 
            String menuDescription, 
            String menuStartDate, 
            String menuEndDate, 
            String menuCreatedAt,
            String menuUpdatedAt, 
            boolean isActive
    ) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuDescription = menuDescription;
        this.menuStartDate = menuStartDate;
        this.menuEndDate = menuEndDate;
        this.menuCreatedAt = menuCreatedAt;
        this.menuUpdatedAt = menuUpdatedAt;
        this.isActive = isActive;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public String getMenuStartDate() {
        return menuStartDate;
    }

    public void setMenuStartDate(String menuStartDate) {
        this.menuStartDate = menuStartDate;
    }

    public String getMenuEndDate() {
        return menuEndDate;
    }

    public void setMenuEndDate(String menuEndDate) {
        this.menuEndDate = menuEndDate;
    }

    public String getMenuUpdatedAt() {
        return menuUpdatedAt;
    }

    public void setMenuUpdatedAt(String menuUpdatedAt) {
        this.menuUpdatedAt = menuUpdatedAt;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getMenuCreatedAt() {
        return menuCreatedAt;
    }

    public void setMenuCreatedAt(String menuCreatedAt) {
        this.menuCreatedAt = menuCreatedAt;
    }
}
