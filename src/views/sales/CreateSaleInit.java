package views.sales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Input;

public class CreateSaleInit {
    
    private final CreateSale view;
    private final Button buttonGenerator = new Button(); 
    private final Input inputGenerator = new Input();

    public CreateSaleInit(CreateSale view) {
        this.view = view;
    }
    
    public void init() {
        view.setExtendedState(MAXIMIZED_BOTH);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        Font tabFont = new Font("sansserif", Font.BOLD, 12 );
        view.navigationPane.setFont( tabFont );
        view.navigationPane.setSelectedIndex(0);
        view.navigationPane.setEnabledAt(0, true);
        
        view.titleSale.setBackground(Color.decode(ViewConstants.mainColor));
        view.titleSale.setForeground(Color.decode("#FFFFFF"));
        
        buttonGenerator.solidButton(view.btnSearch, ViewConstants.blackColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 16);
        buttonGenerator.solidButton(view.btnSearchDish, ViewConstants.blackColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnSearchDish, "icon-search", 16);
        
        buttonGenerator.solidButton(view.btnSaveSale, ViewConstants.skyColor, "#FFFFFF", 18);
        buttonGenerator.addIcon(view.btnSaveSale, "icon-save", 30);
        
        inputGenerator.roundedField(view.searchProductTxt, "#DDDDDD", 10, "Busca productos por su nombre");
        inputGenerator.roundedComboBox(view.pageCombo, "#DDDDDD", 10);
        inputGenerator.roundedField(view.searchDishTxt, "#DDDDDD", 10, "Busca platillos por su nombre");
        inputGenerator.roundedComboBox(view.pageComboDish, "#DDDDDD", 10);
        
        view.saleList.setLayout(new BoxLayout(view.saleList, BoxLayout.Y_AXIS));
        view.saleList.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        JScrollPane scroll = new JScrollPane(view.saleList);
        scroll.setPreferredSize(new Dimension(330, 500));

        view.saleListParent.setLayout(new BorderLayout());
        view.saleListParent.add(scroll, BorderLayout.CENTER);
        
        scroll.setBorder(null);
        view.saleList.setBorder(null);
        view.saleListParent.setBorder(null);
    }
    
}

