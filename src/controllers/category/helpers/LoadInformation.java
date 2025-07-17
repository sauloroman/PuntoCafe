package controllers.category.helpers;

import entities.Category;
import java.awt.Color;
import views.warehouse.WarehouseEditCategory;
import views.warehouse.WarehouseInfoCategory;

public class LoadInformation {
    
    private final WarehouseInfoCategory infoView;
    private final WarehouseEditCategory editView;

    public LoadInformation(WarehouseInfoCategory infoView, WarehouseEditCategory editView) {
        this.infoView = infoView;
        this.editView = editView;
    }

    public void load(Category category) {        
        infoView.categoryInfoId.setText( category.getCategoryId() + "" );
        infoView.categoryInfoName.setText( category.getCategoryName() );
        infoView.categoryInfoDesc.setText( category.getCategoryDescription() );
        infoView.categoryInfoType.setText( category.getCategoryType() );
        infoView.categoryInfoStatus.setText( category.getIsActive() ? "Activo" : "Inactivo" );
        infoView.categoryInfoCreatedAt.setText( category.getCategoryCreatedAt() + "" );
        infoView.categoryInfoCreatedAt.setText( category.getCategoryUpdatedAt() + "" );
        setColorTypeLabel(category.getCategoryType());
    }
    
    public void loadEdit(Category category) {
        editView.categoryNameTxt.setText( category.getCategoryName() );
        editView.categoryDescTxt.setText( category.getCategoryDescription() );
        String categoryType = category.getCategoryType();
        String formattedType = categoryType.substring(0, 1).toUpperCase() + categoryType.substring(1).toLowerCase();
        editView.categoryTypeCombo.setSelectedItem(formattedType);
    }
    
    private void setColorTypeLabel(String categoryType) {
        switch (categoryType.toLowerCase()) {
            case "platillo" -> infoView.categoryInfoType.setBackground(Color.decode("#009688"));
            case "producto" -> infoView.categoryInfoType.setBackground(Color.decode("#3F51B5"));
        }
    }
    
}
