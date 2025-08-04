package views.warehouse;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;
import views.components.Table;

public class WarehouseMenuEditInit {
    
    private final WarehouseMenuEdit view;
    private final Button buttonGenerator = new Button();
    private final Input inputGenerator = new Input();
    private final ImageCustom imageGenerator = new ImageCustom();

    public WarehouseMenuEditInit(WarehouseMenuEdit view) {
        this.view = view;
    }
    
    public void init() {
        Table.tableStyle3(view.dishesTable);
        
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        buttonGenerator.solidButton(view.btnSearch, ViewConstants.blackColor, ViewConstants.whiteColor, 11);
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 16);
        buttonGenerator.solidButton(view.btnChangeDishes, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnChangeDishes, "icon-save", 16);
        buttonGenerator.outlineButton(view.btnCancelSaveMenu, ViewConstants.errorColor, ViewConstants.errorColor);
        buttonGenerator.addIcon(view.btnCancelSaveMenu, "icon-left-red", 16);
    
        imageGenerator.addImageFix(view.iconRh, "logo-rh", 50, 50);
    
        inputGenerator.roundedField(view.searchDishTxt, "#DDDDDD", 10, "Busca platillos por nombre");
    
        view.dishesInMenu.setLayout(new BoxLayout(view.dishesInMenu, BoxLayout.Y_AXIS));
        view.dishesInMenu.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        
        JScrollPane scroll = new JScrollPane(view.dishesInMenu);
        scroll.setPreferredSize(new Dimension(300, 430));
        
        view.dishesInMenuParent.setLayout(new BorderLayout());
        view.dishesInMenuParent.add(scroll, BorderLayout.CENTER);
        
        scroll.setBorder(null);
        view.dishesInMenuParent.setBorder(null);
    }
    
}
