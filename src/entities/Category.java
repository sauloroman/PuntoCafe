package entities;

import java.util.Date;

public class Category {
    
    private int categoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryType;
    private boolean categoryIsActive;
    private Date categoryCreatedAt;
    private Date categoryUpdatedAt;
    
    public Category() {}
    
    // Poliformismo para crear
    public Category(
            String categoryName,
            String categoryDescription,
            String categoryType
    ) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryType = categoryType;
    }
    
    // Poliformismo para obtener
    public Category(
            int categoryId, 
            String categoryName, 
            String categoryDescription,
            String categoryType,
            boolean categoryIsActive, 
            Date categoryCreatedAt, 
            Date categoryUpdatedAt
    ) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryType = categoryType;
        this.categoryIsActive = categoryIsActive;
        this.categoryCreatedAt = categoryCreatedAt;
        this.categoryUpdatedAt = categoryUpdatedAt;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public boolean getIsActive() {
        return categoryIsActive;
    }

    public void setIsActive(boolean categoryIsActive) {
        this.categoryIsActive = categoryIsActive;
    }

    public Date getCategoryCreatedAt() {
        return categoryCreatedAt;
    }

    public void setCategoryCreatedAt(Date categoryCreatedAt) {
        this.categoryCreatedAt = categoryCreatedAt;
    }

    public Date getCategoryUpdatedAt() {
        return categoryUpdatedAt;
    }

    public void setCategoryUpdatedAt(Date categoryUpdatedAt) {
        this.categoryUpdatedAt = categoryUpdatedAt;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription=" + categoryDescription + ", categoryIsActive=" + categoryIsActive + ", categoryCreatedAt=" + categoryCreatedAt + ", categoryUpdatedAt=" + categoryUpdatedAt + '}';
    }
    
}
