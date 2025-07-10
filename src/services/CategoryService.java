package services;

import entities.Category;
import java.util.List;
import models.CategoryModel;
import utils.enums.SearchCriteriaEnum;

public class CategoryService {

    private final CategoryModel model;
    
    public CategoryService(CategoryModel model) {
        this.model = model;
    }
    
    public List<Category> getAll() {
        List<Category> categories = model.listItems("");
        return categories;
    }
    
    public List<Category> getProductCategories() {
        List<Category> productsCategories = model.listItems("producto");
        return productsCategories;
    }
    
    public List<Category> getDishesCategories() {
        List<Category> productsCategories = model.listItems("platillo");
        return productsCategories;
    }
    
    public Category getByName(String categoryName) {
        Category category = model.getItemByName(categoryName);
        return category;
    }
    
    public Category getById( int categoryId ) {
        Category category = model.getItemById(categoryId);
        return category;
    }
    
    public boolean saveCategory(Category category) {
        return model.saveItem(category);
    }
    
    public int getTotal() {
        return model.getTotalItems();
    }
    
    public List<Category> listByPage(String filter, SearchCriteriaEnum criteria, int page, int perPage) {
        List<Category> categories = model.listItemsByPage(filter, criteria, page, perPage);
        return categories;
    }
    
    public int getTotalByFilter(String filter, SearchCriteriaEnum criteria ) {
        return model.getTotalItemsByFilter(filter, criteria);
    }
    
    public boolean updateCategory(Category category, int categoryId) {
        return model.updateItem(category, categoryId);
    }
    
    public boolean activateCategory( int categoryId ) {
        return model.changeStatus(categoryId, true);
    }
    
    public boolean deactivateCategory( int categoryId ) {
        return model.changeStatus(categoryId, false);
    }
    
}
