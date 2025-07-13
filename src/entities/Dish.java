package entities;

import java.util.Date;

public class Dish {
    
    private int dishID; 
    private String dishName;
    private String dishDescription;
    private String dishImage;
    private Double dishSellingPrice;
    private boolean dishIsActive;
    private Date dishCreatedAt;
    private Date dishUpdatedAt;
    private int categoryId;
    
    public Dish(){}

    public Dish(
            int dishId, 
            String dishName, 
            String dishDescription, 
            String dishImage, 
            Double dishSellingPrice, 
            boolean dishIsActive, 
            Date dishCreatedAt, 
            Date dishUpdatedAt, 
            int categoryId
    ) {
        this.dishID = dishId;
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.dishImage = dishImage;
        this.dishSellingPrice = dishSellingPrice;
        this.dishIsActive = dishIsActive;
        this.dishCreatedAt = dishCreatedAt;
        this.dishUpdatedAt = dishUpdatedAt;
        this.categoryId = categoryId;
    }

    public Dish(
            String dishName, 
            String dishDescription, 
            String dishImage, 
            Double dishSellingPrice, 
            int categoryId
    ) {
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.dishImage = dishImage;
        this.dishSellingPrice = dishSellingPrice;
        this.categoryId = categoryId;
    }

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public String getDishImage() {
        return dishImage;
    }

    public void setDishImage(String dishImage) {
        this.dishImage = dishImage;
    }

    public Double getDishSellingPrice() {
        return dishSellingPrice;
    }

    public void setDishSellingPrice(Double dishSellingPrice) {
        this.dishSellingPrice = dishSellingPrice;
    }

    public boolean getIsActive() {
        return dishIsActive;
    }

    public void setIsActive(boolean dishIsActive) {
        this.dishIsActive = dishIsActive;
    }

    public Date getDishCreatedAt() {
        return dishCreatedAt;
    }

    public void setDishCreatedAt(Date dishCreatedAt) {
        this.dishCreatedAt = dishCreatedAt;
    }

    public Date getDishUpdatedAt() {
        return dishUpdatedAt;
    }

    public void setDishUpdatedAt(Date dishUpdatedAt) {
        this.dishUpdatedAt = dishUpdatedAt;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    } 

    @Override
    public String toString() {
        return "Dish{" + "dishID=" + dishID + ", dishName=" + dishName + ", dishDescription=" + dishDescription + ", dishImage=" + dishImage + ", dishSellingPrice=" + dishSellingPrice + ", dishIsActive=" + dishIsActive + ", dishCreatedAt=" + dishCreatedAt + ", dishUpdatedAt=" + dishUpdatedAt + ", categoryId=" + categoryId + '}';
    }
    
}
